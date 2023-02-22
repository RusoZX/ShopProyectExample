package shopServer.Services;

import com.google.protobuf.ByteString;
import generated.General;
import generated.serviceLoginGrpc;
import io.grpc.stub.StreamObserver;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class LoginService extends serviceLoginGrpc.serviceLoginImplBase{
    //We create the object that is gonna work with the data base
    DataBase db = new DataBase();

    @Override
    public void giveResponseLogin(General.ClientPetitionLogin request,
                                  StreamObserver<General.ServerResponseLogin> responseObserver){
        System.out.println("<------------------------------LOGIN REQUEST-------------------------------------------->");
        General.ServerResponseLogin response;
        try{
            //First we show the login data in the log
            String salt = "7xtZt8wF8MLFS2O5eUDINPFdj011aN";
            System.out.println("Login data: \n"+request.getUser()+", "+request.getPwd()+", "+
                    Encryption.generateSecurePassword(request.getPwd(), salt));
            //First we see if the user exists

            if(db.consult("Select idUser from user where nickName = '"+request.getUser()+"'").size() ==0){
                response = General.ServerResponseLogin.newBuilder()
                        .setStatusCode(General.ServerResponseLogin.StatusCode.INCORRECT)
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
                System.out.println("Incorrect");
                //To verify the password we need the encrypted password of the data base
            }else if(!Encryption.verifyUserPassword(request.getPwd(),
                    db.consult("Select pwd from user where idUser = '"+
                            Integer.parseInt(db.consult(
                                    "Select idUser from user where nickName = '"
                                            +request.getUser()+"'").get(0).get(0)
                                            .toString())
                            +"'").get(0).get(0).toString(),
                    salt)){
                response = General.ServerResponseLogin.newBuilder()
                        .setStatusCode(General.ServerResponseLogin.StatusCode.INCORRECT)
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }else{
                ArrayList<ArrayList<Object>> result = db.consult("Select idUser, type, name, imagePath from user" +
                        " where idUser = '"+Integer.parseInt(
                        db.consult("Select idUser from user where nickName = '"+request.getUser()+"'").get(0).get(0)
                                .toString())+"'");
                File photo = new File(result.get(0).get(3).toString());
                byte[] byteArray = new byte[(int) photo.length()];
                new FileInputStream(photo).read(byteArray);
                response= General.ServerResponseLogin.newBuilder()
                        .setStatusCode(General.ServerResponseLogin.StatusCode.OK)
                        .setId(Integer.parseInt(result.get(0).get(0).toString()))
                        .setType(Integer.parseInt(result.get(0).get(1).toString()))
                        .setName(result.get(0).get(2).toString())
                        .setFormat(General.ServerResponseLogin.Format.JPG)
                        .setImage(ByteString.copyFrom(byteArray))
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }


        }catch(Exception e){
            System.out.println("/////////////////////////////////LOGIN ERROR///////////////////////////////////////\n"+
                    e.getLocalizedMessage());
            //As there was some kind of error we create a response with and Status Code explaining to the Client that
            //there was an error in the server
            response = General.ServerResponseLogin.newBuilder()
                    .setStatusCode(General.ServerResponseLogin.StatusCode.SERVER_ERROR)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}

package shopServer.Services;

import generated.General;
import generated.servicePwdChangeGrpc;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;

public class ChangePwdService extends servicePwdChangeGrpc.servicePwdChangeImplBase{
    //We create the object that is gonna work with the data base
    DataBase db = new DataBase();

    @Override
    public void giveResponsePwdChange(General.ClientPetitionPwdChange request,
                                      StreamObserver<General.ServerResponsePwdChange> responseObserver){
        System.out.println("<--------------------------------------PWD CHANGE REQUEST------------------------------->");
        General.ServerResponsePwdChange response;
        String salt = "7xtZt8wF8MLFS2O5eUDINPFdj011aN";
        try{
            System.out.println("REquest:"+request.getOldPwd()+", "+request.getNewPwd()+", "+request.getIdUser());
            if(!Encryption.verifyUserPassword(request.getOldPwd(),
                    db.consult("Select pwd from user where idUser = '"+request.getIdUser() +"'").get(0).get(0).toString(),
                    salt)){
                response = General.ServerResponsePwdChange.newBuilder()
                        .setStatusCode(General.ServerResponsePwdChange.StatusCode.INCORRECT)
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }else{
                db.modify("Update user set pwd = '"+request.getNewPwd()+"';");
                response = General.ServerResponsePwdChange.newBuilder()
                        .setStatusCode(General.ServerResponsePwdChange.StatusCode.OK)
                        .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }

        }catch(Exception e){
            System.out.println("////////////////////////////PWD CHANGE ERROR/////////////////////////////////\n"+
                    e.getLocalizedMessage());
            //As there was some kind of error we create a response with and Status Code explaining to the Client that
            //there was an error in the server
            response = General.ServerResponsePwdChange.newBuilder()
                    .setStatusCode(General.ServerResponsePwdChange.StatusCode.SERVER_ERROR)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}

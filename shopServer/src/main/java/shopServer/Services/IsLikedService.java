package shopServer.Services;

import generated.General;
import generated.serviceIsLikedGrpc;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;

//First we create a class that extends the one generated by the proto file
public class IsLikedService extends serviceIsLikedGrpc.serviceIsLikedImplBase{
    //We create the object that is gonna work with the data base
    DataBase db = new DataBase();

    @Override
    public void giveResponseIsLiked(General.ClientPetitionIsLiked request,
                                    StreamObserver<General.ServerResponseIsLiked> responseObserver){
        System.out.println("<-----------------------------IS LIKED REQUEST-------------------------------------------->");
        General.ServerResponseIsLiked response;
        try {
            System.out.println("Is liked: "+request.getIdUser()+", "+request.getIdProduct());
            ArrayList<ArrayList<Object>> result = db.consult("Select * from likes where idUser = '"+
                    request.getIdUser()+"' and idProduct = '"+request.getIdProduct()+"'");
            System.out.println("Result:"+result.toString());
            response = General.ServerResponseIsLiked.newBuilder().setIsLiked(!result.isEmpty()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        }catch(Exception e){
            System.out.println("////////////////////////////IS LIKED ERROR/////////////////////////////////\n"+
                    e.getLocalizedMessage());
            //As there was some kind of error we create a response with and Status Code explaining to the Client that
            //there was an error in the server
            response = General.ServerResponseIsLiked.newBuilder()
                    .setStatusCode(General.ServerResponseIsLiked.StatusCode.SERVER_ERROR)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}

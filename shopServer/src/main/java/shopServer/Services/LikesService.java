package shopServer.Services;

import generated.General;
import generated.serviceLikeGrpc;
import io.grpc.stub.StreamObserver;

//First we create a class that extends the one generated by the proto file
public class LikesService extends serviceLikeGrpc.serviceLikeImplBase{
    //We create the object that is gonna work with the data base
    DataBase db = new DataBase();

    @Override
    public void giveResponseLike(General.ClientPetitionLike request,
                                 StreamObserver<General.ServerResponseLike> responseObserver){
        System.out.println("<-----------------------------LIKES REQUEST-------------------------------------------->");
        General.ServerResponseLike response;
        try{
            System.out.println("Like: \n"+request.getIdUser()+", "+request.getIdProduct()+", "+request.getDate());
            if(request.getStatusCode()== General.ClientPetitionLike.StatusCode.LIKE)
                db.insert("Insert into likes(idUser, idProduct, date) values('"+request.getIdUser()+
                        "', '"+request.getIdProduct()+"', '"+request.getDate()+"');");
            else
                db.insert("Delete from likes where idUser='"+request.getIdUser()+"' and idProduct='"+
                        request.getIdProduct()+"';");
            response= General.ServerResponseLike.newBuilder()
                    .setStatusCode(General.ServerResponseLike.StatusCode.OK)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        }catch(Exception e){
            System.out.println("////////////////////////////LIKE ERROR/////////////////////////////////\n"+
                    e.getLocalizedMessage());
            //As there was some kind of error we create a response with and Status Code explaining to the Client that
            //there was an error in the server
            response = General.ServerResponseLike.newBuilder()
                    .setStatusCode(General.ServerResponseLike.StatusCode.SERVER_ERROR)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
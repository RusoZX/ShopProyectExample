package shopServer.Services;

import generated.General;
import generated.serviceAddShoppingListGrpc;
import io.grpc.stub.StreamObserver;

public class AddShoppingListService extends serviceAddShoppingListGrpc.serviceAddShoppingListImplBase{
    //We create the object that is gonna work with the data base
    DataBase db = new DataBase();
    @Override
    public void giveResponseAddShoppingList(General.ClientPetitionAddShoppingList request,
                                            StreamObserver<General.ServerResponseAddShoppingList> responseObserver){
        System.out.println("<---------------------------ADD SHOPPING LIST REQUEST---------------------------------->");
        General.ServerResponseAddShoppingList response;
        try{
            System.out.println("Request: "+request.getIdProduct()+", "+request.getIdUser()+", "+request.getQuantity());
            db.insert("Insert into shopinglist(idUser, idProduct, Quantity) values('"+request.getIdUser()+
                    "', '"+request.getIdProduct()+"', '"+request.getQuantity()+"');");
            response = General.ServerResponseAddShoppingList.newBuilder()
                    .setStatusCode(General.ServerResponseAddShoppingList.StatusCode.OK)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(Exception e){
            System.out.println("////////////////////////////ADD SHOPPING LIST ERROR/////////////////////////////////\n"+
                    e.getLocalizedMessage());
            //As there was some kind of error we create a response with and Status Code explaining to the Client that
            //there was an error in the server
            response = General.ServerResponseAddShoppingList.newBuilder()
                    .setStatusCode(General.ServerResponseAddShoppingList.StatusCode.SERVER_ERROR)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}

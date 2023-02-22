package shopServer.Services;

import generated.General;
import generated.serviceUpdateProductGrpc;
import io.grpc.stub.StreamObserver;

public class UpdateProductService extends serviceUpdateProductGrpc.serviceUpdateProductImplBase{
    //We create the object that is gonna work with the data base
    DataBase db = new DataBase();

    @Override
    public void giveResponseUpdateProduct(General.ClientPetitionUpdateProduct request,
                                           StreamObserver<General.ServerResponseUpdateProduct> responseObserver){
        System.out.println("<--------------------CHANGE PRODUCT DATA REQUEST------------------------------------------>");
        General.ServerResponseUpdateProduct response;
        try{
            //Now we show the data input in the log
            System.out.println("Product data: \n"+request.getIdProduct()+", "+request.getName()+", "+request.getPrice()+
                    ", "+request.getSale());
            if(!request.getName().isEmpty())
                db.modify("update product set name ='"+request.getName()+"' where idProduct = '"
                        +request.getIdProduct()+"'");

            if(request.getPrice()!=0)
                db.modify("update product set price ='"+request.getPrice()+
                        "' where idProduct = '"+request.getIdProduct()+"'");
            if(request.getSale()!=-1)
                db.modify("update product set sale ='"+request.getSale()+
                        "' where idProduct = '"+request.getIdProduct()+"'");
            response = General.ServerResponseUpdateProduct.newBuilder()
                    .setStatusCode(General.ServerResponseUpdateProduct.StatusCode.OK)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(Exception e){
            System.out.println("////////////////////////////CHANGE PRODUCT DATA ERROR/////////////////////////////////\n"+
                    e.getLocalizedMessage());
            //As there was some kind of error we create a response with and Status Code explaining to the Client that
            //there was an error in the server
            response = General.ServerResponseUpdateProduct.newBuilder()
                    .setStatusCode(General.ServerResponseUpdateProduct.StatusCode.SERVER_ERROR)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}

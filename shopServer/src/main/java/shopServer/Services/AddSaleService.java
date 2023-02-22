package shopServer.Services;

import generated.General;
import generated.serviceMakeSaleGrpc;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;

//First we create a class that extends the one generated by the proto file
public class AddSaleService extends serviceMakeSaleGrpc.serviceMakeSaleImplBase{
    //We create the object that is gonna work with the data base
    DataBase db = new DataBase();

    @Override
    public void giveResponseMakeSale(General.ClientPetitionMakeSale request ,
                                     StreamObserver<General.ServerResponseMakeSale> responseObserver){
        System.out.println("<-------------------------------MAKE SALE REQUEST----------------------------->");
        General.ServerResponseMakeSale response;
        try{
            //First we put in the log the data received
            System.out.println("New Sale: "+ request.getIdBuyer() +", "+ request.getIdProduct()+", "+
                    request.getQuantity()+", "+request.getDate());
            db.insert("Insert into sales(idUser, idProduct, quantitySold, date) values('"+request.getIdBuyer()+
                    "', '"+request.getIdProduct()+"', '"+request.getQuantity()+"', '"+request.getDate()+"');");
            ArrayList<ArrayList<Object>> consult=db.consult(
                    "Select unitsInExistence, unitsSold from product where idProduct = "+ request.getIdProduct()
                    +";");
            int quantityInExistence = Integer.parseInt(consult.get(0).get(0).toString())-request.getQuantity();
            int quantitySold = Integer.parseInt(consult.get(0).get(1).toString())+request.getQuantity();
            db.modify("Update product set unitsInExistence = '"+quantityInExistence+"', unitsSold = '"+
                    quantitySold+"' where idProduct = "+request.getIdProduct());

            response= General.ServerResponseMakeSale.newBuilder()
                    .setStatusCode(General.ServerResponseMakeSale.StatusCode.OK)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(Exception e){
            System.out.println("/////////////////////////////////MAKE SALE ERROR//////////////////////////////////\n"+
                    e.getLocalizedMessage());
            //As there was some kind of error we create a response with and Status Code explaining to the Client that
            //there was an error in the server
            response = General.ServerResponseMakeSale.newBuilder()
                    .setStatusCode(General.ServerResponseMakeSale.StatusCode.SERVER_ERROR)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}

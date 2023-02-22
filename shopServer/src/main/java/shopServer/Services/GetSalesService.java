package shopServer.Services;

import generated.General;
import generated.serviceSalesGrpc;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;

//First we create a class that extends the one generated by the proto file
public class GetSalesService extends serviceSalesGrpc.serviceSalesImplBase{
    //We create the object that is gonna work with the data base
    DataBase db = new DataBase();

    @Override
    public void giveResponseSales(General.ClientPetitionSales request,
                                     StreamObserver<General.ServerResponseSales> responseObserver) {
        System.out.println("<------------------------GET SALES REQUEST----------------------------->");
        General.ServerResponseSales response;
        try{
            ArrayList<ArrayList<Object>> result;
            //First we display in the log all the data received from the client
            System.out.println("Searching data:\n"+request.getIdProduct()+", "+request.getIdUser()+", "+
                    request.getQuantity()+", "+request.getFirstDay()+", "+request.getLastDay());
            //Now we revise the id of the product, if it is -1 it means that the clients wants to see all the restocks
            if(request.getIdProduct() == -1){
                result= db.consult("Select s.idProduct, s.quantitySold, s.date, p.name, p.imagePath from sales as "
                        +"s "+" inner join product as p on s.idProduct = p.idProduct "+
                        "where s.idUser = '"+request.getIdUser() +"' and s.date between '"+request.getFirstDay()+
                        "' and '"+request.getLastDay() +"' limit " +request.getQuantity()+";");
            }else{
                result= db.consult("Select s.idProduct, s.quantitySold, s.date, p.name, p.imagePath from sales as "
                        + "s inner join product as p on s.idProduct = p.idProduct"+
                        " where idProduct = '"+request.getIdProduct() + "' and s.idUser = '"+request.getIdUser()+
                        "' and s.date between '"+request.getFirstDay()+ "' and '"+request.getLastDay()
                        +"' limit "+request.getQuantity()+";");
            }
            ArrayList<General.Sale> sales = new ArrayList<General.Sale>();
            for(int i =0; i < result.size();i++){
                sales.add(General.Sale.newBuilder()
                        .setIdBuyer(request.getIdUser())
                        .setIdProduct(Integer.parseInt(result.get(i).get(0).toString()))
                        .setQuantity(Integer.parseInt(result.get(i).get(1).toString()))
                        .setDate(result.get(i).get(2).toString())
                        .setName(result.get(i).get(3).toString())
                        .setImagePath(result.get(i).get(4).toString())
                        .build());
            }
            response = General.ServerResponseSales.newBuilder()
                    .setStatusCode(General.ServerResponseSales.StatusCode.OK)
                    .addAllSales(sales)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(Exception e){
            System.out.println("/////////////////////////////////GET SALES ERROR/////////////////////////////////////\n"+
                    e.getLocalizedMessage());
            //As there was some kind of error we create a response with and Status Code explaining to the Client that
            //there was an error in the server
            response = General.ServerResponseSales.newBuilder()
                    .setStatusCode(General.ServerResponseSales.StatusCode.SERVER_ERROR)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }


    }

}

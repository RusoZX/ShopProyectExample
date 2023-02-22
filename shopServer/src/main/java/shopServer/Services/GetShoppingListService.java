package shopServer.Services;

import com.google.protobuf.ByteString;
import generated.General;
import generated.serviceShoppingListGrpc;
import io.grpc.stub.StreamObserver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

public class GetShoppingListService extends serviceShoppingListGrpc.serviceShoppingListImplBase{
    //We create the object that is gonna work with the data base
    DataBase db = new DataBase();
    @Override
    public void giveResponseShoppingList(General.ClientPetitionShoppingList request,
                                         StreamObserver<General.ServerResponseShoppingList> responseObserver){
        System.out.println("<-------------------------------------SHOPPING LIST REQUEST---------------------------->");
        General.ServerResponseShoppingList response;
        try{
            System.out.println("Request: "+request.getIdUser());
            ArrayList<ArrayList<Object>> result= db.consult("Select s.idProduct, s.quantity, p.name, p.price," +
                    " p.sale, p.unitsInExistence, p.unitsSold, p.imagePath, p.category" +
                    " from shopinglist as s inner join product as p on s.idProduct = p.idProduct where s.idUser = '"+
                    request.getIdUser()+"';");
            ArrayList<General.ProductShoppingList> products= new ArrayList<>();
            for(int i = 0; i< result.size();i++){
                File photo = new File(result.get(i).get(7).toString());
                BufferedImage image= ImageIO.read(photo);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image,"jpg",baos);
                byte[] byteArray = baos.toByteArray();
                ArrayList<ArrayList<Object>> likeResult = db.consult("Select * from likes where idUser = '"+
                        request.getIdUser()+"' and idProduct = '"+result.get(i).get(0)+"'");
                System.out.println("Result Likes:"+likeResult.toString());

                products.add(General.ProductShoppingList.newBuilder()
                        .setId(Integer.parseInt(result.get(i).get(0).toString()))
                        .setQuantity(Integer.parseInt(result.get(i).get(1).toString()))
                        .setName(result.get(i).get(2).toString())
                        .setPrice(Float.parseFloat(result.get(i).get(3).toString()))
                        .setSale(Integer.parseInt(result.get(i).get(4).toString()))
                        .setUnitsInExistence(Integer.parseInt(result.get(i).get(5).toString()))
                        .setUnitsSold(Integer.parseInt(result.get(i).get(6).toString()))
                        .setImage(ByteString.copyFrom(byteArray))
                        .setCategory(result.get(i).get(7).toString())
                        .setLiked(!likeResult.isEmpty())
                .build());
            }
            response= General.ServerResponseShoppingList.newBuilder().addAllProducts(products).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(Exception e){
            System.out.println("////////////////////////////SHOPPING LIST ERROR/////////////////////////////////\n"+
                    e.getLocalizedMessage());
            //As there was some kind of error we create a response with and Status Code explaining to the Client that
            //there was an error in the server
            response = General.ServerResponseShoppingList.newBuilder()
                    .setStatusCode(General.ServerResponseShoppingList.StatusCode.SERVER_ERROR)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}

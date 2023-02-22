package shopServer.Services;

import com.google.protobuf.ByteString;
import generated.General;
import generated.serviceLikesListGrpc;
import io.grpc.stub.StreamObserver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;

public class LikesListService extends serviceLikesListGrpc.serviceLikesListImplBase{
    //We create the object that is gonna work with the data base
    DataBase db = new DataBase();
    @Override
    public void giveResponseLikesList(General.ClientPetitionLikesList request,
                                      StreamObserver<General.ServerResponseLikesList> responseObserver){
        General.ServerResponseLikesList response;
        System.out.println("<----------------------------LIKES LIST REQUEST---------------------------->");
        try{
            System.out.println("Request:"+request.toString());
            ArrayList<ArrayList<Object>> result = db.consult("Select p.idProduct, p.name, p.price," +
                    " p.unitsInExistence, p.unitsSold, p.sale, p.imagePath, p.category from product as p " +
                    "left join likes as l on p.idProduct = l.idProduct where l.idUser = '"+
                    request.getIdUser()+"'");
            ArrayList<General.Product> list=new ArrayList<>();
            for(int i = 0; i< result.size(); i++){
                File photo = new File(result.get(0).get(6).toString());
                BufferedImage image= ImageIO.read(photo);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(image,"jpg",baos);
                byte[] byteArray = baos.toByteArray();
                list.add(General.Product.newBuilder()
                        .setId(Integer.parseInt(result.get(i).get(0).toString()))
                        .setName(result.get(i).get(1).toString())
                        .setPrice(Float.parseFloat(result.get(i).get(2).toString()))
                        .setUnitsInExistence(Integer.parseInt(result.get(i).get(3).toString()))
                        .setUnitsSold(Integer.parseInt(result.get(i).get(4).toString()))
                        .setSale(Integer.parseInt(result.get(i).get(5).toString()))
                        .setImage(ByteString.copyFrom(byteArray))
                        .setCategory(result.get(i).get(7).toString())
                        .build());
            }
            System.out.println("Result:"+list.toString());
            response= General.ServerResponseLikesList.newBuilder()
                    .setStatusCode(General.ServerResponseLikesList.StatusCode.OK)
                    .addAllProducts(list)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        }catch(Exception e){
            System.out.println("/////////////////////////////////LIKES LIST ERROR//////////////////////////////////\n"+
                    e.getLocalizedMessage());
            //As there was some kind of error we create a response with and Status Code explaining to the Client that
            //there was an error in the server
            response = General.ServerResponseLikesList.newBuilder()
                    .setStatusCode(General.ServerResponseLikesList.StatusCode.SERVER_ERROR)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}

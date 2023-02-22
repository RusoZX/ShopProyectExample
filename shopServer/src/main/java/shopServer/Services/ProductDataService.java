package shopServer.Services;

import com.google.protobuf.ByteString;
import generated.General;
import generated.serviceProductGrpc;
import io.grpc.stub.StreamObserver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class ProductDataService extends serviceProductGrpc.serviceProductImplBase{
    //We create the object that is gonna work with the data base
    DataBase db = new DataBase();

    @Override
    public void giveResponseProduct(General.ClientPetitionProduct request,
                                    StreamObserver<General.ServerResponseProduct> responseObserver){
        System.out.println("<------------------------PRODUCT DATA REQUEST----------------------------->");
        General.ServerResponseProduct response;
        try{
            //First we make the consult and display the result in the server log
            ArrayList<ArrayList<Object>> productData = db.consult("SELECT name, price, unitsInExistence, unitsSold,"
                    + " sale, imagePath, category FROM product WHERE idProduct = "+ request.getIdProduct()+";");
            System.out.println("Result: "+productData);
            //We create the response of the server and put the result on it
            File photo = new File(productData.get(0).get(5).toString());
            BufferedImage image= ImageIO.read(photo);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image,"jpg",baos);
            byte[] byteArray = baos.toByteArray();

            response= General.ServerResponseProduct.newBuilder()
                    .setName(productData.get(0).get(0).toString())
                    .setPrice(Float.parseFloat(productData.get(0).get(1).toString()))
                    .setUnitsInExistence(Integer.parseInt(productData.get(0).get(2).toString()))
                    .setUnitsSold(Integer.parseInt(productData.get(0).get(3).toString()))
                    .setSale(Integer.parseInt(productData.get(0).get(4).toString()))
                    .setFormat(General.ServerResponseProduct.Format.JPG)
                    .setImage(ByteString.copyFrom(byteArray))
                    .setCategory(productData.get(0).get(6).toString())
                    .setStatusCode(General.ServerResponseProduct.StatusCode.OK)
                    .build();


            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(Exception e){
            System.out.println("/////////////////////////////////PRODUCT DATA ERROR//////////////////////////////////\n"+
                    e.getLocalizedMessage());
            //As there was some kind of error we create a response with and Status Code explaining to the Client that
            //there was an error in the server
            response = General.ServerResponseProduct.newBuilder()
                    .setStatusCode(General.ServerResponseProduct.StatusCode.SERVER_ERROR)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}

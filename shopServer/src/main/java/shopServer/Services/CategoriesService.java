package shopServer.Services;

import generated.General;
import generated.serviceCategoriesGrpc;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;

public class CategoriesService extends serviceCategoriesGrpc.serviceCategoriesImplBase{
    //We create the object that is gonna work with the data base
    DataBase db = new DataBase();
    @Override
    public void giveResponseCategories(General.ClientPetitionCategories request,
                                       StreamObserver<General.ServerResponseCategories> responseObserver){
        System.out.println("<------------------------------CATEGORIES REQUEST---------------------------------->");
        General.ServerResponseCategories response;
        try{
            ArrayList<ArrayList<Object>> list = db.consult("Select distinct category from product;");
            System.out.println("Result:"+list.toString());
            ArrayList<String> resultList = new ArrayList<>();
            for(int i = 0; i<list.size();i++){
                resultList.add(list.get(i).get(0).toString());
            }
            response = General.ServerResponseCategories.newBuilder().addAllCategories(resultList).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }catch(Exception e){
            System.out.println("////////////////////////////CATEGORIES ERROR/////////////////////////////////\n"+
                    e.getLocalizedMessage());
            //As there was some kind of error we create a response with and Status Code explaining to the Client that
            //there was an error in the server
            response = General.ServerResponseCategories.newBuilder()
                    .setStatusCode(General.ServerResponseCategories.StatusCode.SERVER_ERROR)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

}

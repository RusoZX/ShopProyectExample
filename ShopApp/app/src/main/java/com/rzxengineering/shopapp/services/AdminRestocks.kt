package com.rzxengineering.shopapp.services

import com.rzxengineering.shopapp.objects.SaleOrRestock
import com.rzxengineering.shopapp.objects.ServerResponse
import generated.General
import generated.serviceRestocksGrpc
import generated.serviceMakeRestockGrpc
import io.grpc.ManagedChannel
import java.io.File

class AdminRestocks {
    var channel : ManagedChannel = Conexion().channel!!
    fun giveRestocks(idUser:Int,idProduct:Int, quantity:Int, firstDay:String,lastDay:String)
            :ArrayList<SaleOrRestock>{
        var stub= serviceRestocksGrpc.newBlockingStub(channel)
        var request= General.ClientPetitionRestocks.newBuilder()
            .setIdUser(idUser)
            .setIdProduct(idProduct)
            .setQuantity(quantity)
            .setFirstDay(firstDay)
            .setLastDay(lastDay)
            .build()
        var result = stub.giveResponseRestocks(request)
        var array= ArrayList<SaleOrRestock>()
        if(result.statusCodeValue==1){
            var restock = SaleOrRestock(1,-1,-1,-1,
                "","", ByteArray(0),""
            )
            restock.statusCode=1
            array.add(restock)
        }else if(result.statusCodeValue==2){
            var restock = SaleOrRestock(1,-1,-1,-1,
                "","",ByteArray(0),"")
            restock.statusCode=1
            array.add(restock)
        }else
            for (restock in result.restocksList) {
                array.add(
                    SaleOrRestock(
                        0, restock.idOwner, restock.idProduct, restock.quantity, restock.date,
                        restock.name, ByteArray(0),""
                    )
                )
            }

        return array
    }
    fun makeRestock(restock: SaleOrRestock): ServerResponse {
        var stub= serviceMakeRestockGrpc.newBlockingStub(channel)
        var request= General.ClientPetitionMakeRestock.newBuilder()
            .setIdProduct(restock.idUser)
            .setIdProduct(restock.idProduct)
            .setDate(restock.date)
            .setQuantity(restock.quantity)
            .build()
        var response = stub.giveResponseMakeRestock(request)
        return ServerResponse(response.statusCodeValue)
    }
}
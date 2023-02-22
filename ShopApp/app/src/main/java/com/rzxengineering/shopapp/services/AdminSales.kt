package com.rzxengineering.shopapp.services
import com.rzxengineering.shopapp.objects.Product
import com.rzxengineering.shopapp.objects.SaleOrRestock
import com.rzxengineering.shopapp.objects.ServerResponse
import generated.General
import generated.serviceSalesGrpc
import generated.serviceMakeSaleGrpc
import generated.serviceSalesOwnerGrpc
import io.grpc.ManagedChannel
import java.io.File

class AdminSales {
    var channel : ManagedChannel = Conexion().channel!!

    fun giveSales(idUser:Int,idProduct:Int, quantity:Int, firstDay:String,lastDay:String)
    :ArrayList<SaleOrRestock>{
        var stub= serviceSalesGrpc.newBlockingStub(channel)
        var request= General.ClientPetitionSales.newBuilder()
            .setIdUser(idUser)
            .setIdProduct(idProduct)
            .setQuantity(quantity)
            .setFirstDay(firstDay)
            .setLastDay(lastDay)
            .build()
        var result = stub.giveResponseSales(request)
        var array= ArrayList<SaleOrRestock>()
        if(result.statusCodeValue==1){
            var sale = SaleOrRestock(1,-1,-1,-1,
                "","",ByteArray(0),"")
            sale.statusCode=1
            array.add(sale)
        }else if(result.statusCodeValue==2){
            var sale = SaleOrRestock(1,-1,-1,-1,
                "","",ByteArray(0),"")
            sale.statusCode=1
            array.add(sale)
        }else
            for (sale in result.salesList) {
                array.add(
                    SaleOrRestock(
                        0, sale.idBuyer, sale.idProduct, sale.quantity, sale.date,
                        sale.name, sale.imagePath.toByteArray(),""
                    )
                )
            }

        return array
    }
    fun giveSalesOwner(idUser:Int,idProduct:Int, quantity:Int, firstDay:String,lastDay:String)
            :ArrayList<SaleOrRestock>{
        var stub= serviceSalesOwnerGrpc.newBlockingStub(channel)
        var request= General.ClientPetitionSalesOwner.newBuilder()
            .setIdOwner(idUser)
            .setIdProduct(idProduct)
            .setQuantity(quantity)
            .setFirstDay(firstDay)
            .setLastDay(lastDay)
            .build()
        var result = stub.giveResponseSalesOwner(request)
        var array= ArrayList<SaleOrRestock>()
        if(result.statusCodeValue==1){
            var sale = SaleOrRestock(1,-1,-1,-1,
                "","",ByteArray(0),"")
            sale.statusCode=1
            array.add(sale)
        }else if(result.statusCodeValue==2){
            var sale = SaleOrRestock(1,-1,-1,-1,
                "","",ByteArray(0),"")
            sale.statusCode=1
            array.add(sale)
        }else
            for (sale in result.salesList) {
                array.add(
                    SaleOrRestock(
                        0, 0, sale.idProduct, sale.quantity, sale.date,
                        sale.name, sale.image.toByteArray(),sale.nameBuyer
                    )
                )
            }

        return array
    }
    fun makeSale(sale:SaleOrRestock):ServerResponse{
        var stub= serviceMakeSaleGrpc.newBlockingStub(channel)
        var request= General.ClientPetitionMakeSale.newBuilder()
            .setIdProduct(sale.idUser)
            .setIdProduct(sale.idProduct)
            .setDate(sale.date)
            .setQuantity(sale.quantity)
            .build()
        var response = stub.giveResponseMakeSale(request)
        return ServerResponse(response.statusCodeValue)
    }
}
package com.rzxengineering.shopapp.services

import android.util.Log
import com.rzxengineering.shopapp.objects.Like
import com.rzxengineering.shopapp.objects.LikesRequest
import com.rzxengineering.shopapp.objects.Product
import com.rzxengineering.shopapp.objects.ServerResponse
import io.grpc.ManagedChannel
import generated.General
import generated.serviceLikeGrpc
import generated.serviceIsLikedGrpc
import generated.serviceLikesListGrpc
class AdminLikes {
    var channel : ManagedChannel = Conexion().channel!!
    fun like(like: Like): ServerResponse{
        var stub = serviceLikeGrpc.newBlockingStub(channel)
        var request = General.ClientPetitionLike.newBuilder()
            .setIdProduct(like.idProduct)
            .setIdUser(like.idUser)
            .setDate(like.date)
            .setStatusCodeValue(like.statusCode)
            .build()
        var response= stub.giveResponseLike(request)
        return ServerResponse(response.statusCodeValue)

    }
    fun isLiked(like: Like): ServerResponse{
        var stub = serviceIsLikedGrpc.newBlockingStub(channel)
        var request= General.ClientPetitionIsLiked.newBuilder()
            .setIdProduct(like.idProduct)
            .setIdUser(like.idUser)
            .build()
        var response = stub.giveResponseIsLiked(request)
        Log.d("LIKED", response.isLiked.toString())
        if(response.isLiked)
            return ServerResponse(0)

        return ServerResponse(4)
    }
    fun likesList(idUser: Int): ArrayList<Product>{
        var stub = serviceLikesListGrpc.newBlockingStub(channel)
        var request = General.ClientPetitionLikesList.newBuilder()
            .setIdUser(idUser)

            .build()
        var response = stub.giveResponseLikesList(request)
        var list = ArrayList<Product>()
        for(product in response.productsList)
            list.add(Product(
                response.statusCodeValue,product.id, 0,product.name, product.price,
                product.unitsInExistence, product.unitsSold,product.sale, 0,
                product.image.toByteArray(),product.category, true
            ))
        Log.d("LISTITA", list.toString())
        return list
    }
}
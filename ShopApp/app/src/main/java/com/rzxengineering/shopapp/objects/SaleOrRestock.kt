package com.rzxengineering.shopapp.objects

import java.io.File

data class SaleOrRestock(var statusCode:Int,var idUser:Int, var idProduct: Int,
                         var quantity:Int, var date: String, var name:String,
                         var image:ByteArray, var buyerName:String) {
    override fun toString(): String {
        return "IdUser=$idUser, id product=$idProduct, quantity=$quantity, date=$date, name=$name" +
                ", buyer name= $buyerName"
    }
}
package com.rzxengineering.shopapp.objects

import java.io.File

data class Product(var statusCode:Int,var id:Int, var owner:Int,
                   var name:String, var price: Float, var unitsInExistence:Int,
                   var unitsSold:Int, var sale:Int, var format:Int,
                   var image:ByteArray, var category:String, var isLiked:Boolean) {
    override fun toString(): String {
        return "Id=$id, owner=$owner, name=$name, price=$price," +
                " units in existence=$unitsInExistence, units sold=$unitsSold, sale=$sale," +
                "format=$format, category=$category, isLiked=$isLiked"
    }
}
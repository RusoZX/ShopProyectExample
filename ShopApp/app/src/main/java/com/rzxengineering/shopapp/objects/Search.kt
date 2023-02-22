package com.rzxengineering.shopapp.objects

data class Search(var quantity:Int, var sortingMode:Int, var search:String, var idUser:Int) {
    override fun toString(): String {
        return "Quantity=$quantity, Sorting mode=$sortingMode, search=$search, idUser=$idUser"
    }
}
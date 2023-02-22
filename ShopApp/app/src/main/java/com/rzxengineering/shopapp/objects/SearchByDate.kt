package com.rzxengineering.shopapp.objects

data class SearchByDate(var idUser:Int,var idProduct:Int, var quantity:Int, var firstDay:String,
                        var lastDay:String) {
    override fun toString(): String {
        return "IdUser=$idUser, idProduct=$idProduct, Quantity=$quantity, first day =$firstDay" +
                "Last Day=$lastDay"
    }
}
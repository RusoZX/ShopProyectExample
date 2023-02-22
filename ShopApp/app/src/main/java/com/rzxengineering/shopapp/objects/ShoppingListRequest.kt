package com.rzxengineering.shopapp.objects

data class ShoppingListRequest(var idUser:Int, var idProduct:Int, var quantity:Int) {
    override fun toString(): String {
        return "IdUser=$idUser, IdProduct=$idProduct, quantity=$quantity"
    }
}
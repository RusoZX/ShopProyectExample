package com.rzxengineering.shopapp.objects

data class Like(var statusCode:Int,var idUser:Int,var idProduct:Int,
                var date:String) {
    override fun toString(): String {
        return "IdUser=$idUser, idProduct=$idProduct, date=$date"
    }
}
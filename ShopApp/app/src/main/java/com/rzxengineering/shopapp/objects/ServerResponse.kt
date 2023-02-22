package com.rzxengineering.shopapp.objects

data class ServerResponse(var response:Int ) {
    override fun toString(): String {
        when (response){
            0 -> return "OK"
            1->return "Server Error"
            2-> return "Nick Name Exists"
            3-> return "Product Exists"
            4-> return "Not liked"
            5-> return "Pwd dont match"
        }
        return "ERROR"
    }
}
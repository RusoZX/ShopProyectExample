package com.rzxengineering.shopapp.objects

data class PwdChange(var oldPwd:String, var newPwd:String, var idUser:Int) {
    override fun toString(): String {
        return "OldPwd=$oldPwd, NewPwd=$newPwd, IdUser=$idUser"
    }
}
package com.rzxengineering.shopapp.objects

import java.io.File

class UserData(var statusCode:Int, var id: Int, var nickName: String,
               var type:Int, var name: String, var surname:String,
               var phone: String, var address:String, var format:Int,
               var image:ByteArray, var pwd:String) {
    override fun toString(): String {
        return "Id=$id, name=$name, surname=$surname, phone=$phone, address=$address," +
                " nickName0$nickName, type=$type, pwd=$pwd"
    }
}
package com.rzxengineering.shopapp.objects

data class Login(var nickName:String, var pwd:String) {
    override fun toString(): String {
        return "NickName=$nickName, pwd=$pwd"
    }
}
package com.rzxengineering.shopapp.services

import android.util.Log
import com.rzxengineering.shopapp.objects.PwdChange
import com.rzxengineering.shopapp.objects.ServerResponse
import com.rzxengineering.shopapp.objects.UserData
import generated.General
import generated.*
import io.grpc.ManagedChannel
//This class will handle all server services related to a user
class AdminUser {
    var channel : ManagedChannel = Conexion().channel!!

    fun update(user: UserData): ServerResponse {
        var stub= serviceUpdateUserDataGrpc.newBlockingStub(channel)

        var request= General.ClientPetitionUpdateUserData.newBuilder()
            .setIdUser(user.id)
            .setType(user.type)
            .setName(user.name)
            .setSurName(user.surname)
            .setPhone(user.phone)
            .setAddress(user.address)
            .build()
        var response= stub.giveResponseUpdateUserData(request)
        return ServerResponse(response.statusCodeValue)
    }

    fun verify(nickName:String, pwd:String): UserData{
        var stub= serviceLoginGrpc.newBlockingStub(channel)
        var request = General.ClientPetitionLogin.newBuilder().setUser(nickName).setPwd(pwd).build()
        var response= stub.giveResponseLogin(request)
        var user= UserData(1,-1,"",-1,"","","",
        "",-1, ByteArray(0),""
        )
        if(response.statusCodeValue == 1)
            user.statusCode=1
        else if(response.statusCodeValue==2)
            user.statusCode=2
        else
            user = UserData(
                0, response.id, "", response.type, response.name,
                "", "", "", response.formatValue,
                response.image.toByteArray(), "")

        return user
    }
    fun giveData(id:Int): UserData{
        var stub= serviceUserDataGrpc.newBlockingStub(channel)

        var request=General.ClientPetitionUserData.newBuilder().setIdUser(id).build()

        var response = stub.giveResponseUserData(request)

        var user= UserData(1,-1,"",-1,"","","",
            "",-1,ByteArray(0),"")
        if(response.statusCodeValue == 1)
            user.statusCode=1
        else
            user = UserData(
                0, response.id, "", -1, response.name,
                response.surname, response.phone, response.adress, -1,
                ByteArray(0), "")

        return user
    }
    fun addUser(user: UserData):ServerResponse{
        var stub = serviceAddUserGrpc.newBlockingStub(channel)
        var request = General.ClientPetitionAddUser.newBuilder()
            .setType(user.type)
            .setNick(user.nickName)
            .setName(user.name)
            .setSurName(user.surname)
            .setPhone(user.phone)
            .setAdress(user.address)
            .setImagePath("")
            .setPwd(user.pwd)
            .build()
        var response = stub.giveResponseAddUser(request)
        return ServerResponse(response.statusCodeValue)
    }
    fun changePwd(change:PwdChange):ServerResponse{
        var stub = servicePwdChangeGrpc.newBlockingStub(channel)
        Log.d("Data",change.toString())
        var request = General.ClientPetitionPwdChange.newBuilder()
            .setOldPwd(change.oldPwd)
            .setNewPwd(change.newPwd)
            .setIdUser(change.idUser)
            .build()
        var response= stub.giveResponsePwdChange(request)
        return ServerResponse(response.statusCodeValue)
    }
}
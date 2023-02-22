package com.rzxengineering.shopapp.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rzxengineering.shopapp.manager.Manager
import com.rzxengineering.shopapp.objects.Login
import com.rzxengineering.shopapp.objects.UserData

class LoginViewModel: ViewModel() {
    private val login: MutableLiveData<Login> = MutableLiveData()
    val userData: LiveData<UserData> = Transformations.switchMap(login){
        Log.d("------------------------------","Here iM")
        Manager.login(login.value!!.nickName, login.value!!.pwd)
    }
    fun setLogin(newLogin: Login){
        val update = newLogin
        if(login.value == update)
            return
        login.value = update
    }
    fun cancelJobs(){
        Manager.cancelJobs()
    }
}
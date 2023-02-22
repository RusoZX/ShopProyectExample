package com.rzxengineering.shopapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rzxengineering.shopapp.manager.Manager
import com.rzxengineering.shopapp.objects.ServerResponse
import com.rzxengineering.shopapp.objects.UserData

class UpdateUserViewModel:ViewModel() {
    private val userData: MutableLiveData<UserData> = MutableLiveData()
    val response: LiveData<ServerResponse> = Transformations.switchMap(this.userData){
        Manager.updateUser(it)
    }
    fun setLogin(newUserData: UserData){
        val update = newUserData
        if(this.userData.value == update)
            return
        this.userData.value = update
    }
    fun cancelJobs(){
        Manager.cancelJobs()
    }
}
package com.rzxengineering.shopapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rzxengineering.shopapp.manager.Manager
import com.rzxengineering.shopapp.objects.UserData

class UserDataViewModel: ViewModel() {
private val idUser: MutableLiveData<Int> = MutableLiveData()
    val userData:LiveData<UserData> = Transformations.switchMap(idUser){
        Manager.getUserData(it)
    }
    fun setId(id:Int){
        val update = id
        if(idUser.value == update)
            return
        idUser.value = update
    }
    fun cancelJobs(){
        Manager.cancelJobs()
    }
}
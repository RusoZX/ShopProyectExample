package com.rzxengineering.shopapp.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rzxengineering.shopapp.manager.Manager
import com.rzxengineering.shopapp.objects.ServerResponse
import com.rzxengineering.shopapp.objects.UserData

class AddUserViewModel : ViewModel() {

    private val userData: MutableLiveData<UserData> = MutableLiveData()

    val response: LiveData<ServerResponse> = Transformations
        .switchMap(userData){
            Manager.addUser(it)
        }

    fun setId(newUserData: UserData){
        val update = newUserData
        if (userData.value == update) {
            return
        }
        userData.value = update
    }

    fun cancelJobs(){
        Manager.cancelJobs()
    }
}
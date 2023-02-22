package com.rzxengineering.shopapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rzxengineering.shopapp.manager.Manager
import com.rzxengineering.shopapp.objects.PwdChange
import com.rzxengineering.shopapp.objects.ServerResponse

class ChangePwdViewModel : ViewModel(){

    private val restock: MutableLiveData<PwdChange> = MutableLiveData()

    val response: LiveData<ServerResponse> = Transformations
        .switchMap(restock){
            Manager.changePwd(it)
        }

    fun setId(newChange: PwdChange){
        val update = newChange
        if (restock.value == update) {
            return
        }
        restock.value = update
    }

    fun cancelJobs(){
        Manager.cancelJobs()
    }
}
package com.rzxengineering.shopapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rzxengineering.shopapp.manager.Manager
import com.rzxengineering.shopapp.objects.SaleOrRestock
import com.rzxengineering.shopapp.objects.ServerResponse

class MakeRestockViewModel : ViewModel(){

    private val restock: MutableLiveData<SaleOrRestock> = MutableLiveData()

    val response: LiveData<ServerResponse> = Transformations
        .switchMap(restock){
            Manager.makeRestock(it)
        }

    fun setId(newRestock: SaleOrRestock){
        val update = newRestock
        if (restock.value == update) {
            return
        }
        restock.value = update
    }

    fun cancelJobs(){
        Manager.cancelJobs()
    }
}
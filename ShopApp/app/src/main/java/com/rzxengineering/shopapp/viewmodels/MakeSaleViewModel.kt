package com.rzxengineering.shopapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rzxengineering.shopapp.manager.Manager
import com.rzxengineering.shopapp.objects.SaleOrRestock
import com.rzxengineering.shopapp.objects.ServerResponse

class MakeSaleViewModel : ViewModel(){

    private val sale: MutableLiveData<SaleOrRestock> = MutableLiveData()

    val response: LiveData<ServerResponse> = Transformations
        .switchMap(sale){
            Manager.makeSale(it)
        }

    fun setId(newSale: SaleOrRestock){
        val update = newSale
        if (sale.value == update) {
            return
        }
        sale.value = update
    }

    fun cancelJobs(){
        Manager.cancelJobs()
    }
}
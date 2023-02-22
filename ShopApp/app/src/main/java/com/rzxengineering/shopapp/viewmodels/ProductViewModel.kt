package com.rzxengineering.shopapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rzxengineering.shopapp.manager.Manager
import com.rzxengineering.shopapp.objects.Product


class ProductViewModel: ViewModel() {

    private val idProduct: MutableLiveData<Int> = MutableLiveData()

    val response: LiveData<Product> = Transformations
        .switchMap(idProduct){
            Manager.giveProduct(it)
        }

    fun setId(newId: Int){
        val update = newId
        if (idProduct.value == update) {
            return
        }
        idProduct.value = update
    }

    fun cancelJobs(){
        Manager.cancelJobs()
    }
}
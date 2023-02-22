package com.rzxengineering.shopapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rzxengineering.shopapp.manager.Manager
import com.rzxengineering.shopapp.objects.Product
import com.rzxengineering.shopapp.objects.ServerResponse

class AddProductViewModel :ViewModel(){

    private val productData: MutableLiveData<Product> = MutableLiveData()

    val response: LiveData<ServerResponse> = Transformations
        .switchMap(productData){
            Manager.addProduct(it)
        }

    fun setId(newProduct: Product){
        val update = newProduct
        if (productData.value == update) {
            return
        }
        productData.value = update
    }

    fun cancelJobs(){
        Manager.cancelJobs()
    }
}
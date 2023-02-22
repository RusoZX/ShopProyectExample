package com.rzxengineering.shopapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rzxengineering.shopapp.manager.Manager
import com.rzxengineering.shopapp.objects.ProductShoppingList

class GiveShoppingListViewModel : ViewModel() {

    private val request: MutableLiveData<Int> = MutableLiveData()

    val response: LiveData<ArrayList<ProductShoppingList>> = Transformations
        .switchMap(request){
            Manager.getShoppingList(it)
        }

    fun setRequest(newId:Int){
        val update = newId
        if (request.value == update) {
            return
        }
        request.value = update
    }

    fun cancelJobs(){
        Manager.cancelJobs()
    }
}
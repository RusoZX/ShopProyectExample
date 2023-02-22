package com.rzxengineering.shopapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rzxengineering.shopapp.manager.Manager
import com.rzxengineering.shopapp.objects.ServerResponse
import com.rzxengineering.shopapp.objects.ShoppingListRequest

class AddShoppingListViewModel : ViewModel() {

    private val request: MutableLiveData<ShoppingListRequest> = MutableLiveData()

    val response: LiveData<ServerResponse> = Transformations
        .switchMap(request){
            Manager.addShoppingList(it)
        }

    fun setRequest(newRequest:ShoppingListRequest){
        val update = newRequest
        if (request.value == update) {
            return
        }
        request.value = update
    }

    fun cancelJobs(){
        Manager.cancelJobs()
    }
}
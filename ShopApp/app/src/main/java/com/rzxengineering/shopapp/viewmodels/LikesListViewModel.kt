package com.rzxengineering.shopapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rzxengineering.shopapp.manager.Manager
import com.rzxengineering.shopapp.objects.Product

class LikesListViewModel : ViewModel(){

    private val id: MutableLiveData<Int> = MutableLiveData()

    val response: LiveData<ArrayList<Product>> = Transformations
        .switchMap(id){
            Manager.giveLikedList(it)
        }

    fun setRequest(newId: Int){
        val update = newId
        if (id.value == update) {
            return
        }
        id.value = update
    }

    fun cancelJobs(){
        Manager.cancelJobs()
    }
}
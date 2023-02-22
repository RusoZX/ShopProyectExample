package com.rzxengineering.shopapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rzxengineering.shopapp.manager.Manager


class CategoriesViewModel : ViewModel() {

    private val bool: MutableLiveData<Boolean> = MutableLiveData()

    val response: LiveData<ArrayList<String>> = Transformations
        .switchMap(bool){
            Manager.getCategories(it)
        }

    fun setId(newBool: Boolean){
        val update = newBool
        if (bool.value == update) {
            return
        }
        bool.value = update
    }

    fun cancelJobs(){
        Manager.cancelJobs()
    }
}
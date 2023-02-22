package com.rzxengineering.shopapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rzxengineering.shopapp.manager.Manager
import com.rzxengineering.shopapp.objects.SaleOrRestock
import com.rzxengineering.shopapp.objects.SearchByDate

class GiveRestocksViewModel : ViewModel(){

    private val search: MutableLiveData<SearchByDate> = MutableLiveData()

    val restocks: LiveData<ArrayList<SaleOrRestock>> = Transformations
        .switchMap(search){
            Manager.giveRestocks(search.value!!.idUser,search.value!!.idProduct,
                search.value!!.quantity,search.value!!.firstDay,search.value!!.lastDay)
        }

    fun setId(newSearchByDate: SearchByDate){
        val update = newSearchByDate
        if (search.value == update) {
            return
        }
        search.value = update
    }

    fun cancelJobs(){
        Manager.cancelJobs()
    }
}
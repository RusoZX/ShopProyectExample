package com.rzxengineering.shopapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rzxengineering.shopapp.manager.Manager
import com.rzxengineering.shopapp.objects.Product
import com.rzxengineering.shopapp.objects.Search

class ProductsViewModel: ViewModel() {

    private val search: MutableLiveData<Search> = MutableLiveData()

    val products: LiveData<ArrayList<Product>> = Transformations
        .switchMap(search){
            Manager.giveProducts(search.value!!.quantity, search.value!!.sortingMode,
                search.value!!.search, search.value!!.idUser)
        }

    fun setSearch(newSearch: Search){
        val update = newSearch
        if (search.value == update) {
            return
        }
        search.value = update
    }

    fun cancelJobs(){
        Manager.cancelJobs()
    }
}
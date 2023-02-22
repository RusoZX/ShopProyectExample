package com.rzxengineering.shopapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.rzxengineering.shopapp.manager.Manager
import com.rzxengineering.shopapp.objects.Like
import com.rzxengineering.shopapp.objects.ServerResponse

class IsLikedViewModel : ViewModel(){

    private val like: MutableLiveData<Like> = MutableLiveData()

    val response: LiveData<ServerResponse> = Transformations
        .switchMap(like){
            Manager.isLiked(it)
        }

    fun setId(newLike: Like){
        val update = newLike
        if (like.value == update) {
            return
        }
        like.value = update
    }

    fun cancelJobs(){
        Manager.cancelJobs()
    }
}
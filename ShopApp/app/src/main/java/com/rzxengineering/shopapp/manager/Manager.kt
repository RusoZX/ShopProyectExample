package com.rzxengineering.shopapp.manager

import android.util.Log
import androidx.lifecycle.LiveData
import com.rzxengineering.shopapp.objects.*
import com.rzxengineering.shopapp.services.*
import kotlinx.coroutines.*
object Manager {
    lateinit var job: CompletableJob
    fun login(nickName:String,pwd:String): LiveData<UserData>{
        job= Job()
        Log.d("------------------------------","No, Here Im")
        return object: LiveData<UserData>(){
            override fun onActive() {
                super.onActive()
                job?.let{
                    theJob->
                    CoroutineScope(Dispatchers.IO+ theJob).launch {
                        val data = AdminUser().verify(nickName,pwd)
                        withContext(Dispatchers.Main){
                            value= data
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }
    fun changePwd(change:PwdChange): LiveData<ServerResponse>{
        job= Job()
        return object: LiveData<ServerResponse>(){
            override fun onActive() {
                super.onActive()
                job?.let{
                        theJob->
                    CoroutineScope(Dispatchers.IO+ theJob).launch {
                        val data = AdminUser().changePwd(change)
                        withContext(Dispatchers.Main){
                            value= data
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }

    fun getUserData(id:Int): LiveData<UserData>{
        job= Job()
        return object: LiveData<UserData>(){
            override fun onActive() {
                super.onActive()
                job?.let{
                        theJob->
                    CoroutineScope(Dispatchers.IO+ theJob).launch {
                        val data = AdminUser().giveData(id)
                        withContext(Dispatchers.Main){
                            value= data
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }
    fun updateUser(user:UserData): LiveData<ServerResponse>{
        job= Job()
        return object: LiveData<ServerResponse>(){
            override fun onActive() {
                super.onActive()
                job?.let{
                        theJob->
                    CoroutineScope(Dispatchers.IO+ theJob).launch {
                        val data = AdminUser().update(user)
                        withContext(Dispatchers.Main){
                            value= data
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }
    fun addUser(user: UserData): LiveData<ServerResponse>{
        job= Job()
        return object: LiveData<ServerResponse>(){
            override fun onActive() {
                super.onActive()
                job?.let{
                        theJob->
                    CoroutineScope(Dispatchers.IO+ theJob).launch {
                        val data = AdminUser().addUser(user)
                        withContext(Dispatchers.Main){
                            value= data
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }
    fun giveProduct(id:Int): LiveData<Product>{
        job= Job()
        return object: LiveData<Product>(){
            override fun onActive() {
                super.onActive()
                job?.let{
                        theJob->
                    CoroutineScope(Dispatchers.IO+ theJob).launch {
                        val data = AdminProduct().giveProduct(id)
                        withContext(Dispatchers.Main){
                            value= data
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }
    fun giveProducts(quantity:Int, sortingMode:Int, search:String, idUser: Int): LiveData<ArrayList<Product>>{
        job= Job()
        return object: LiveData<ArrayList<Product>>(){
            override fun onActive() {
                super.onActive()
                job?.let{
                        theJob->
                    CoroutineScope(Dispatchers.IO+ theJob).launch {
                        val data = AdminProduct().giveProducts(quantity, sortingMode, search, idUser)
                        withContext(Dispatchers.Main){
                            value= data
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }
    fun giveProductsPartner(quantity:Int, sortingMode:Int, search:String, idUser: Int): LiveData<ArrayList<Product>>{
        job= Job()
        return object: LiveData<ArrayList<Product>>(){
            override fun onActive() {
                super.onActive()
                job?.let{
                        theJob->
                    CoroutineScope(Dispatchers.IO+ theJob).launch {
                        val data = AdminProduct().giveProductsPartner(quantity, sortingMode, search, idUser)
                        withContext(Dispatchers.Main){
                            value= data
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }
    fun addProduct(product: Product): LiveData<ServerResponse>{
        job= Job()
        return object: LiveData<ServerResponse>(){
            override fun onActive() {
                super.onActive()
                job?.let{
                        theJob->
                    CoroutineScope(Dispatchers.IO+ theJob).launch {
                        val data = AdminProduct().addProduct(product)
                        withContext(Dispatchers.Main){
                            value= data
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }
    fun updateProduct(product: Product): LiveData<ServerResponse>{
        job= Job()
        return object: LiveData<ServerResponse>(){
            override fun onActive() {
                super.onActive()
                job?.let{
                        theJob->
                    CoroutineScope(Dispatchers.IO+ theJob).launch {
                        val data = AdminProduct().updateProduct(product)
                        withContext(Dispatchers.Main){
                            value= data
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }
    fun getCategories(bool:Boolean): LiveData<ArrayList<String>>{
        job= Job()
        return object: LiveData<ArrayList<String>>(){
            override fun onActive() {
                super.onActive()
                job?.let{
                        theJob->
                    CoroutineScope(Dispatchers.IO+ theJob).launch {
                        val data = AdminProduct().giveCategories(bool)
                        withContext(Dispatchers.Main){
                            value= data
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }
    fun addShoppingList(request: ShoppingListRequest): LiveData<ServerResponse>{
        job= Job()
        return object: LiveData<ServerResponse>(){
            override fun onActive() {
                super.onActive()
                job?.let{
                        theJob->
                    CoroutineScope(Dispatchers.IO+ theJob).launch {
                        val data = AdminProduct().addToShoppingList(request)
                        withContext(Dispatchers.Main){
                            value= data
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }
    fun getShoppingList(idUser:Int): LiveData<ArrayList<ProductShoppingList>>{
        job= Job()
        return object: LiveData<ArrayList<ProductShoppingList>>(){
            override fun onActive() {
                super.onActive()
                job?.let{
                        theJob->
                    CoroutineScope(Dispatchers.IO+ theJob).launch {
                        val data = AdminProduct().getShoppingList(idUser)
                        withContext(Dispatchers.Main){
                            value= data
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }
    fun makeSale(sale: SaleOrRestock): LiveData<ServerResponse>{
        job= Job()
        return object: LiveData<ServerResponse>(){
            override fun onActive() {
                super.onActive()
                job?.let{
                        theJob->
                    CoroutineScope(Dispatchers.IO+ theJob).launch {
                        val data = AdminSales().makeSale(sale)
                        withContext(Dispatchers.Main){
                            value= data
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }
    fun giveSales(idUser:Int,idProduct:Int, quantity:Int, firstDay:String,lastDay:String)
    : LiveData<ArrayList<SaleOrRestock>>{
        job= Job()
        return object: LiveData<ArrayList<SaleOrRestock>>(){
            override fun onActive() {
                super.onActive()
                job?.let{
                        theJob->
                    CoroutineScope(Dispatchers.IO+ theJob).launch {
                        val data = AdminSales().giveSales(idUser, idProduct, quantity, firstDay,
                            lastDay)
                        withContext(Dispatchers.Main){
                            value= data
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }
    fun giveSalesOwner(idUser:Int,idProduct:Int, quantity:Int, firstDay:String,lastDay:String)
            : LiveData<ArrayList<SaleOrRestock>>{
        job= Job()
        return object: LiveData<ArrayList<SaleOrRestock>>(){
            override fun onActive() {
                super.onActive()
                job?.let{
                        theJob->
                    CoroutineScope(Dispatchers.IO+ theJob).launch {
                        val data = AdminSales().giveSalesOwner(idUser, idProduct, quantity, firstDay,
                            lastDay)
                        withContext(Dispatchers.Main){
                            value= data
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }
    fun makeRestock(restock: SaleOrRestock): LiveData<ServerResponse>{
        job= Job()
        return object: LiveData<ServerResponse>(){
            override fun onActive() {
                super.onActive()
                job?.let{
                        theJob->
                    CoroutineScope(Dispatchers.IO+ theJob).launch {
                        val data = AdminRestocks().makeRestock(restock)
                        withContext(Dispatchers.Main){
                            value= data
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }
    fun giveRestocks(idUser:Int,idProduct:Int, quantity:Int, firstDay:String,lastDay:String)
            : LiveData<ArrayList<SaleOrRestock>>{
        job= Job()
        return object: LiveData<ArrayList<SaleOrRestock>>(){
            override fun onActive() {
                super.onActive()
                job?.let{
                        theJob->
                    CoroutineScope(Dispatchers.IO+ theJob).launch {
                        val data = AdminRestocks().giveRestocks(idUser, idProduct, quantity,
                            firstDay, lastDay)
                        withContext(Dispatchers.Main){
                            value= data
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }
    fun makeLike(like: Like): LiveData<ServerResponse>{
        job= Job()
        return object: LiveData<ServerResponse>(){
            override fun onActive() {
                super.onActive()
                job?.let{
                        theJob->
                    CoroutineScope(Dispatchers.IO+ theJob).launch {
                        val data = AdminLikes().like(like)
                        withContext(Dispatchers.Main){
                            value= data
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }
    fun isLiked(like: Like): LiveData<ServerResponse>{
        job= Job()
        return object: LiveData<ServerResponse>(){
            override fun onActive() {
                super.onActive()
                job?.let{
                        theJob->
                    CoroutineScope(Dispatchers.IO+ theJob).launch {
                        val data = AdminLikes().isLiked(like)
                        withContext(Dispatchers.Main){
                            value= data
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }
    fun giveLikedList(idUser: Int): LiveData<ArrayList<Product>>{
        job= Job()
        return object: LiveData<ArrayList<Product>>(){
            override fun onActive() {
                super.onActive()
                job?.let{
                        theJob->
                    CoroutineScope(Dispatchers.IO+ theJob).launch {
                        val data = AdminLikes().likesList(idUser)
                        withContext(Dispatchers.Main){
                            value= data
                            theJob.complete()
                        }
                    }
                }
            }
        }
    }
    fun cancelJobs() {
        job?.cancel()
    }
}
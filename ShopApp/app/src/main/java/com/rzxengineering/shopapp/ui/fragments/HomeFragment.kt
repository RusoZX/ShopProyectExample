package com.rzxengineering.shopapp.ui.fragments

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rzxengineering.shopapp.R
import com.rzxengineering.shopapp.adapters.ProductsAdapter
import com.rzxengineering.shopapp.intentCodes.IntentCodes
import com.rzxengineering.shopapp.objects.Product
import com.rzxengineering.shopapp.objects.Search
import com.rzxengineering.shopapp.viewmodels.ProductsViewModel

class HomeFragment: Fragment(R.layout.home_fragment)
{
    //First we declare the navigation controller and the view model that will get the information
    //of the products to show
    lateinit var navController: NavController
    lateinit var productVM: ProductsViewModel
    var idClient:Int=-1

    //As well we declare the recycled view that will show the products
    lateinit var bestSellersRecyView: RecyclerView
    lateinit var discountsRecyView: RecyclerView
    lateinit var bestSellersAdapter: ProductsAdapter
    lateinit var discountsAdapter: ProductsAdapter
    lateinit var bestSellerProductsList: ArrayList<Product>
    lateinit var discountsProductsList: ArrayList<Product>
    lateinit var isLikedList: ArrayList<Boolean>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productVM= ViewModelProvider(this)[ProductsViewModel::class.java]

        navController = Navigation.findNavController(view)
        var preferences= requireActivity().getSharedPreferences("login",Context.MODE_PRIVATE)
        //Here we check in the shared preferences if the user had already logged previously
        //If not we create a bundle and change to the login fragment
        if(!preferences.getBoolean("isLogged",false)){
            var bundleData = Bundle()
            bundleData.putInt(IntentCodes.Identifications.IDCLIENT,
                preferences.getInt(IntentCodes.Identifications.IDCLIENT, -1))
            //Here we say to the nav controller what action to do, in this case we want to
            //go from home fragment to the login fragment
            navController.navigate(R.id.action_home_to_login)
        }else{
           idClient= preferences.getInt(IntentCodes.Identifications.IDCLIENT, 1)
            var search= Search(10, 1,"", idClient)
            productVM.setSearch(search)
            productVM.products.observe(viewLifecycleOwner) {
                if(it[0].statusCode==1)
                    alert(resources.getString(R.string.alertServerError))
                else{

                    bestSellerProductsList= it
                    setDecoratorBestSellers()
                    setAdapterBestSellers()
                }
            }
            search.sortingMode=3
            productVM.setSearch(search)
            productVM.products.observe(viewLifecycleOwner){
                if(it[0].statusCode==1)
                    alert(resources.getString(R.string.alertServerError))
                else{
                    discountsProductsList= it
                    setDecoratorDiscounts()
                    setAdapterDiscounts()
                }
            }
        }
    }


    private fun setAdapterBestSellers(){
        bestSellersRecyView.setHasFixedSize(true)

        bestSellersAdapter= ProductsAdapter(bestSellerProductsList,requireContext(),
        BestSellersListener(navController,bestSellerProductsList),idClient,this,
            viewLifecycleOwner)
        var layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,
            false)
        bestSellersRecyView.layoutManager=layoutManager
        bestSellersRecyView.adapter=bestSellersAdapter
    }
    private fun setDecoratorBestSellers(){
        bestSellersRecyView=requireView().findViewById(R.id.bestSellersRecView)
        bestSellersRecyView.addItemDecoration(
            MarginItemDecoration(20)
        )
    }
    private fun setAdapterDiscounts(){
        discountsRecyView.setHasFixedSize(true)
        discountsRecyView.layoutManager = LinearLayoutManager(requireContext())
        discountsAdapter= ProductsAdapter(discountsProductsList,requireContext(),
            DiscountsListener(navController,discountsProductsList),idClient,this,
            viewLifecycleOwner)

        var layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,
            false)
        discountsRecyView.layoutManager=layoutManager
        discountsRecyView.adapter=discountsAdapter
    }
    private fun setDecoratorDiscounts(){
        discountsRecyView=requireView().findViewById(R.id.saleRecView)
        discountsRecyView.addItemDecoration(
            MarginItemDecoration(20)
        )
    }
    class MarginItemDecoration(private val spaceHeight: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect, view: View,
            parent: RecyclerView, state: RecyclerView.State
        ) {
            with(outRect) {
                if (parent.getChildAdapterPosition(view) == 0) {
                    top = spaceHeight
                }
                left =  spaceHeight
                right = spaceHeight
                bottom = spaceHeight
            }
        }
    }

    fun alert(msj:String?){
        val alert = AlertDialog.Builder(requireContext())
        alert.setCancelable(false)
        alert.setTitle("")
        alert.setMessage(msj)
        alert.setPositiveButton(R.string.back) { dialogInterface, i ->

        }
        alert.show()
    }
    override fun onDestroy() {
        super.onDestroy()
        productVM.cancelJobs()
    }


    //Here we create two different listeners so we can know of what recycled view was clicked an item
    class BestSellersListener(navController: NavController, list: ArrayList<Product>):
        ProductsAdapter.OnProductListener{
        var navController = navController
        var list = list
        override fun onProductClick(position: Int) {
            val bundle= Bundle()
            bundle.putInt(IntentCodes.Identifications.IDPRODUCT,list[position].id)
            navController.navigate(R.id.action_home_to_product, bundle)
        }
    }
    class DiscountsListener(navController: NavController, list: ArrayList<Product>):
        ProductsAdapter.OnProductListener{
        var navController = navController
        var list = list
        override fun onProductClick(position: Int) {
            val bundle= Bundle()
            bundle.putInt(IntentCodes.Identifications.IDPRODUCT, list[position].id)
            navController.navigate(R.id.action_home_to_product, bundle)
        }
    }

}
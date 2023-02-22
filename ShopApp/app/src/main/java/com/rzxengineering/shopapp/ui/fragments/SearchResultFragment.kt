package com.rzxengineering.shopapp.ui.fragments

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
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
import com.rzxengineering.shopapp.ui.fragments.dialogs.FilterDialog
import com.rzxengineering.shopapp.viewmodels.ProductsViewModel

class SearchResultFragment:Fragment(R.layout.search_result_fragment) {
    lateinit var navController: NavController
    lateinit var productVM: ProductsViewModel
    lateinit var recyView: RecyclerView
    var idClient:Int=-1

    lateinit var productsAdapter: ProductsAdapter
    lateinit var productsList: ArrayList<Product>


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productVM= ViewModelProvider(this)[ProductsViewModel::class.java]

        navController = Navigation.findNavController(view)
        var preferences= requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)

        idClient= preferences.getInt(IntentCodes.Identifications.IDCLIENT, 1)
        var search :Search
        if(requireArguments().getString(IntentCodes.Identifications.SEARCH)=="")
            search = Search(
                10, 7,
                requireArguments().getString(IntentCodes.Identifications.CATEGORY)!!, idClient
            )
        else
            search = Search(
                10, 6,
                requireArguments().getString(IntentCodes.Identifications.SEARCH)!!, idClient
            )

            productVM.setSearch(search)
            productVM.products.observe(viewLifecycleOwner) {
                if(it[0].statusCode==1)
                    alert(resources.getString(R.string.alertServerError))
                else if(it[0].statusCode==2)
                alert(resources.getString(R.string.alertEmptyResult))
                else{

                    productsList= it
                    Log.d("PRODUCTOS",productsList.toString())
                    setDecorator()
                    setAdapter()
                    setDialog()
                }
            }



    }
    private fun setDialog(){
        //Here we will put a listener in the filter TV so when its clicked a dialog will apear
        var filterTv=requireView().findViewById<TextView>(R.id.filterTv)
        filterTv.setOnClickListener {
            var dialog= FilterDialog(this)
            dialog.show(parentFragmentManager,"dialog")
        }
    }
    fun updateAdapter(quantity: Int, searchMode:String){
        var sorting: Int = 0
        when(searchMode){
            resources.getString(R.string.optionNameAsc)->{
                sorting=0
            }
            resources.getString(R.string.optionNameDesc)->{
                sorting=1
            }
            resources.getString(R.string.optionPriceAsc)->{
                sorting=2
            }
            resources.getString(R.string.optionPriceAsc)->{
                sorting=3
            }
            resources.getString(R.string.optionSellsAsc)->{
                sorting=4
            }
            resources.getString(R.string.optionSellsDesc)->{
                sorting=5
            }
        }


        productVM.setSearch(Search(
            quantity, sorting,
            requireArguments().getString(IntentCodes.Identifications.SEARCH)!!, idClient
        ))
        productVM.products.observe(viewLifecycleOwner) {
            if(it[0].statusCode==1)
                alert(resources.getString(R.string.alertServerError))
            else if(it[0].statusCode==2)
                alert(resources.getString(R.string.alertEmptyResult))
            else{

                productsList= it
                setDecorator()
                setAdapter()
            }
        }
    }
    private fun setAdapter(){
        recyView.setHasFixedSize(true)
        recyView.layoutManager = LinearLayoutManager(requireContext())
        productsAdapter= ProductsAdapter(productsList,requireContext(),
            ProductListener(navController, productsList),idClient,this,
            viewLifecycleOwner)

        var layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,
            false)
        recyView.layoutManager=layoutManager
        recyView.adapter=productsAdapter
    }
    private fun setDecorator(){
        recyView=requireView().findViewById(R.id.searchResultRecycledView)
        recyView.addItemDecoration(
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


    class ProductListener(navController: NavController, list: ArrayList<Product>):
        ProductsAdapter.OnProductListener{
        var navController = navController
        var list = list
        override fun onProductClick(position: Int) {
            val bundle= Bundle()
            bundle.putInt(IntentCodes.Identifications.IDPRODUCT,list[position].id)
            navController.navigate(R.id.action_searchResultFragment_to_productFragment, bundle)
        }
    }
}
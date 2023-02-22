package com.rzxengineering.shopapp.ui.fragments

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
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
import com.rzxengineering.shopapp.viewmodels.LikesListViewModel

class LikesFragment : Fragment(R.layout.likes_fragment) {
    lateinit var navController: NavController
    lateinit var recyView: RecyclerView
    var idClient:Int=-1
    lateinit var productsVM: LikesListViewModel

    lateinit var productsAdapter: ProductsAdapter
    lateinit var productsList: ArrayList<Product>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productsVM = ViewModelProvider(this)[LikesListViewModel::class.java]

        navController = Navigation.findNavController(view)
        var preferences = requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)

        idClient = preferences.getInt(IntentCodes.Identifications.IDCLIENT, 1)

        productsVM.setRequest(idClient)
        productsVM.response.observe(viewLifecycleOwner){
            if(it[0].statusCode==1)
                alert(resources.getString(R.string.alertServerError))
            else if(it[0].statusCode==2)
                alert(resources.getString(R.string.alertEmptyResult))
            else{

                productsList= it
                Log.d("PRODUCTOS",productsList.toString())
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

        var layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,
            false)
        recyView.layoutManager=layoutManager
        recyView.adapter=productsAdapter
    }
    private fun setDecorator(){
        recyView=requireView().findViewById(R.id.likesRecyView)
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
        productsVM.cancelJobs()
    }
    class ProductListener(navController: NavController, list: ArrayList<Product>):
        ProductsAdapter.OnProductListener{
        var navController = navController
        var list = list
        override fun onProductClick(position: Int) {
            val bundle= Bundle()
            bundle.putInt(IntentCodes.Identifications.IDPRODUCT,list[position].id)
            navController.navigate(R.id.action_likesFragment_to_productFragment, bundle)
        }
    }
}
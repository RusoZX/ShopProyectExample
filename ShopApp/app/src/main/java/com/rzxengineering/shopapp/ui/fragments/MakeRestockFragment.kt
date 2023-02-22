package com.rzxengineering.shopapp.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.rzxengineering.shopapp.R
import com.rzxengineering.shopapp.intentCodes.IntentCodes
import com.rzxengineering.shopapp.objects.SaleOrRestock
import com.rzxengineering.shopapp.objects.Search
import com.rzxengineering.shopapp.viewmodels.MakeRestockViewModel
import com.rzxengineering.shopapp.viewmodels.ProductsPartnerViewModel
import java.time.LocalDate

class MakeRestockFragment: Fragment(R.layout.make_restock_fragment) {
    lateinit var navController: NavController
    lateinit var makeRestockVM: MakeRestockViewModel
    lateinit var productsVM: ProductsPartnerViewModel

    lateinit var namesSpinner: Spinner
    lateinit var quantity: EditText
    lateinit var restockBtn: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productsVM = ViewModelProvider(this)[ProductsPartnerViewModel::class.java]
        makeRestockVM = ViewModelProvider(this)[MakeRestockViewModel::class.java]
        namesSpinner = requireView().findViewById(R.id.makeRestockNameSpinner)
        quantity = requireView().findViewById(R.id.makeRestockQuantityEt)
        restockBtn = requireView().findViewById(R.id.makeRestockBtn)

        navController = Navigation.findNavController(view)
        var preferences= requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)
        productsVM.setSearch(Search(100,1,"",
            preferences.getInt(IntentCodes.Identifications.IDCLIENT,-1)))

        var array = ArrayList<String>()
        var ids = ArrayList<Int>()
        productsVM.products.observe(viewLifecycleOwner){
            if(it[0].statusCode==1)
                alert(resources.getString(R.string.alertServerError))
            else {
                for (product in it) {
                    array.add(product.name)
                    ids.add(product.id)
                }
                var adapter = ArrayAdapter<String>(requireContext(),
                    android.R.layout.simple_spinner_item,array)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                namesSpinner.adapter=adapter

                restockBtn.setOnClickListener {
                    if(quantity.text.isEmpty())
                        alert(resources.getString(R.string.alertEmpty))
                    else{
                        var date= LocalDate.now()
                        makeRestockVM.setId(SaleOrRestock(0,
                            preferences.getInt(IntentCodes.Identifications.IDCLIENT,-1),
                        ids[namesSpinner.selectedItemPosition],quantity.text.toString().toInt(),
                            "${date.year}-${date.month}-${date.dayOfMonth}","",
                        ByteArray(0),""))

                        makeRestockVM.response.observe(viewLifecycleOwner){
                            if(it.response==1)
                                alert(resources.getString(R.string.alertServerError))
                            else
                                conf()
                        }
                    }
                }
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
    fun conf(){
        val alert = AlertDialog.Builder(requireContext())
        alert.setCancelable(false)
        alert.setTitle("")
        alert.setMessage(R.string.confRestock)
        alert.setPositiveButton(R.string.ok) { dialogInterface, i ->
            navController.popBackStack(R.id.homeFragment,false)
        }
        alert.show()
    }
    override fun onDestroy() {
        super.onDestroy()
        productsVM.cancelJobs()
        makeRestockVM.cancelJobs()
    }
}
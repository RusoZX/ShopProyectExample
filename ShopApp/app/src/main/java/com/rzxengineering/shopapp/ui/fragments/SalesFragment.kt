package com.rzxengineering.shopapp.ui.fragments

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rzxengineering.shopapp.R
import com.rzxengineering.shopapp.adapters.SalesAdapter
import com.rzxengineering.shopapp.intentCodes.IntentCodes
import com.rzxengineering.shopapp.objects.SaleOrRestock
import com.rzxengineering.shopapp.objects.SearchByDate
import com.rzxengineering.shopapp.viewmodels.GiveSalesOwnerViewModel
import java.time.LocalDate
import kotlin.collections.ArrayList

class SalesFragment :Fragment(R.layout.sales_history_fragment){
    lateinit var navController: NavController
    lateinit var salesVM: GiveSalesOwnerViewModel
    lateinit var recyView: RecyclerView

    lateinit var salesAdapter: SalesAdapter
    lateinit var salesList: ArrayList<SaleOrRestock>

    lateinit var dateSpinner: Spinner
    lateinit var quantitySpinner: Spinner
    lateinit var search: ImageView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        salesVM = ViewModelProvider(this)[GiveSalesOwnerViewModel::class.java]

        dateSpinner= requireView().findViewById(R.id.dateSpinnerSale)
        quantitySpinner= requireView().findViewById(R.id.quantitySpinnerSale)
        search = requireView().findViewById(R.id.searchSale)

        var arraySpinner=arrayOf(resources.getString(R.string.optionMsgDate),
            resources.getString(R.string.optionOneWeek),resources.getString(R.string.optionOneMonth),
            resources.getString(R.string.optionOneYear)
        )
        var adapter = ArrayAdapter<String>(requireContext(),
            android.R.layout.simple_spinner_item,arraySpinner)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        dateSpinner.adapter=adapter

        arraySpinner = arrayOf(resources.getString(R.string.optionMsgQuantity),
            "5","10","15","20")
            adapter = ArrayAdapter<String>(requireContext(),
                android.R.layout.simple_spinner_item,arraySpinner)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        quantitySpinner.adapter=adapter


        navController = Navigation.findNavController(view)
        var preferences= requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)
        search.setOnClickListener {
            if(dateSpinner.selectedItem.toString()==resources.getString(R.string.optionMsgDate)||
                quantitySpinner.selectedItem.toString()==resources.getString(R.string.optionMsgQuantity))
                alert(resources.getString(R.string.alertDateQuantity))
            else {

                var firstDate= LocalDate.now()
                var lastDate = LocalDate.now()

                when(dateSpinner.selectedItem.toString()){
                    resources.getString(R.string.optionOneWeek)->{
                        firstDate.minusWeeks(1)
                    }
                    resources.getString(R.string.optionOneMonth)->{
                        firstDate.minusMonths(1)
                    }
                    resources.getString(R.string.optionOneYear)->{
                        firstDate.minusYears(1)
                    }
                }
                salesVM.setId(
                    SearchByDate(
                        preferences.getInt(
                            IntentCodes.Identifications.IDCLIENT, 1),0,
                        Integer.parseInt(quantitySpinner.selectedItem.toString())
                        ,"${firstDate.year}-${firstDate.month}-${firstDate.dayOfMonth}",
                        "${lastDate.year}-${lastDate.month}-${lastDate.dayOfMonth}"
                    )
                )
                salesVM.sales.observe(viewLifecycleOwner){
                    salesList=it
                    if(it[0].statusCode==1)
                        alert(resources.getString(R.string.alertServerError))
                    else {
                        setDecorator()
                        setAdapter()
                    }
                }
            }
        }

    }
    private fun setAdapter(){
        recyView.setHasFixedSize(true)
        recyView.layoutManager = LinearLayoutManager(requireContext())
        salesAdapter= SalesAdapter(salesList,requireContext(),
            SaleListener(navController, salesList))

        var layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,
            false)
        recyView.layoutManager=layoutManager
        recyView.adapter=salesAdapter
    }
    private fun setDecorator(){
        recyView=requireView().findViewById(R.id.saleHistoryRecyView)
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
    class SaleListener(navController: NavController, list: ArrayList<SaleOrRestock>):
        SalesAdapter.OnSaleListener{
        var navController = navController
        var list = list
        override fun onSaleClick(position: Int) {
            val bundle= Bundle()
            bundle.putInt(IntentCodes.Identifications.IDPRODUCT,list[position].idProduct)
            navController.navigate(R.id.action_salesFragment_to_productFragment, bundle)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        salesVM.cancelJobs()
    }
}
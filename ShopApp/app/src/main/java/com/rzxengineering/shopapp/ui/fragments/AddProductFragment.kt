package com.rzxengineering.shopapp.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.rzxengineering.shopapp.R
import com.rzxengineering.shopapp.intentCodes.IntentCodes
import com.rzxengineering.shopapp.objects.Product
import com.rzxengineering.shopapp.viewmodels.AddProductViewModel
import com.rzxengineering.shopapp.viewmodels.CategoriesViewModel

class AddProductFragment: Fragment(R.layout.add_product_fragment) {
    lateinit var navController: NavController
    lateinit var addProdVM: AddProductViewModel
    lateinit var categoriesVM: CategoriesViewModel
    lateinit var name: EditText
    lateinit var price: EditText
    lateinit var units: EditText
    lateinit var sale: EditText
    lateinit var categorySpinner: Spinner
    lateinit var category: EditText
    lateinit var addProduct: Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        name = requireView().findViewById(R.id.nameAddProdEt)
        price = requireView().findViewById(R.id.priceAddProdEt)
        units = requireView().findViewById(R.id.unitsAddProdEt)
        sale = requireView().findViewById(R.id.saleAddProdEt)
        category = requireView().findViewById(R.id.categoryAddProdEt)
        addProduct = requireView().findViewById(R.id.addProdBtn)
        categorySpinner = requireView().findViewById(R.id.addProdSpinner)
        var preferences= requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)
        addProdVM = ViewModelProvider(this)[AddProductViewModel::class.java]
        setSpinner()
        addProduct.setOnClickListener {
            if(name.text.isEmpty()||price.text.isEmpty()||units.text.isEmpty()||sale.text.isEmpty()
                ||(categorySpinner.selectedItem.toString()==
                        resources.getString(R.string.optionCategoryAddProd)&&category.text.isEmpty()))
                alert(resources.getString(R.string.alertEmpty))
            else if(price.text.toString().toFloat()<=0)
                alert(resources.getString(R.string.alertPriceLow))
            else if(price.text.toString().toFloat()>10000)
                alert(resources.getString(R.string.alertPriceHigh))
            else if(sale.text.toString().toInt()<0)
                alert(resources.getString(R.string.alertSaleLow))
            else if(sale.text.toString().toInt()>=100)
                alert(resources.getString(R.string.alertSaleHigh))
            else if(units.text.toString().toInt()<=0)
                alert(resources.getString(R.string.alertUnitsLow))
            else if(units.text.toString().toInt()>1000)
                alert(resources.getString(R.string.alertUnitsHigh))
            else{
                var categoryValue:String
                if(categorySpinner.selectedItem.toString()==
                    resources.getString(R.string.optionCategoryAddProd))
                    categoryValue = category.text.toString()
                else
                    categoryValue=categorySpinner.selectedItem.toString()
                addProdVM.setId(Product(
                    0,0,preferences.getInt(IntentCodes.Identifications.IDCLIENT,2),
                name.text.toString(),price.text.toString().toFloat(),units.text.toString().toInt(),
                0,sale.text.toString().toInt(),0,ByteArray(0),categoryValue,
                    false))
                addProdVM.response.observe(viewLifecycleOwner){
                    if(it.response==1)
                        alert(resources.getString(R.string.alertServerError))
                    else
                        confirmation()
                }
            }
        }
    }
    private fun setSpinner() {
        categoriesVM = ViewModelProvider(this)[CategoriesViewModel::class.java]
        categoriesVM.setId(true)
        categoriesVM.response.observe(viewLifecycleOwner) {
            it.add(resources.getString(R.string.optionCategoryAddProd))
            var adapter = ArrayAdapter<String>(
                requireContext(),
                android.R.layout.simple_spinner_item, it
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            categorySpinner.adapter = adapter
            categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    if (parent.getItemAtPosition(position).toString() ==
                        resources.getString(R.string.optionCategoryAddProd)
                    ) {

                        category.isEnabled = true
                        category.isVisible = true
                    } else if (category.isEnabled) {
                        category.isEnabled = false
                        category.isVisible = false
                        category.setText("")
                    }

                }

                override fun onNothingSelected(p0: AdapterView<*>?) {

                }
            }
        }
    }
    private fun alert(msg: String){
        val alert = AlertDialog.Builder(requireContext())
        alert.setCancelable(false)
        alert.setTitle("")
        alert.setMessage(msg)
        alert.setPositiveButton(R.string.back) { dialogInterface, i ->

        }

        alert.show()
    }
    private fun confirmation(){
        val alert = AlertDialog.Builder(requireContext())
        alert.setCancelable(false)
        alert.setTitle("")
        alert.setMessage(R.string.confAddProd)
        alert.setPositiveButton(R.string.yes) { dialogInterface, i ->
            parentFragmentManager.beginTransaction()
                .remove(this)
                .add(R.id.nav_host_fragment,AddProductFragment())
                .commit()
        }
        alert.setNegativeButton(R.string.no) { dialogInterface, i ->
            navController.popBackStack(R.id.homeFragment, false)
        }
        alert.show()
    }
    override fun onDestroy() {
        super.onDestroy()
        addProdVM.cancelJobs()
        categoriesVM.cancelJobs()
    }
}
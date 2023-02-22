package com.rzxengineering.shopapp.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.rzxengineering.shopapp.R
import com.rzxengineering.shopapp.intentCodes.IntentCodes
import com.rzxengineering.shopapp.objects.Product
import com.rzxengineering.shopapp.viewmodels.ProductViewModel
import com.rzxengineering.shopapp.viewmodels.UpdateProductViewModel

class EditProductFragment: Fragment(R.layout.edit_product_fragment) {
    lateinit var navController: NavController
    lateinit var productVM: ProductViewModel
    lateinit var editVM: UpdateProductViewModel
    lateinit var name: EditText
    lateinit var price: EditText
    lateinit var sale: EditText
    lateinit var editBtn: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        productVM = ViewModelProvider(this)[ProductViewModel::class.java]
        editVM = ViewModelProvider(this)[UpdateProductViewModel::class.java]
        var preferences= requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)

        navController = Navigation.findNavController(view)
        name = requireView().findViewById(R.id.nameEditProdEt)
        price = requireView().findViewById(R.id.priceEditProdEt)
        sale = requireView().findViewById(R.id.saleEditProdEt)
        editBtn = requireView().findViewById(R.id.editProdBtn)
        productVM.setId(preferences.getInt(IntentCodes.Identifications.IDPRODUCT,0))
        productVM.response.observe(viewLifecycleOwner){
            if(it.statusCode==1)
                alert(resources.getString(R.string.alertServerError))
            else{
                name.setText(it.name)
                price.setText(it.price.toString())
                sale.setText(it.sale.toString())
                editBtn.setOnClickListener {
                    if(name.text.isEmpty()||price.text.isEmpty()||sale.text.isEmpty())
                        alert(resources.getString(R.string.alertEmpty))
                    else if(price.text.toString().toFloat()<=0)
                        alert(resources.getString(R.string.alertPriceLow))
                    else if(price.text.toString().toFloat()>10000)
                        alert(resources.getString(R.string.alertPriceHigh))
                    else if(sale.text.toString().toInt()<0)
                        alert(resources.getString(R.string.alertSaleLow))
                    else if(sale.text.toString().toInt()>=100)
                        alert(resources.getString(R.string.alertSaleHigh))
                    else {
                        editVM.setId(Product(0,0,0,name.text.toString(),
                        price.text.toString().toFloat(),0,0,
                        sale.text.toString().toInt(),0,ByteArray(0),"",
                            false))
                        editVM.response.observe(viewLifecycleOwner){
                            if(it.response==1)
                                alert(resources.getString(R.string.alertServerError))
                            else
                                confirmation()
                        }
                    }
                }
            }
        }

    }
    private fun alert(msg: String){
        val alert = AlertDialog.Builder(requireContext())
        alert.setCancelable(false)
        alert.setTitle("")
        alert.setMessage(msg)
        alert.setPositiveButton(R.string.ok) { dialogInterface, i ->
            var preferences= requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)
            var editor = preferences.edit()
            editor.clear()
            editor.apply()

        }
        alert.setNegativeButton(R.string.back) { dialogInterface, i ->

        }
        alert.show()
    }
    private fun confirmation(){
        val alert = AlertDialog.Builder(requireContext())
        alert.setCancelable(false)
        alert.setTitle("")
        alert.setMessage(R.string.confEditProd)
        alert.setPositiveButton(R.string.ok) { dialogInterface, i ->
            navController.popBackStack(R.id.homeFragment,false)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        productVM.cancelJobs()
        editVM.cancelJobs()
    }
}
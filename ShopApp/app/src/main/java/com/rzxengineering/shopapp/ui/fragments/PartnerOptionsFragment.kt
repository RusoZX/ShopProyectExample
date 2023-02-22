package com.rzxengineering.shopapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.rzxengineering.shopapp.R

class PartnerOptionsFragment: Fragment(R.layout.partner_options_fragment) {
    lateinit var navController: NavController
    lateinit var sales: Button
    lateinit var products: Button
    lateinit var addProducts: Button
    lateinit var editProduct: Button
    lateinit var makeRestock: Button
    lateinit var historyRestocks: Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sales= requireView().findViewById(R.id.partnerSalesBtn)
        products= requireView().findViewById(R.id.partnerProductsBtn)
        addProducts= requireView().findViewById(R.id.partnerAddProductBtn)
        editProduct= requireView().findViewById(R.id.partnerEditProductBtn)
        makeRestock= requireView().findViewById(R.id.partnerMakeRestockBtn)
        historyRestocks= requireView().findViewById(R.id.partnerRestockHistoryBtn)
        sales.setOnClickListener {
            navController.navigate(R.id.action_partnerOptionsFragment_to_salesFragment)
        }
        products.setOnClickListener {
            navController.navigate(R.id.action_partnerOptionsFragment_to_productsPartnerFragment)
        }
        addProducts.setOnClickListener {
            navController.navigate(R.id.action_partnerOptionsFragment_to_addProductFragment)
        }
        editProduct.setOnClickListener {
            navController.navigate(R.id.action_partnerOptionsFragment_to_editProductFragment)
        }
        makeRestock.setOnClickListener {
            navController.navigate(R.id.action_partnerOptionsFragment_to_makeRestockFragment)
        }
        historyRestocks.setOnClickListener {
            navController.navigate(R.id.action_partnerOptionsFragment_to_restocksFragment)
        }
    }
}
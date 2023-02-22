package com.rzxengineering.shopapp.ui.fragments.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.DialogFragment
import com.rzxengineering.shopapp.R
import com.rzxengineering.shopapp.ui.fragments.ProductsPartnerFragment

class FilterPartnerDialog(parent : ProductsPartnerFragment): DialogFragment() {
    lateinit var spinnerMode: Spinner
    lateinit var spinnerQuantity: Spinner
    lateinit var searchBtn: Button
    var parent = parent
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //Here we set up the spinner for the searching modes
        var view : View = inflater.inflate(R.layout.filters_dialog, container, false)
        spinnerMode = view.findViewById(R.id.filterDialogSpinner)
        var arraySpinner=arrayOf(
            resources.getString(R.string.optionNameAsc),resources.getString(R.string.optionNameDesc),
            resources.getString(R.string.optionPriceAsc),resources.getString(R.string.optionPriceDesc),
            resources.getString(R.string.optionSellsAsc),resources.getString(R.string.optionSellsDesc)
        )
        var adapter = ArrayAdapter<String>(requireContext(),
            android.R.layout.simple_spinner_item,arraySpinner)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMode.adapter=adapter
        //Here we set up the spinner for the quantity
        spinnerQuantity = view.findViewById(R.id.quantityDialogSpinner)
        arraySpinner=arrayOf("5","10","15","20","25","30")
        adapter = ArrayAdapter<String>(requireContext(),
            android.R.layout.simple_spinner_item,arraySpinner)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerQuantity.adapter=adapter

        searchBtn = view.findViewById(R.id.searchDialogBtn)

        searchBtn.setOnClickListener {
            parent.updateAdapter(Integer.parseInt(spinnerQuantity.selectedItem.toString())
                ,spinnerMode.selectedItem.toString())
            dismiss()
        }

        return view
    }

}
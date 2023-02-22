package com.rzxengineering.shopapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.rzxengineering.shopapp.R
import com.rzxengineering.shopapp.intentCodes.IntentCodes
import com.rzxengineering.shopapp.viewmodels.CategoriesViewModel

class SearchFragment : Fragment(R.layout.search_fragment) {
    lateinit var navController: NavController

    lateinit var search: EditText
    lateinit var searchButton: ImageButton
    lateinit var btn: Button
    lateinit var categoriesVM: CategoriesViewModel
    lateinit var list: ArrayList<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        search = requireActivity().findViewById(R.id.searchEt)
        searchButton = requireActivity().findViewById(R.id.searchBtn)
        searchButton.setOnClickListener {
            if (search.text.isEmpty())
                alert(resources.getString(R.string.alertEmpty))
            else {
                var bundle = Bundle()
                bundle.putString(IntentCodes.Identifications.SEARCH, search.text.toString())
                bundle.putString(IntentCodes.Identifications.CATEGORY, "")
                navController.navigate(R.id.action_searchFragment_to_searchResultFragment, bundle)
            }
        }
        categoriesVM = ViewModelProvider(this)[CategoriesViewModel::class.java]
        categoriesVM.setId(true)
        categoriesVM.response.observe(viewLifecycleOwner) {
            list = it
            for (string in list) {
                btn = Button(requireContext())
                Log.d("LAYOUT",string)
                btn.text = string
                btn.height = 60
                btn.width = 365
                btn.layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                btn.setOnClickListener {
                    var bundle = Bundle()
                    bundle.putString(IntentCodes.Identifications.SEARCH, "")
                    bundle.putString(IntentCodes.Identifications.CATEGORY, string)
                    navController.navigate(R.id.action_searchFragment_to_searchResultFragment, bundle)
                }
                val linearLayout = requireView().findViewById<LinearLayout>(R.id.searchLL)
                if(linearLayout== null)
                    Log.d("LAYOUT","nulo")
                linearLayout.addView(btn)
            }
        }

    }

    fun alert(msj: String?) {
        val alert = AlertDialog.Builder(requireContext())
        alert.setCancelable(false)
        alert.setTitle("")
        alert.setMessage(msj)
        alert.setPositiveButton(R.string.back) { dialogInterface, i ->
            navController.popBackStack(R.id.homeFragment, false)
        }
        alert.show()
    }
}
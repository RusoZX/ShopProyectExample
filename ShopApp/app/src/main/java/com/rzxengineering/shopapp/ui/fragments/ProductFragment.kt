package com.rzxengineering.shopapp.ui.fragments

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.rzxengineering.shopapp.R
import com.rzxengineering.shopapp.intentCodes.IntentCodes
import com.rzxengineering.shopapp.viewmodels.ProductViewModel
import java.math.RoundingMode
import java.text.DecimalFormat

class ProductFragment: Fragment(R.layout.product_fragment) {
    //First we declare the navigation controller and the view model that will get the information
    //of the product to show
    lateinit var navController: NavController
    lateinit var productVM: ProductViewModel

    //Now we declare the Text views were we will put the data
    lateinit var name: TextView
    lateinit var category: TextView
    lateinit var price: TextView
    lateinit var sale: TextView
    lateinit var unitsInExistence: TextView
    lateinit var unitsSold: TextView
    lateinit var addToCart: Button
    lateinit var image : ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name = requireView().findViewById(R.id.productNameTV)
        category = requireView().findViewById(R.id.productCategoryTV)
        price = requireView().findViewById(R.id.productPrice)
        sale = requireView().findViewById(R.id.productSaleTV)
        unitsInExistence = requireView().findViewById(R.id.productUnitsInExistenceTV)
        unitsSold = requireView().findViewById(R.id.productUnitsSoldTV)
        addToCart = requireView().findViewById(R.id.addToCardBtn)
        image = requireView().findViewById(R.id.productIV)

        productVM= ViewModelProvider(this)[ProductViewModel::class.java]
        navController = Navigation.findNavController(view)
        productVM.setId(requireArguments().getInt(IntentCodes.Identifications.IDPRODUCT))

        productVM.response.observe(viewLifecycleOwner){
            if(it.statusCode==1)
                alert(resources.getString(R.string.alertServerError))
            var bmp = BitmapFactory.decodeByteArray(it.image, 0, it.image.size)
            name.text=String.format(resources.getString(R.string.nameInsert),it.name)
            category.text=String.format(resources.getString(R.string.categoryInsert),it.category)
            val df = DecimalFormat("#.##")
            df.roundingMode = RoundingMode.DOWN
            price.text=String.format(resources.getString(R.string.priceInsert), df.format(it.price*(1.00-it.sale/100)))
            sale.text=String.format(resources.getString(R.string.saleInsert),it.sale)
            unitsInExistence.text=String.format(resources.getString(
                R.string.unitsInExistenceInsert),it.unitsInExistence)
            unitsSold.text=String.format(resources.getString(R.string.unitsSoldInsert),it.unitsSold)
            image.setImageBitmap(bmp)
        }
        addToCart.setOnClickListener {

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
    override fun onDestroy() {
        super.onDestroy()
        productVM.cancelJobs()
    }

}
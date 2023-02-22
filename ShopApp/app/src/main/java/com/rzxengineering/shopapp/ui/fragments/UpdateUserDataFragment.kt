package com.rzxengineering.shopapp.ui.fragments

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
import com.rzxengineering.shopapp.objects.UserData
import com.rzxengineering.shopapp.viewmodels.UpdateUserViewModel

class UpdateUserDataFragment: Fragment(R.layout.update_data_fragment) {
    //First we declare the navigation controller and the view model that will send the new information
    //to the server
    lateinit var navController: NavController
    lateinit var updateVM: UpdateUserViewModel
    //Now we declare the Text views were we will put the data
    lateinit var name: EditText
    lateinit var surname: EditText
    lateinit var mail: EditText
    lateinit var phone: EditText
    lateinit var address: EditText
    lateinit var changeBtn: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name = requireView().findViewById(R.id.nameChngEt)
        surname = requireView().findViewById(R.id.surnameChngEt)
        mail = requireView().findViewById(R.id.mailChngEt)
        phone = requireView().findViewById(R.id.phoneChngEt)
        address = requireView().findViewById(R.id.addressChngEt)
        changeBtn = requireView().findViewById(R.id.changeBtn)
        navController= Navigation.findNavController(view)

        changeBtn.setOnClickListener {
            if(name.text.isEmpty()&&surname.text.isEmpty()&&mail.text.isEmpty()&&phone.text.isEmpty()
                &&address.text.isEmpty())
                alert()
            else{
                updateVM = ViewModelProvider(this)[UpdateUserViewModel::class.java]
                updateVM.setLogin(UserData(0,0,"",0,name.text.toString(),
                surname.text.toString(),phone.text.toString(),address.text.toString(),0,
                    ByteArray(0),""))
                updateVM.response.observe(viewLifecycleOwner){
                    if(it.response==0)
                        alert(resources.getString(R.string.successfullChange))
                    else
                        alert(resources.getString(R.string.alertServerError))
                }
            }
        }
    }
    fun alert() {
        val alert = AlertDialog.Builder(requireContext())
        alert.setCancelable(false)
        alert.setTitle("")
        alert.setMessage(R.string.alertEmptyChange)
        alert.setPositiveButton(R.string.back) { dialogInterface, i ->

        }
        alert.show()
    }
    fun alert(msj: String?) {
        val alert = AlertDialog.Builder(requireContext())
        alert.setCancelable(false)
        alert.setTitle("")
        alert.setMessage(msj)
        alert.setPositiveButton(R.string.ok) { dialogInterface, i ->
            navController.popBackStack(R.id.homeFragment, false)
        }
        alert.show()
    }
}
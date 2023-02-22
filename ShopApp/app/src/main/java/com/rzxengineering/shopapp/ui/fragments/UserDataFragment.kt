package com.rzxengineering.shopapp.ui.fragments

import android.content.Context
import android.os.Bundle
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
import com.rzxengineering.shopapp.viewmodels.UserDataViewModel

class UserDataFragment: Fragment(R.layout.data_fragment) {
    lateinit var navController: NavController
    lateinit var dataVM: UserDataViewModel

    lateinit var name:TextView
    lateinit var surname:TextView
    lateinit var mail:TextView
    lateinit var phone:TextView
    lateinit var address:TextView
    lateinit var changePwd: Button
    lateinit var changeData: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        name = requireView().findViewById(R.id.nameTv)
        surname = requireView().findViewById(R.id.surnameTv)
        mail = requireView().findViewById(R.id.mailTv)
        phone = requireView().findViewById(R.id.phoneTv)
        address = requireView().findViewById(R.id.addressTv)
        changePwd = requireView().findViewById(R.id.pwdChangeBtn)
        changeData = requireView().findViewById(R.id.editDataIV)

        var preferences= requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)
        dataVM = ViewModelProvider(this)[UserDataViewModel::class.java]
        navController= Navigation.findNavController(view)

        dataVM.setId(preferences.getInt(IntentCodes.Identifications.IDCLIENT,1))

        dataVM.userData.observe(viewLifecycleOwner){
            if(it.statusCode==1)
                alert(resources.getString(R.string.alertServerError))
            else{
                name.text= String.format(resources.getString(R.string.nameTv),it.name)
                surname.text= String.format(resources.getString(R.string.surnameTv), it.surname)
                mail.text= String.format(resources.getString(R.string.mailTv),"")
                phone.text= String.format(resources.getString(R.string.phoneTv),it.phone)
                address.text= String.format(resources.getString(R.string.addressTv),it.address)
                changePwd.setOnClickListener {
                    navController.navigate(R.id.action_userDataFragment_to_changePwdFragment)
                }
                changeData.setOnClickListener {
                    navController.navigate(R.id.action_userDataFragment_to_updateUserDataFragment)
                }
            }
        }

    }
    fun alert(msj: String?) {
        val alert = AlertDialog.Builder(requireContext())
        alert.setCancelable(false)
        alert.setTitle("")
        alert.setMessage(msj)
        alert.setPositiveButton(R.string.back) { dialogInterface, i ->

        }
        alert.show()
    }
}
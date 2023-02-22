package com.rzxengineering.shopapp.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
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
import com.rzxengineering.shopapp.objects.PwdChange
import com.rzxengineering.shopapp.viewmodels.ChangePwdViewModel

class ChangePwdFragment: Fragment(R.layout.password_change_fragment) {
    lateinit var navController: NavController
    lateinit var changeVM : ChangePwdViewModel

    lateinit var oldPwd: EditText
    lateinit var confOldPwd:EditText
    lateinit var newPwd: EditText
    lateinit var changeBtn:Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        oldPwd= requireView().findViewById(R.id.oldPwdEt)
        confOldPwd = requireView().findViewById(R.id.oldPwdConfEt)
        newPwd = requireView().findViewById(R.id.newPwdEt)
        changeBtn = requireView().findViewById(R.id.changePwdBtn)

        changeVM = ViewModelProvider(this)[ChangePwdViewModel::class.java]
        changeBtn.setOnClickListener {
            Log.d("Some Shit",oldPwd.text.toString()+confOldPwd.text.toString())
            if(oldPwd.text.isEmpty()||confOldPwd.text.isEmpty()||newPwd.text.isEmpty())
                alert(resources.getString(R.string.alertEmpty))
            else if(oldPwd.text.toString()!=confOldPwd.text.toString())
                alert(resources.getString(R.string.alertIncorrectPwd))
            else{
                var preferences= requireActivity().getSharedPreferences("login",
                    Context.MODE_PRIVATE)
                changeVM.setId(PwdChange(oldPwd.text.toString(),newPwd.text.toString(),
                    preferences.getInt(IntentCodes.Identifications.IDCLIENT,1)))
                changeVM.response.observe(viewLifecycleOwner){
                    when(it.response){
                        0->{
                            conf()
                        }
                        1->{
                            alert(resources.getString(R.string.alertServerError))
                        }
                        5->{
                            alert(resources.getString(R.string.pwdIncorrectSrv))
                        }
                    }
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
    fun conf() {
        val alert = AlertDialog.Builder(requireContext())
        alert.setCancelable(false)
        alert.setTitle("")
        alert.setMessage(R.string.pwdConfirmation)
        alert.setPositiveButton(R.string.ok) { dialogInterface, i ->
            navController.popBackStack(R.id.homeFragment,false)
        }
        alert.show()
    }
}
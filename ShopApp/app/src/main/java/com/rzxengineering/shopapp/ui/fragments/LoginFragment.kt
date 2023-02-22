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
import com.rzxengineering.shopapp.objects.Login
import com.rzxengineering.shopapp.viewmodels.LoginViewModel

class LoginFragment:Fragment(R.layout.login_fragment) {
    lateinit var navControler: NavController
    lateinit var loginVM: LoginViewModel
    lateinit var nickName: EditText
    lateinit var pwd: EditText

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navControler= Navigation.findNavController(view)
        loginVM=ViewModelProvider(this)[LoginViewModel::class.java]

        var loginBtn: Button= view.findViewById(R.id.loginBtn)
        nickName = view.findViewById(R.id.userEt)
        pwd= view.findViewById(R.id.pwdEt)
        loginBtn.setOnClickListener {
            verify()
        }
    }
    fun verify(){
        if(nickName.text.isEmpty()||pwd.text.isEmpty())
            alert(resources.getString(R.string.alertEmpty))
        else{

            loginVM.setLogin(Login(nickName.text.toString(),pwd.text.toString()))
            loginVM.userData.observe(viewLifecycleOwner){
                when(it.statusCode){
                    0 ->{
                        var preferences= requireActivity().getSharedPreferences("login",
                        Context.MODE_PRIVATE)
                        var data=Bundle()
                        data.putInt(IntentCodes.Identifications.IDCLIENT, it.id)
                        val editor= preferences.edit()

                        editor.putInt(IntentCodes.Identifications.IDCLIENT, it.id)
                        editor.putBoolean("isLogged", true)
                        editor.putString(IntentCodes.Identifications.CLIENTNAME,it.name)
                        editor.putInt(IntentCodes.Identifications.TYPE, it.type)
                        editor.apply()
                        navControler.navigate(R.id.action_login_to_home)
                    }
                    1 ->{
                        alert(resources.getString(R.string.alertServerError))
                    }
                    2 ->{
                        alert(resources.getString(R.string.alertIncorrect))
                    }


                }
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
}
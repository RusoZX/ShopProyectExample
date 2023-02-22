package com.rzxengineering.shopapp.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.rzxengineering.shopapp.R
import com.rzxengineering.shopapp.intentCodes.IntentCodes
import com.rzxengineering.shopapp.objects.UserData
import com.rzxengineering.shopapp.viewmodels.UpdateUserViewModel

class ClientSettingsFragment : Fragment(R.layout.client_settings_fragment){
    lateinit var navController: NavController
    lateinit var textView: TextView
    lateinit var dataBtn: Button
    lateinit var historyBtn: Button
    lateinit var partnerBtn:Button
    lateinit var logOutBtn: Button
    lateinit var changeTypeVM: UpdateUserViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        textView = requireView().findViewById(R.id.clientSettingsTv)
        dataBtn = requireView().findViewById(R.id.dataClientBtn)
        historyBtn = requireView().findViewById(R.id.historyClientBtn)
        partnerBtn = requireView().findViewById(R.id.partnerClientBtn)
        logOutBtn = requireView().findViewById(R.id.logOutClientBtn)
        changeTypeVM = ViewModelProvider(this)[UpdateUserViewModel::class.java]

        var preferences= requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)
        textView.text= String.format(resources.getString(R.string.wellcome,
        preferences.getString(IntentCodes.Identifications.CLIENTNAME,"user")))
        if(preferences.getInt(IntentCodes.Identifications.TYPE,-1)==2){
            partnerBtn.text = resources.getString(R.string.partnerBtn)
            partnerBtn.setOnClickListener{
                navController.navigate(R.id.action_clientSettingsFragment_to_partnerOptionsFragment)
            }
        }
        else
            partnerBtn.setOnClickListener{

            }

        dataBtn.setOnClickListener{
            navController.navigate(R.id.action_clientSettingsFragment_to_userDataFragment)
        }
        historyBtn.setOnClickListener{
            navController.navigate(R.id.action_clientSettingsFragment_to_buysFragment)
        }
        partnerBtn.setOnClickListener{
            confPartner()
        }
        logOutBtn.setOnClickListener {
            logOut()
        }

    }
    private fun logOut(){
        val alert = AlertDialog.Builder(requireContext())
        alert.setCancelable(false)
        alert.setTitle("")
        alert.setMessage(R.string.alertLogOut)
        alert.setPositiveButton(R.string.yes) { dialogInterface, i ->
            var preferences= requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)
            var editor = preferences.edit()
            editor.clear()
            editor.apply()
            navController.popBackStack(R.id.loginFragment,false)
        }
        alert.setNegativeButton(R.string.no) { dialogInterface, i ->

        }
        alert.show()
    }
    private fun confPartner(){
        val alert = AlertDialog.Builder(requireContext())
        alert.setCancelable(false)
        alert.setTitle("")
        alert.setMessage(R.string.partnerConf)
        alert.setPositiveButton(R.string.yes) { dialogInterface, i ->
            var preferences= requireActivity().getSharedPreferences("login", Context.MODE_PRIVATE)
            changeTypeVM.setLogin(UserData(0,
                preferences.getInt(IntentCodes.Identifications.IDCLIENT,-1),"",2,
                "","","", "",0, ByteArray(0),""
            ))
            changeTypeVM.response.observe(viewLifecycleOwner){
                if(it.response==1)
                    alert(resources.getString(R.string.alertServerError))
                else
                    newPartner()
            }
        }
        alert.setNegativeButton(R.string.no) { dialogInterface, i ->

        }
        alert.show()
    }
    private fun alert(msg:String){
        val alert = AlertDialog.Builder(requireContext())
        alert.setCancelable(false)
        alert.setTitle("")
        alert.setMessage(msg)
        alert.setPositiveButton(R.string.back) { dialogInterface, i ->

        }

        alert.show()
    }
    private fun newPartner(){
        val alert = AlertDialog.Builder(requireContext())
        alert.setCancelable(false)
        alert.setTitle("")
        alert.setMessage(R.string.partnerAddSomeProducts)
        alert.setPositiveButton(R.string.ok) { dialogInterface, i ->
            navController.navigate(R.id.action_clientSettingsFragment_to_addProductFragment)
        }
        alert.setNegativeButton(R.string.no) { dialogInterface, i ->
            navController.popBackStack(R.id.homeFragment,false)
        }

        alert.show()
    }
}
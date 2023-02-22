package com.rzxengineering.shopapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.rzxengineering.shopapp.R

class MainActivity : AppCompatActivity() {

    lateinit var navController: NavController
    var firstTime = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var navHostFragment= supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
                as NavHostFragment
        navController = navHostFragment.navController
        Navigation.setViewNavController(findViewById(android.R.id.content), navController)

        //Here we will manage the tool bar
        var home= requireViewById<ImageView>(R.id.homeIv)
        home.setOnClickListener{
            navController.popBackStack(R.id.homeFragment, false)
        }
        var search= requireViewById<ImageView>(R.id.searchIv)
        search.setOnClickListener {
            navController.navigate(R.id.searchFragment)
        }
        var shoppingList= requireViewById<ImageView>(R.id.cartIv)
        shoppingList.setOnClickListener {
            navController.navigate(R.id.shoppingListFragment)
        }
        var likes =requireViewById<ImageView>(R.id.favIv)
        likes.setOnClickListener {
            navController.navigate(R.id.likesFragment)
        }
        var user = requireViewById<ImageView>(R.id.userIv)
        user.setOnClickListener{
            navController.navigate(R.id.clientSettingsFragment)
        }
    }
}
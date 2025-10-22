package com.android.baseapp.ui.activity.main

import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.android.baseapp.R
import com.android.baseapp.core.BaseActivity
import com.android.baseapp.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(
    MainViewModel::class
) {
    //Variables
    override val getLayoutId: Int
        get() = R.layout.activity_main

    //lifecycles
    override fun initView() {
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }

    //Companion Object
    companion object{

    }
}
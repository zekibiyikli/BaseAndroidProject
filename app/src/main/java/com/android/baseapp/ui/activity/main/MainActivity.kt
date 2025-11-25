package com.android.baseapp.ui.activity.main

import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.android.baseapp.R
import com.android.baseapp.core.BaseActivity
import com.android.baseapp.databinding.ActivityMainBinding
import com.android.baseapp.ui.fragment.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
        navView.setupWithNavController(navController)

        viewModel.readDataStore(this)
    }

    //Companion Object
    companion object{

    }
}
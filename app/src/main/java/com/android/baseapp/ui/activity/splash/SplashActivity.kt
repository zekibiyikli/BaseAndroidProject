package com.android.baseapp.ui.activity.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Handler
import android.os.Looper
import com.android.baseapp.R
import com.android.baseapp.core.BaseActivity
import com.android.baseapp.databinding.ActivitySplashBinding
import com.android.baseapp.ui.activity.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(
    SplashViewModel::class
) {

    //Variables
    override val getLayoutId: Int
        get() = R.layout.activity_splash

    //lifecycles
    override fun initView() {

        viewModel.setDataStore(this)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

    //Companion Object
    companion object{

    }
}
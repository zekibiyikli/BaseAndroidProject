package com.android.baseapp.ui.activity.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.android.baseapp.R
import com.android.baseapp.core.BaseActivity
import com.android.baseapp.databinding.ActivitySplashBinding
import com.android.baseapp.ui.activity.main.MainActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>(
    SplashViewModel::class
) {
    //Variables
    override val getLayoutId: Int
        get() = R.layout.activity_splash

    //lifecycles
    override fun initView() {
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
package com.android.baseapp.app

import android.app.Application
import com.android.baseapp.data.local.KotPref
import com.android.baseapp.data.room.Room
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        app = this

        Room().initRoom(this)
        KotPref().initialize(this)
    }

    companion object{
        private var app: BaseApp? = null
    }
}
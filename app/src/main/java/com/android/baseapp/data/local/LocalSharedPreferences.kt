package com.android.baseapp.data.local

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.android.baseapp.enums.LocalSharedPrefKey

class LocalSharedPreferences(private val applicationContext: Context) {

    //Variables
    private val masterKey = MasterKey.Builder(applicationContext)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()
    private var pref: SharedPreferences = EncryptedSharedPreferences.create(
        applicationContext,
        "secret_shared_prefs",
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    //Functions
    var isFirstRun : Boolean
        set(value) = pref.edit().putBoolean(LocalSharedPrefKey.TEST,value).apply()
        get() = pref.getBoolean(LocalSharedPrefKey.TEST,true)

    //Companion Object
    companion object {
        @Volatile
        private var instance: LocalSharedPreferences? = null
        fun init(context: Context) = instance ?: synchronized(this) {
            instance = LocalSharedPreferences(context.applicationContext)
        }

        fun getInstance(): LocalSharedPreferences =
            instance ?: throw IllegalArgumentException("Local data is not initialize")
    }
}
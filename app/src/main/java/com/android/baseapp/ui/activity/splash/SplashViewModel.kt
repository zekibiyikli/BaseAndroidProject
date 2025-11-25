package com.android.baseapp.ui.activity.splash

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.android.baseapp.core.BaseRepository
import com.android.baseapp.core.BaseViewModel
import com.android.baseapp.data.local.datastore.PreferencesKeys
import com.android.baseapp.data.local.datastore.saveToDataStore
import com.android.baseapp.data.server.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    val repo: MainRepo
) : BaseViewModel<BaseRepository>(){

    fun setDataStore(context: Context){
        viewModelScope.launch {
            context.saveToDataStore(PreferencesKeys.USER_NAME,"Test")
            context.saveToDataStore(PreferencesKeys.USER_AGE,10)
        }
    }
}

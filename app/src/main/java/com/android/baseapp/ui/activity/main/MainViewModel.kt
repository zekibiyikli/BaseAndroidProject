package com.android.baseapp.ui.activity.main

import android.content.Context
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.android.baseapp.core.BaseRepository
import com.android.baseapp.core.BaseViewModel
import com.android.baseapp.data.local.datastore.PreferencesKeys
import com.android.baseapp.data.local.datastore.readFromDataStore
import com.android.baseapp.data.local.lsp.LocalSharedPreferences
import com.android.baseapp.data.server.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class MainViewModel @Inject constructor(
    val repo: MainRepo,
    val localData: LocalSharedPreferences
) : BaseViewModel<BaseRepository>(){

    fun readDataStore(context: Context){
        val nameFlow: Flow<String> = context.readFromDataStore(PreferencesKeys.USER_NAME, "")
        val ageFlow: Flow<Int> = context.readFromDataStore(PreferencesKeys.USER_AGE, 0)
        viewModelScope.launch {
            nameFlow.collect {
                Log.e("DevTest","$it")
            }
        }
        viewModelScope.launch {
            ageFlow.collect {
                Log.e("DevTest","$it")
            }
        }
    }
}
package com.android.baseapp.ui.activity.main

import com.android.baseapp.core.BaseRepository
import com.android.baseapp.core.BaseViewModel
import com.android.baseapp.data.local.LocalSharedPreferences
import com.android.baseapp.data.server.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class MainViewModel @Inject constructor(
    val repo: MainRepo,
    val localData: LocalSharedPreferences
) : BaseViewModel<BaseRepository>(){

}
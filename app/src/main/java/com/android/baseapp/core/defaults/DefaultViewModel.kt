package com.android.baseapp.core.defaults

import com.android.baseapp.core.BaseRepository
import com.android.baseapp.core.BaseViewModel
import com.android.baseapp.data.local.lsp.LocalSharedPreferences
import com.android.baseapp.data.server.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
open class DefaultViewModel @Inject constructor(
    val repo: MainRepo,
    val localData: LocalSharedPreferences
) : BaseViewModel<BaseRepository>()

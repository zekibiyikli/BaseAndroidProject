package com.android.baseapp.ui.fragment.userdetail

import com.android.baseapp.core.BaseRepository
import com.android.baseapp.core.BaseViewModel
import com.android.baseapp.data.server.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    val repo: MainRepo
) : BaseViewModel<BaseRepository>(){

}

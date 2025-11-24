package com.android.baseapp.ui.fragment.notifications

import com.android.baseapp.core.BaseRepository
import com.android.baseapp.core.BaseViewModel
import com.android.baseapp.data.server.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotificationsViewModel @Inject constructor(
    val repo: MainRepo
) : BaseViewModel<BaseRepository>(){

}
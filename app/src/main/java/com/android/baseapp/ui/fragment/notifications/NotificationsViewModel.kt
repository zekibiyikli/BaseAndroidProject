package com.android.baseapp.ui.fragment.notifications

import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.android.baseapp.core.BaseRepository
import com.android.baseapp.core.BaseViewModel
import com.android.baseapp.data.server.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NotificationsViewModel @Inject constructor(
    val repo: MainRepo
) : BaseViewModel<BaseRepository>(){

    val userFlow = repo.getRandomUsers2().cachedIn(viewModelScope)


}
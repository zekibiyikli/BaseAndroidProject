package com.android.baseapp.ui.fragment.dashboard

import com.android.baseapp.core.BaseRepository
import com.android.baseapp.core.BaseViewModel
import com.android.baseapp.data.flow.ApiResult
import com.android.baseapp.data.flow.toResultFlow
import com.android.baseapp.data.server.MainRepo
import com.android.baseapp.model.ErrorModel
import com.android.baseapp.model.response.UserResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    val repo: MainRepo
) : BaseViewModel<BaseRepository>(){

    private val _usersFlow = MutableSharedFlow<ApiResult<UserResponse, ErrorModel>?>(replay = 0)
    val usersFlow = _usersFlow.asSharedFlow()
    fun getRandomUsers(){
        sendRequest {
            toResultFlow {
                repo.getRandomUsers()
            }.collect{result->
                _usersFlow.emit(result)
            }
        }
    }

}

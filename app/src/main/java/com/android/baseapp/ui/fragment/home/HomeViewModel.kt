package com.android.baseapp.ui.fragment.home

import androidx.lifecycle.MutableLiveData
import com.android.baseapp.core.BaseRepository
import com.android.baseapp.core.BaseViewModel
import com.android.baseapp.data.flow.ApiResult
import com.android.baseapp.data.flow.toResultFlow
import com.android.baseapp.data.server.MainRepo
import com.android.baseapp.model.response.StateUsaPriceResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val repo: MainRepo
) : BaseViewModel<BaseRepository>(){

    var mutableStateUsaPrice: MutableLiveData<ApiResult<StateUsaPriceResponse>>? = MutableLiveData<ApiResult<StateUsaPriceResponse>>()
    fun getStateUsaPrice(state:String){
        sendRequest {
            toResultFlow {
                repo.stateUsaPrice("çankaya","Ankara")
            }.collect{result->
                mutableStateUsaPrice?.value=result
            }
        }
    }

}
package com.android.baseapp.ui.fragment.home

import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import com.android.baseapp.R
import com.android.baseapp.core.BaseFragment
import com.android.baseapp.data.flow.ApiResult
import com.android.baseapp.data.flow.ApiResultHandler
import com.android.baseapp.databinding.FragmentHomeBinding
import com.android.baseapp.ext.notNullObserver
import com.android.baseapp.model.response.StateUsaPriceResponse

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    HomeViewModel::class
) {

    //Layout
    override val getLayoutId: Int
        get() = R.layout.fragment_home

    //Observers
    private val observerStateUsaPrice: Observer<in ApiResult<StateUsaPriceResponse?>> = notNullObserver{ data ->
        Log.e("Zeki","Girdiiii")
        val apiResultHandler = ApiResultHandler<StateUsaPriceResponse?>(
            onSuccess = {
                Log.e("Zeki","onSuccess")
                it?.result?.let {result->

                }
            },
            onFailure = {

            },
            onLoading = {}
        )
        apiResultHandler.handleApiResult(data)
    }

    //Lifecycles
    override fun initView() {
        val textView: TextView = binding.textHome
        textView.text="HOME"
        viewModel.getStateUsaPrice("WA")
    }

    override fun initListeners() {
        super.initListeners()
        with(binding){

        }
    }

    override fun initObservers() {
        super.initObservers()
        with(viewModel){
            mutableStateUsaPrice?.observe(this@HomeFragment,observerStateUsaPrice)
        }
    }
}
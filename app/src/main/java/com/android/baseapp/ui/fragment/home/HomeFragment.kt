package com.android.baseapp.ui.fragment.home

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.android.baseapp.R
import com.android.baseapp.adapter.shimmer.ShimmerAdapter
import com.android.baseapp.adapter.user.UserAdapter
import com.android.baseapp.core.BaseFragment
import com.android.baseapp.data.flow.ApiResult
import com.android.baseapp.data.flow.ApiResultHandler
import com.android.baseapp.databinding.FragmentHomeBinding
import com.android.baseapp.model.ErrorModel
import com.android.baseapp.model.UserModel
import com.android.baseapp.model.response.UserResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>(
    HomeViewModel::class
) {

    //Layout
    override val getLayoutId: Int
        get() = R.layout.fragment_home

    private lateinit var userAdapter: UserAdapter

    //Lifecycles
    override fun initView() {
        showShimmer()
        viewModel.getRandomUsers()
    }

    override fun initListeners() {
        super.initListeners()
        with(binding){

        }
    }

    override fun initObservers() {
        super.initObservers()
        viewLifecycleOwner.lifecycleScope.launch {
            launch { viewModel.usersFlow.collectLatest{it?.let { observerUsers(it) }} }
        }
    }

    private fun showShimmer(){
        binding.rvUsers.layoutManager = LinearLayoutManager(requireContext())
        binding.rvUsers.adapter = ShimmerAdapter()
    }

    private fun setList(list: ArrayList<UserModel>){
        userAdapter = UserAdapter(
            list,
            ::userClickListener,
            ::userLongClickListener,
            requireContext()
        )
        binding.rvUsers.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        }

    }

    private fun userClickListener(user: UserModel?) {
        user?.let {

        }
    }

    private fun userLongClickListener(user: UserModel?) {
        user?.let {

        }
    }


    //Observers
    private fun observerUsers(data:ApiResult<UserResponse, ErrorModel>){
        ApiResultHandler<UserResponse?, ErrorModel>(
            onSuccess = {
                it?.results?.let { result->
                    setList(result)
                }
            },
            onFailure = {

            }
        ).handleApiResult(data)
    }

}
package com.android.baseapp.ui.fragment.dashboard

import android.util.Log
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.baseapp.R
import com.android.baseapp.adapter.shimmer.ShimmerAdapter
import com.android.baseapp.adapter.user.UserAdapter
import com.android.baseapp.adapter.user3.User3Adapter
import com.android.baseapp.core.BaseFragment
import com.android.baseapp.data.flow.ApiResult
import com.android.baseapp.data.flow.ApiResultHandler
import com.android.baseapp.databinding.FragmentDashboardBinding
import com.android.baseapp.model.ErrorModel
import com.android.baseapp.model.UserModel
import com.android.baseapp.model.response.UserResponse
import com.android.baseapp.ui.fragment.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding, DashboardViewModel>(
    DashboardViewModel::class
) {

    private lateinit var userAdapter: User3Adapter

    //Layout
    override val getLayoutId: Int
        get() = R.layout.fragment_dashboard

    //Lifecycles
    override fun initView() {
        showShimmer()
        viewModel.getRandomUsers()
    }

    override fun initListeners() {
        super.initListeners()
    }

    override fun initObservers() {
        super.initObservers()
        viewLifecycleOwner.lifecycleScope.launch {
            launch { viewModel.usersFlow.collectLatest{it?.let { observerUsers(it) }} }
        }
    }

    //Functions
    private fun showShimmer(){
        binding.rvUsers.layoutManager = LinearLayoutManager(requireContext())
        binding.rvUsers.adapter = ShimmerAdapter()
    }

    private fun setList(list: ArrayList<UserModel>){
        userAdapter = User3Adapter(
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
        user?.let {}
    }

    private fun userLongClickListener(user: UserModel?) {
        user?.let {}
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
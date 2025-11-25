package com.android.baseapp.ui.fragment.notifications

import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.baseapp.R
import com.android.baseapp.adapter.shimmer.ShimmerAdapter
import com.android.baseapp.adapter.user2.User2Adapter
import com.android.baseapp.core.BaseFragment
import com.android.baseapp.databinding.FragmentNotificationsBinding
import com.android.baseapp.model.UserModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NotificationsFragment : BaseFragment<FragmentNotificationsBinding, NotificationsViewModel>(
    NotificationsViewModel::class
) {

    private lateinit var userAdapter: User2Adapter

    //Layout
    override val getLayoutId: Int
        get() = R.layout.fragment_notifications

    //Lifecycles
    override fun initView() {
        showShimmer()
        setList()
        getData()
    }

    override fun initListeners() {
        super.initListeners()
        with(binding){

        }
    }

    override fun initObservers() {
        super.initObservers()
    }

    private fun getData(){
        lifecycleScope.launch {
            viewModel.userFlow.collectLatest { pagingData ->
                userAdapter.submitData(pagingData)
            }
        }
    }

    //Functions
    private fun showShimmer(){
        binding.rvUsers.layoutManager = LinearLayoutManager(requireContext())
        binding.rvUsers.adapter = ShimmerAdapter()
    }

    private fun setList(){
        userAdapter = User2Adapter(
            ::userClickListener,
            ::userLongClickListener
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

}
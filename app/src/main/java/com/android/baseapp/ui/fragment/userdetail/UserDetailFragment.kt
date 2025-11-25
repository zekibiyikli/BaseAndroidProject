package com.android.baseapp.ui.fragment.userdetail

import com.android.baseapp.R
import com.android.baseapp.core.BaseFragment
import com.android.baseapp.databinding.FragmentUserDetailBinding
import com.android.baseapp.ui.activity.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailFragment : BaseFragment<FragmentUserDetailBinding, UserDetailViewModel>(
    UserDetailViewModel::class
) {

    //Layout
    override val getLayoutId: Int
        get() = R.layout.fragment_user_detail

    //Lifecycles
    override fun initView() {

    }

    override fun onResume() {
        super.onResume()
        (requireActivity() as MainActivity).showHideBottomNavigation(false)
    }

    override fun initListeners() {
        super.initListeners()
    }

    override fun initObservers() {
        super.initObservers()
    }
}
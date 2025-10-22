package com.android.baseapp.ui.fragment.dashboard

import android.widget.TextView
import com.android.baseapp.R
import com.android.baseapp.core.BaseFragment
import com.android.baseapp.databinding.FragmentDashboardBinding

class DashboardFragment : BaseFragment<FragmentDashboardBinding, DashboardViewModel>(
    DashboardViewModel::class
) {

    //Layout
    override val getLayoutId: Int
        get() = R.layout.fragment_dashboard

    //Lifecycles
    override fun initView() {
        val textView: TextView = binding.textDashboard
        textView.text="DASHBOARD"
    }

    override fun initListeners() {
        super.initListeners()
        with(binding){

        }
    }

    override fun initObservers() {
        super.initObservers()
        with(viewModel){

        }
    }

}
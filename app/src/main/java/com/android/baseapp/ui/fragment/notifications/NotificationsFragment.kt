package com.android.baseapp.ui.fragment.notifications

import android.widget.TextView
import com.android.baseapp.R
import com.android.baseapp.core.BaseFragment
import com.android.baseapp.databinding.FragmentNotificationsBinding

class NotificationsFragment : BaseFragment<FragmentNotificationsBinding, NotificationsViewModel>(
    NotificationsViewModel::class
) {

    //Layout
    override val getLayoutId: Int
        get() = R.layout.fragment_notifications

    //Lifecycles
    override fun initView() {
        val textView: TextView = binding.textNotifications
        textView.text="NOTIFICATIONS"
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
package com.android.baseapp.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.android.baseapp.R
import com.android.baseapp.data.local.LocalSharedPreferences
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlin.reflect.KClass

//Bottom Sheet Dialog Fragment
open class BaseBSDialogFragment <VB : ViewDataBinding, BVM : BaseViewModel<BaseRepository>>(
    layoutId: Int,
    viewModelClass: KClass<BVM>
) : BottomSheetDialogFragment() {

    protected open val viewModel: BVM by lazy {
        ViewModelProvider(this)[viewModelClass.java]
    }
    open val binding: VB by lazy {
        DataBindingUtil.inflate(layoutInflater, layoutId, null, false)
    }
    val localData by lazy {
        LocalSharedPreferences.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.lifecycleOwner = viewLifecycleOwner
        initialize()
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.MATCH_PARENT
        )
    }

    open fun initialize() {}

    override fun getTheme(): Int {
        return R.style.FullScreenDialog
    }

    open fun show(fragmentManager: FragmentManager): Boolean {
        if (fragmentManager.isStateSaved) return false
        if (fragmentManager.findFragmentByTag(javaClass.simpleName) != null) return false
        show(fragmentManager, javaClass.simpleName)
        return true
    }

}
package com.android.baseapp.adapter.activity

import android.content.Context
import com.android.baseapp.core.BaseViewHolder
import com.android.baseapp.databinding.ItemActivityBinding
import com.android.baseapp.model.ActivityListModel

class ActivityViewHolder(private val binding: ItemActivityBinding) :
    BaseViewHolder<ActivityListModel>(binding.root) {
    override fun bind(
        model: ActivityListModel?,
        onItemClickListener: ((ActivityListModel?) -> Unit?)?,
        onItemLongClickListener: ((ActivityListModel?) -> Unit?)?,
        context: Context,
        position: Int
    ) {

        binding.root.setOnClickListener {

        }

    }
}
package com.android.baseapp.adapter.user

import android.content.Context
import com.android.baseapp.core.BaseViewHolder
import com.android.baseapp.databinding.ItemUserBinding
import com.android.baseapp.ext.loadImage
import com.android.baseapp.model.UserModel

class UserViewHolder(
    private val binding: ItemUserBinding
) : BaseViewHolder<UserModel>(binding.root) {
    override fun bind(
        model: UserModel?,
        onItemClickListener: ((UserModel?) -> Unit?)?,
        onItemLongClickListener: ((UserModel?) -> Unit?)?,
        context: Context,
        position: Int
    ) {

        model?.let {
            binding.imgUser.loadImage(context,it.picture.medium)
            binding.tvName.text="${it.name.first} ${it.name.last}"
            binding.tvCity.text=it.location.city
        }

        binding.root.setOnClickListener {
            onItemClickListener?.invoke(model)
        }

        binding.root.setOnLongClickListener {
            onItemLongClickListener?.invoke(model)
            true
        }
    }
}
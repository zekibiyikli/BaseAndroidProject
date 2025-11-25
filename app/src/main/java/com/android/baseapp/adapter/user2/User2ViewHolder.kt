package com.android.baseapp.adapter.user2

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.android.baseapp.databinding.ItemUserBinding
import com.android.baseapp.ext.loadImage
import com.android.baseapp.model.UserModel

class User2ViewHolder(
    private val binding: ItemUserBinding,
    private val onItemClick: ((UserModel?) -> Unit)? = null,
    private val onItemLongClick: ((UserModel?) -> Unit)? = null
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(model: UserModel?) {

        model?.let {
            val context: Context = binding.root.context

            binding.imgUser.loadImage(context, it.picture.medium)
            binding.tvName.text = "${it.name.first} ${it.name.last}"
            binding.tvCity.text = it.location.city
        }

        binding.root.setOnClickListener {
            onItemClick?.invoke(model)
        }

        binding.root.setOnLongClickListener {
            onItemLongClick?.invoke(model)
            true
        }
    }
}

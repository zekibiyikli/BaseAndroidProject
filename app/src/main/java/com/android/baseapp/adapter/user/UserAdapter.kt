package com.android.baseapp.adapter.user

import android.content.Context
import com.android.baseapp.R
import com.android.baseapp.core.BaseAdapter
import com.android.baseapp.databinding.ItemUserBinding
import com.android.baseapp.model.UserModel

class UserAdapter(
    private var itemList: MutableList<UserModel>,
    onItemClickListener: ((model: UserModel?) -> Unit)? = null,
    onItemLongClickListener: ((model: UserModel?) -> Unit)? = null,
    context: Context
) : BaseAdapter<UserModel, ItemUserBinding, UserViewHolder>(
    R.layout.item_user,
    ItemUserBinding::class,
    UserViewHolder::class,
    itemList,
    onItemClickListener,
    onItemLongClickListener,
    context
) {
    fun setData(items: List<UserModel>) {
        itemList = items.toMutableList()
        notifyItemChanged(itemList.size - 1)
    }

    fun addData(list: List<UserModel>) {
        val oldSize = itemList.size
        itemList.addAll(list)
        val newSize = itemList.size
        notifyItemRangeChanged(oldSize, newSize)
    }

    fun removeData(item: UserModel) {
        itemList.remove(item)
        notifyDataSetChanged()
    }

    fun getData(): MutableList<UserModel> {
        return itemList
    }

    fun removeAll(){
        itemList.clear()
        notifyDataSetChanged()
    }

}
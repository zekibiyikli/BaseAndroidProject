package com.android.baseapp.adapter.user3

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import com.android.baseapp.R
import com.android.baseapp.adapter.user.UserViewHolder
import com.android.baseapp.core.BaseAdapter
import com.android.baseapp.databinding.ItemUserBinding
import com.android.baseapp.model.UserModel
import com.android.baseapp.util.UserDiffCallback

class User3Adapter(
    private var itemList: MutableList<UserModel>,
    onItemClickListener: ((model: UserModel?) -> Unit)? = null,
    onItemLongClickListener: ((model: UserModel?) -> Unit)? = null,
    context: Context
) : BaseAdapter<UserModel, ItemUserBinding, User3ViewHolder>(
    R.layout.item_user,
    ItemUserBinding::class,
    User3ViewHolder::class,
    itemList,
    onItemClickListener,
    onItemLongClickListener,
    context
) {
    fun setData(items: List<UserModel>) {
        val diffCallback = UserDiffCallback(itemList, items)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        itemList.clear()
        itemList.addAll(items)
        diffResult.dispatchUpdatesTo(this)
    }

    fun addData(list: List<UserModel>) {
        val newList = ArrayList(itemList)
        newList.addAll(list)

        val diffCallback = UserDiffCallback(itemList, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        itemList.clear()
        itemList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
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
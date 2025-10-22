package com.android.baseapp.adapter.activity

import android.content.Context
import com.android.baseapp.core.BaseAdapter
import com.android.baseapp.databinding.ItemActivityBinding
import com.android.baseapp.model.ActivityListModel

class ActivityAdapter(
    private var itemList: MutableList<ActivityListModel>,
    onItemClickListener: ((model: ActivityListModel?) -> Unit)? = null,
    onItemLongClickListener: ((model: ActivityListModel?) -> Unit)? = null,

    context: Context
) : BaseAdapter<ActivityListModel, ItemActivityBinding, ActivityViewHolder>(
    ItemActivityBinding::class,
    ActivityViewHolder::class,
    itemList,
    onItemClickListener,
    onItemLongClickListener,
    context
) {
    fun setData(items: List<ActivityListModel>) {
        itemList = items.toMutableList()
        notifyItemChanged(itemList.size - 1)
    }

    fun addData(list: List<ActivityListModel>) {
        val oldSize = itemList.size
        itemList.addAll(list)
        val newSize = itemList.size
        notifyItemRangeChanged(oldSize, newSize)
    }

    fun removeData(item: ActivityListModel) {
        itemList.remove(item)
        notifyDataSetChanged()
    }

    fun getData(): MutableList<ActivityListModel> {
        return itemList
    }

    fun removeAll(){
        itemList.clear()
        notifyDataSetChanged()
    }

}
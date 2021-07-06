package com.promoclicks.task.ui.home.adapters.vendors

import androidx.recyclerview.widget.DiffUtil
import com.promoclicks.data.response.Vendor


object VendorsAdapterDC : DiffUtil.ItemCallback<Vendor>() {
    override fun areItemsTheSame(
        oldItem: Vendor,
        newItem: Vendor
    ): Boolean = oldItem.id == newItem.id


    override fun areContentsTheSame(
        oldItem: Vendor,
        newItem: Vendor
    ): Boolean = oldItem == newItem

}
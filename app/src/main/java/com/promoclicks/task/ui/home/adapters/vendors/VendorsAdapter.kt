package com.promoclicks.task.ui.home.adapters.vendors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.promoclicks.data.response.Vendor
import com.promoclicks.task.databinding.VendorsItemHomeBinding


class VendorsAdapter : ListAdapter<Vendor, VendorsAdapterViewHolder>(VendorsAdapterDC) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VendorsAdapterViewHolder = VendorsAdapterViewHolder(

        binding = VendorsItemHomeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),

        )


    override fun onBindViewHolder(holder: VendorsAdapterViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)

    }


}
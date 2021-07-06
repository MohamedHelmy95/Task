package com.promoclicks.task.ui.home.adapters.sponsors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.promoclicks.data.response.Sponsor
import com.promoclicks.task.databinding.SponserItemHomeBinding


class SponsorsAdapter : ListAdapter<Sponsor, SponsorsAdapterViewHolder>(SponsorsAdapterDC) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SponsorsAdapterViewHolder = SponsorsAdapterViewHolder(

        binding = SponserItemHomeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )


    override fun onBindViewHolder(holder: SponsorsAdapterViewHolder, position: Int) {
        holder.bind(item = getItem(position))
    }


}
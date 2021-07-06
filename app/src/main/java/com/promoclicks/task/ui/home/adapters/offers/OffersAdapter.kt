package com.promoclicks.task.ui.home.adapters.offers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.promoclicks.data.response.Slider
import com.promoclicks.task.databinding.OfferItemHomeBinding


class OffersAdapter(private val clickListener: OffersPageListener) :
    ListAdapter<Slider, OffersAdapterViewHolder>(OfferAdapterDC) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffersAdapterViewHolder =
        OffersAdapterViewHolder(
            binding = OfferItemHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            clickListener = clickListener
        )

    override fun onBindViewHolder(holder: OffersAdapterViewHolder, position: Int) {
        holder.bind(item = getItem(position))
    }


}
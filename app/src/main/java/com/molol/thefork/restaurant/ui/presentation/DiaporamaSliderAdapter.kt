package com.molol.thefork.restaurant.ui.presentation

import android.content.Context
import android.widget.TextView
import com.smarteist.autoimageslider.SliderViewAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.molol.thefork.restaurant.R


class DiaporamaSliderAdapter(private val context: Context, val pics:List<String> ) :
    SliderViewAdapter<DiaporamaSliderAdapter.SliderAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate =
            LayoutInflater.from(parent.context).inflate(R.layout.image_slider_layout_item, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        //viewHolder.textViewDescription.text = "This is slider item $position"

        Glide.with(viewHolder.itemView)
                .load( pics[position])
                .into(viewHolder.imageViewBackground)
    }

    override fun getCount(): Int {
        //slider view count could be dynamic size
        return pics.size
    }

    class SliderAdapterVH(var itemView: View) :
        SliderViewAdapter.ViewHolder(itemView) {
        var imageViewBackground: ImageView
        var textViewDescription: TextView

        init {
            imageViewBackground = itemView.findViewById(R.id.iv_auto_image_slider)
            textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider)
        }
    }
}
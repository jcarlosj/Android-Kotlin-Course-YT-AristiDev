package com.github.jcarlosj.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.github.jcarlosj.databinding.LayoutItemDogBinding
import com.squareup.picasso.Picasso

class DogViewHolder( view: View ) : RecyclerView.ViewHolder( view ) {

    private val binding = LayoutItemDogBinding.bind( view )

    fun bind( urlImage: String ) {
        Picasso.get().load( urlImage ).into( binding.ivDog )
    }
}
package com.github.jcarlosj.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.jcarlosj.R

class DogAdapter( private val items:List<String> ) : RecyclerView.Adapter<DogViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        return DogViewHolder(
            LayoutInflater.from( parent.context )
            .inflate(
                R.layout.layout_item_dog,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        val item = items[ position ]

        holder.bind( item )
    }

    override fun getItemCount(): Int = items.size

}
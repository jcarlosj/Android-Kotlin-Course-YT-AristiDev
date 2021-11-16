package com.github.jcarlosj

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class HeroAdapter(private val superheroes: List<SuperHero>) : RecyclerView.Adapter<HeroAdapter.ViewHolder>() {

    /**
     * Proporcione una referencia al tipo de vistas que está utilizando (ViewHolder personalizado).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {      // Recibe cada item
        val ivHero: ImageView
        val tvRealName: TextView
        val tvSuperHeroName: TextView
        val tvPublisher: TextView

        init {
            // Defina el listener de clics para la vista de ViewHolder.
            ivHero = view.findViewById( R.id.ivHero )
            tvRealName = view.findViewById( R.id.tvRealName )
            tvSuperHeroName = view.findViewById( R.id.tvSuperHeroName )
            tvPublisher = view.findViewById( R.id.tvPublisher )
        }
    }

    // Crear nuevas vistas (invocadas por el administrador de diseño)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Crea una nueva vista, que define la interfaz de usuario del elemento de la lista.
        val view = LayoutInflater
                    .from( viewGroup.context )
                    .inflate( R.layout.item_superhero, viewGroup, false)

        return ViewHolder(view)
    }

    // Reemplazar el contenido de una vista (invocada por el administrador de diseño)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Obtenga el elemento de sus superhéroes en esta posición y reemplace el contenido de la vista con ese elemento
        val ItemsViewModel = superheroes[position]

        viewHolder.tvRealName.text = ItemsViewModel.realName
        viewHolder.tvSuperHeroName.text = ItemsViewModel.superHeroName
        viewHolder.tvPublisher.text = ItemsViewModel.publisher

        Log.d( "HeroAdapter", ItemsViewModel.urlImage )

        Picasso.get().load( ItemsViewModel.urlImage ).into( viewHolder.ivHero )
    }

    // Devuelve el tamaño de tus superhéroes (invocado por el administrador de diseño)
    override fun getItemCount() = superheroes.size

}
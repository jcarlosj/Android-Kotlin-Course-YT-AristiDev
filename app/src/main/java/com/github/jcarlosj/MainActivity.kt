package com.github.jcarlosj

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.jcarlosj.adapters.DogAdapter
import com.github.jcarlosj.databinding.ActivityMainBinding
import com.github.jcarlosj.models.Dog
import com.github.jcarlosj.services.APIService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DogAdapter
    private val listImages = mutableListOf<String>()                        //  Define una lista mutable vacia

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate( layoutInflater )
        setContentView( binding.root )

        binding.svData.setOnQueryTextListener( this )                       //  Agrega un Listener al SearchView
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = DogAdapter( listImages )                                  // Asigna la lista mutable vacia al adapter
        binding.rvData.layoutManager = LinearLayoutManager( this )  //  Crea el LayoutManager para el RecyclerView
        binding.rvData.adapter = adapter                                    // Asigna el Adapter al RecyclerView
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl( "https://dog.ceo/api/breed/")          // Agrega URL del API. Siempre dejar un backslash (/) al final
                .addConverterFactory( GsonConverterFactory.create() )   // Convierte el JSON obtenido a un Objeto
                .build()

    }

    // Hace la busqueda por raza
    private fun searchByBreed( term: String ) {
        // Llamada asincrona en hilo secundario usando una coroutine
        CoroutineScope( Dispatchers.IO ) .launch {
            val response: Response<Dog> = getRetrofit() .create( APIService::class.java ) .getDogsByBreed( "$term/images" )
            var data: Dog? = response.body()

            // LLamada de ejecucion sobre el hilo principal
            runOnUiThread {
                if( response.isSuccessful ) {
                    val images: List<String> = data?.urlImages ?: emptyList()      //  Obtiene la data del Response, si se establecer como null entonces pasa una lista vacia

                    Log.d( "images", images.size.toString() )

                    listImages.clear()                                              //  Elimina todos los items de la lista mutable
                    listImages.addAll( images )                                     //  Agrega la data obtenida del Response
                    adapter.notifyDataSetChanged()                                  //  Indica al adapter que hubo cambios en la lista mutable que se le paso al principio
                }
                else { showError() }
            }
        }
    }

    private fun showError() {
        Toast.makeText( this, "Ha ocurrido un error", Toast.LENGTH_SHORT ).show()
    }

    /** Members: SearchView.OnQueryTextListener */
    // Submit: Realiza la busqueda del termino en el SearchView
    override fun onQueryTextSubmit( query: String? ): Boolean {
        // Si lo que hay en el SearchView no es vacio ni nulo
        if( !query .isNullOrEmpty() ) {
            searchByBreed( query.lowercase() )
        }

        return true
    }
    // Obtiene los cambios al agregar algo al SearchView
    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }
}
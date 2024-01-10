package com.example.android_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_project.Models.Categorias
import com.example.android_project.Models.Peliculas
import com.example.android_project.Models.PeliculasStore
import com.example.android_project.Models.RestriccionEdad
import com.example.android_project.databinding.ActivityBuscadorBinding

class BuscadorView : AppCompatActivity() {
    private lateinit var binding: ActivityBuscadorBinding
    // Para la RecyclerView
    private lateinit var peliculasAdapter: ListPeliculasAdapter

    // Variables para las pelis
    private val pelisBuscador: MutableList<Peliculas> = mutableListOf()
    private lateinit var listPeliculasBuscadorAdapter: ListPeliculasBuscadorAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscador)

        binding = ActivityBuscadorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Para hacer el fetch de las pelis
        peliculasAdapter = ListPeliculasAdapter(PeliculasStore.todasPelis, this)


        /**
         * Obtemos los parametros pasados en caso de tener
         */
        val extras = intent.extras
        val estaRegistrado = extras?.getBoolean("estaRegistrado")
        val nombreUsuario = extras?.getString("nombreUsuario").toString()
        val categoriasPreferidas = extras?.getString("categoriasPreferidas").toString()
        val edadSeleccionada = extras?.getString("edadSeleccionada").toString()

        // Para los filtros
        val filtersFragment = FiltersFragment()
        val btn_filters = findViewById<ImageButton>(R.id.showFilters)

        btn_filters.setOnClickListener {
            filtersFragment.show(supportFragmentManager, "Fragment to show")
        }

        /**
         * PARA MOSTRAR LAS PELIS
         */

        /**
         * TERROR
         */
        listPeliculasBuscadorAdapter = ListPeliculasBuscadorAdapter(pelisBuscador, applicationContext)
        listPeliculasBuscadorAdapter.generarPelisBuscador()

        val rvPelisBuscador = binding.rvPelisBuscador
        rvPelisBuscador.adapter = listPeliculasBuscadorAdapter
        rvPelisBuscador.layoutManager = LinearLayoutManager(this)

        /**
         * MENU
         */
        val lyPreferencias = binding.lyPreferencias
        val lyBuscador = binding.lyBuscador

        lyPreferencias.setOnClickListener {
            val intent = Intent(this, PreferenciasView::class.java)

            if (estaRegistrado == true) {
                intent.putExtra("estaRegistrado", estaRegistrado)
                intent.putExtra("nombreUsuario", nombreUsuario)
                intent.putExtra("categoriasPreferidas", categoriasPreferidas)
                intent.putExtra("edadSeleccionada", edadSeleccionada)
            }

            startActivity(intent)
        }

        lyBuscador.setOnClickListener {
            val intent = Intent(this, BuscadorView::class.java)
            startActivity(intent)
        }

        fun buscarFiltrado (peliBuscada: String, categorias: ArrayList<Categorias>, restricionEdad: RestriccionEdad) {

        }
    }
}
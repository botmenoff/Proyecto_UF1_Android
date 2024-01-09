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
    private val pRecientes: MutableList<Peliculas> = mutableListOf()
    private val pAccion: MutableList<Peliculas> = mutableListOf()
    private val pComedia: MutableList<Peliculas> = mutableListOf()
    private val pDrama: MutableList<Peliculas> = mutableListOf()
    private val pCienciaFiccion: MutableList<Peliculas> = mutableListOf()
    private val pAnimacion: MutableList<Peliculas> = mutableListOf()
    private val pTerror: MutableList<Peliculas> = mutableListOf()

    private lateinit var listPeliculasRecientesAdapter: ListPeliculasAdapter
    private lateinit var listPeliculasAccionAdapter: ListPeliculasAdapter
    private lateinit var listPeliculasComediaAdapter: ListPeliculasAdapter
    private lateinit var listPeliculasDramaAdapter: ListPeliculasAdapter
    private lateinit var listPeliculasCienciaFiccionAdapter: ListPeliculasAdapter
    private lateinit var listPeliculasAnimacionAdapter: ListPeliculasAdapter
    private lateinit var listPeliculasTerrorAdapter: ListPeliculasAdapter
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
         * Pelis nuevas
         */
        listPeliculasRecientesAdapter = ListPeliculasAdapter(pRecientes, applicationContext)
        listPeliculasRecientesAdapter.generarPelisRecientes()

        val pelisRecientesLayout = binding.rvPeliculasRecientes
        pelisRecientesLayout.adapter = listPeliculasRecientesAdapter
        pelisRecientesLayout.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        /**
         * Acción
         */
        listPeliculasAccionAdapter = ListPeliculasAdapter(pAccion, applicationContext)
        listPeliculasAccionAdapter.generarPelisAccion()

        val pelisAccionLayout = binding.rvPeliculasAccion
        pelisAccionLayout.adapter = listPeliculasAccionAdapter
        pelisAccionLayout.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        /**
         * COMEDIA
         */
        listPeliculasComediaAdapter = ListPeliculasAdapter(pComedia, applicationContext)
        listPeliculasComediaAdapter.generarPelisComedia()

        val pelisComediaLayout = binding.rvPeliculasComedia
        pelisComediaLayout.adapter = listPeliculasComediaAdapter
        pelisComediaLayout.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        /**
         * DRAMA
         */
        listPeliculasDramaAdapter = ListPeliculasAdapter(pDrama, applicationContext)
        listPeliculasDramaAdapter.generarPelisDrama()

        val pelisDramaLayout = binding.rvPeliculasDrama
        pelisDramaLayout.adapter = listPeliculasDramaAdapter
        pelisDramaLayout.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        /**
         * Ciencia Ficcion
         */
        listPeliculasCienciaFiccionAdapter = ListPeliculasAdapter(pCienciaFiccion, applicationContext)
        listPeliculasCienciaFiccionAdapter.generarPelisCienciaFiccion()

        val pelisCienciaFiccionLayout = binding.rvPeliculasCienciaFiccion
        pelisCienciaFiccionLayout.adapter = listPeliculasCienciaFiccionAdapter
        pelisCienciaFiccionLayout.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        /**
         * ANIMACIÓN
         */
        listPeliculasAnimacionAdapter = ListPeliculasAdapter(pAnimacion, applicationContext)
        listPeliculasAnimacionAdapter.generarPelisAnimacion()

        val pelisAnimacionLayout = binding.rvPeliculasAnimacion
        pelisAnimacionLayout.adapter = listPeliculasAnimacionAdapter
        pelisAnimacionLayout.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        /**
         * TERROR
         */
        listPeliculasTerrorAdapter = ListPeliculasAdapter(pTerror, applicationContext)
        listPeliculasTerrorAdapter.generarPelisTerror()

        val pelisTerrorLayout = binding.rvPeliculasTerror
        pelisTerrorLayout.adapter = listPeliculasTerrorAdapter
        pelisTerrorLayout.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)


        /**
         * MENU
         */
        var lyPreferencias = binding.lyPreferencias
        var lyHome = binding.lyHome

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

        lyHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        /**
         * FUNCION DE BUSCADOR CON LOS FILTROS
         */

        fun buscarFiltrado (peliBuscada: String, categorias: ArrayList<Categorias>, restricionEdad: RestriccionEdad) {

        }
    }
}
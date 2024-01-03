package com.example.android_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_project.Models.Peliculas
import com.example.android_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val peliculas: MutableList<Peliculas> = mutableListOf()
    private lateinit var listPeliculasRecientesAdapter: ListPeliculasHomeAdapter
    private lateinit var listPeliculasAccionAdapter: ListPeliculasHomeAdapter
    private lateinit var listPeliculasComediaAdapter: ListPeliculasHomeAdapter
    private lateinit var listPeliculasDramaAdapter: ListPeliculasHomeAdapter
    private lateinit var listPeliculasCienciaFiccionAdapter: ListPeliculasHomeAdapter
    private lateinit var listPeliculasAnimacionAdapter: ListPeliculasHomeAdapter
    private lateinit var listPeliculasTerrorAdapter: ListPeliculasHomeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * Pelis nuevas
         */
        listPeliculasRecientesAdapter = ListPeliculasHomeAdapter(peliculas,"nueva", applicationContext)
        listPeliculasRecientesAdapter.generateDefaultPelis()
        val pelisRecientesLayout = binding.rvPeliculasRecientes
        pelisRecientesLayout.adapter = listPeliculasRecientesAdapter
        pelisRecientesLayout.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        /**
         * Acción
         */
        listPeliculasAccionAdapter = ListPeliculasHomeAdapter(peliculas,"Acción", applicationContext)
        listPeliculasAccionAdapter.generateDefaultPelis()
        val pelisAccionLayout = binding.rvPeliculasAccion
        pelisAccionLayout.adapter = listPeliculasAccionAdapter
        pelisAccionLayout.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        /**
         * COMEDIA
         */
        listPeliculasComediaAdapter = ListPeliculasHomeAdapter(peliculas,"Comedia", applicationContext)
        listPeliculasComediaAdapter.generateDefaultPelis()
        val pelisComediaLayout = binding.rvPeliculasComedia
        pelisComediaLayout.adapter = listPeliculasComediaAdapter
        pelisComediaLayout.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        /**
         * DRAMA
         */
        listPeliculasDramaAdapter = ListPeliculasHomeAdapter(peliculas,"Drama", applicationContext)
        listPeliculasDramaAdapter.generateDefaultPelis()
        val pelisDramaLayout = binding.rvPeliculasDrama
        pelisDramaLayout.adapter = listPeliculasDramaAdapter
        pelisDramaLayout.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        /**
         * Ciencia Ficcion
         */
        listPeliculasCienciaFiccionAdapter = ListPeliculasHomeAdapter(peliculas,"Ciencia Ficción", applicationContext)
        listPeliculasCienciaFiccionAdapter.generateDefaultPelis()
        val pelisCienciaFiccionLayout = binding.rvPeliculasCienciaFiccion
        pelisCienciaFiccionLayout.adapter = listPeliculasCienciaFiccionAdapter
        pelisCienciaFiccionLayout.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        /**
         * ANIMACIÓN
         */
        listPeliculasAnimacionAdapter = ListPeliculasHomeAdapter(peliculas,"Animación", applicationContext)
        listPeliculasAnimacionAdapter.generateDefaultPelis()
        val pelisAnimacionLayout = binding.rvPeliculasAnimacion
        pelisAnimacionLayout.adapter = listPeliculasAnimacionAdapter
        pelisAnimacionLayout.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        /**
         * TERROR
         */
        listPeliculasTerrorAdapter = ListPeliculasHomeAdapter(peliculas,"Terror", applicationContext)
        listPeliculasTerrorAdapter.generateDefaultPelis()
        val pelisTerrorLayout = binding.rvPeliculasTerror
        pelisTerrorLayout.adapter = listPeliculasTerrorAdapter
        pelisTerrorLayout.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    }
}
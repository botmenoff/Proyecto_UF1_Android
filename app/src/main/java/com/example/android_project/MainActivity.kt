package com.example.android_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_project.Models.Peliculas
import com.example.android_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val peliculas: MutableList<Peliculas> = mutableListOf()
    private lateinit var listPeliculasHomeAdapter: ListPeliculasHomeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * Pelis nuevas
         */
        listPeliculasHomeAdapter = ListPeliculasHomeAdapter(peliculas,"nueva", applicationContext)
        listPeliculasHomeAdapter.generateDefaultPelis()
        val pelisRecientesLayout = binding.rvPeliculasRecientes
        pelisRecientesLayout.adapter = listPeliculasHomeAdapter
        pelisRecientesLayout.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        /**
         * Acción
         */
        listPeliculasHomeAdapter = ListPeliculasHomeAdapter(peliculas,"Acción", applicationContext)
        val pelisAccionLayout = binding.rvPeliculasAccion
        pelisAccionLayout.adapter = listPeliculasHomeAdapter
        pelisAccionLayout.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        /**
         * Ciencia Ficcion
         */
        listPeliculasHomeAdapter = ListPeliculasHomeAdapter(peliculas,"Ciencia Ficción", applicationContext)
        val pelisCienciaFiccionLayout = binding.rvPeliculasCienciaFiccion
        pelisCienciaFiccionLayout.adapter = listPeliculasHomeAdapter
        pelisCienciaFiccionLayout.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }
}
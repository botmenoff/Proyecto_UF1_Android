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
         * Creamos una instancia de la clase ListPeliculasHomeAdapter
         */
        listPeliculasHomeAdapter = ListPeliculasHomeAdapter(peliculas, applicationContext)
        listPeliculasHomeAdapter.generateDefaultPelis()

        val rvList = binding.rvList
        rvList.adapter = listPeliculasHomeAdapter
        rvList.layoutManager = LinearLayoutManager(this)

    }
}
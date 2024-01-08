package com.example.android_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_project.Models.Peliculas
import com.example.android_project.databinding.ActivityMainBinding

import android.widget.TextView
import com.example.android_project.ApiCalls.ApiCalls

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

        val pelisRecientesLayout = binding.rvPeliculasRecientes
        pelisRecientesLayout.adapter = listPeliculasHomeAdapter
        pelisRecientesLayout.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Instanciar ApiCalls
        val apiCalls = ApiCalls()

        // URL
        val apiUrl = "https://api.themoviedb.org/3/discover/movie?include_adult=false&include_video=false&language=es-ES&page=1&sort_by=popularity.desc"

        // Referenciar el TextView en tu layout
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        // Llamar a la funcion de la llamada de la api y gestionar la respuesta
        apiCalls.fetchDataFromApi(apiUrl) { responseData ->
            runOnUiThread {
                // Actualizar el TextView con la respuesta o el mensaje de error
                resultTextView.text = if (responseData.isNotEmpty()) {
                    "Response from the API: $responseData"
                } else {
                    "Error calling the API"
                }
            }
        }
    }
}

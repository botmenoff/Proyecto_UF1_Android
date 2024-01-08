package com.example.android_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.google.android.material.textfield.TextInputEditText

class Buscador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscador)

        // Para los filtros
        val bottomSheetFragment = BottomSheetFragment()
        val btn_filters = findViewById<ImageButton>(R.id.showFilters)

        btn_filters.setOnClickListener {
            bottomSheetFragment.show(supportFragmentManager, "Fragment to show")
        }

        // Buscador
        val searchBtn = findViewById<ImageButton>(R.id.searchButton)
        val searchInput = findViewById<TextInputEditText>(R.id.searchInput)
        searchBtn.setOnClickListener {
            // Make the API call

            // Toast para mostrar lo que ha escrito el usuario
            Toast.makeText(this, "Texto buscado: " + searchInput.text.toString(), Toast.LENGTH_SHORT).show()
            // Eliminar el texto cuando se busca
            searchInput.text?.clear()
        }
    }
}
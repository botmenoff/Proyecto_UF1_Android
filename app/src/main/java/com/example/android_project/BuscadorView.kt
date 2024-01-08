package com.example.android_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import com.example.android_project.databinding.ActivityBuscadorBinding
import com.example.android_project.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText

class BuscadorView : AppCompatActivity() {
    private lateinit var binding: ActivityBuscadorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscador)

        binding = ActivityBuscadorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * Obtemos los parametros pasados en caso de tener
         */
        val extras = intent.extras
        val estaRegistrado = extras?.getBoolean("estaRegistrado")
        val nombreUsuario = extras?.getString("nombreUsuario").toString()
        val categoriasPreferidas = extras?.getString("categoriasPreferidas").toString()
        val edadSeleccionada = extras?.getString("edadSeleccionada").toString()

        // Para los filtros
        val filterFragment = FilterFragment()
        val btn_filters = findViewById<ImageButton>(R.id.showFilters)

        btn_filters.setOnClickListener {
            filterFragment.show(supportFragmentManager, "Fragment to show")
        }

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
    }
}
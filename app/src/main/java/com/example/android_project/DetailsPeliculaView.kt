package com.example.android_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.example.android_project.databinding.ActivityDetailsPeliculaViewBinding

class DetailsPeliculaView : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsPeliculaViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsPeliculaViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tvTitulo = binding.tvNombrePeli
        val ivImagen = binding.ivImagenPeli

        val extras = intent.extras
        tvTitulo.text = extras?.getString("titulo").toString()
        val urlImagen = extras?.getString("urlImagen").toString()
        val descripcion = extras?.getString("descripcion").toString()

        Glide.with(this)
            .load(urlImagen)
            .into(ivImagen)

        /**
         * Desplegar o contraer el acordeon
         */
        val tituloPeliOculto = binding.tvTituloPeliOculto
        tituloPeliOculto.text = descripcion;
        val ivExpandTitulo = binding.ivExpandTitulo

        ivExpandTitulo.setOnClickListener {
            if (tituloPeliOculto.visibility == View.VISIBLE) { // Si tenemos desplegado el acordeon lo contraemos
                tituloPeliOculto.visibility = View.GONE
                ivExpandTitulo.setImageResource(R.drawable.expand_more_24)
            } else {
                tituloPeliOculto.visibility = View.VISIBLE
                ivExpandTitulo.setImageResource(R.drawable.expand_less_24) // Cambiamos el icono de contraer
            }
        }
    }
}
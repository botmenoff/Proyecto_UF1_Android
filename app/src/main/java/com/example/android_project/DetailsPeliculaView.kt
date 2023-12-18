package com.example.android_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        Glide.with(this)
            .load(urlImagen)
            .into(ivImagen)
    }
}
package com.example.android_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import com.bumptech.glide.Glide
import com.example.android_project.Models.Actores
import com.example.android_project.databinding.ActivityDetailsPeliculaViewBinding

class DetailsPeliculaView : AppCompatActivity() {
    private lateinit var binding: ActivityDetailsPeliculaViewBinding

    // Para que que cuando le das a la flecha hacia atras no te vaya siempre a la MainActivity sino que vaya donde estabas previamente
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                // This is the back arrow button in the action bar
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsPeliculaViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Activar el backArrow
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvTitulo = binding.tvNombrePeli
        val ivImagen = binding.ivImagenPeli

        /**
         * Obtenemos los datos pasados de una pelicula
         */
        val extras = intent.extras
        tvTitulo.text = extras?.getString("titulo").toString()
        val urlImagen = extras?.getString("urlImagen").toString()
        val descripcion = extras?.getString("descripcion").toString()
        val repartoString = extras?.getString("reparto").toString()
        val categorias = extras?.getString("categorias").toString()
        val idiomas = extras?.getString("idiomas").toString()
        val edad = extras?.getString("edad").toString()


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

        /**
         * Acordeon REPARTO
         */
        val repartoPeliOculto = binding.tvRepartoPeliOculto
        repartoPeliOculto.text = repartoString
        val ivExpandReparto = binding.ivExpandReparto
        ivExpandReparto.setOnClickListener {
            if (repartoPeliOculto.visibility == View.VISIBLE) {
                repartoPeliOculto.visibility = View.GONE
                ivExpandReparto.setImageResource(R.drawable.expand_more_24)
            } else {
                repartoPeliOculto.visibility = View.VISIBLE
                ivExpandReparto.setImageResource(R.drawable.expand_less_24)
            }
        }

        /**
         * Acordeon CATEGORIAS
         */
        val categoriasPeliOculto = binding.tvCategoriaPeliOculto
        categoriasPeliOculto.text = categorias
        val ivExpandCategorias = binding.ivExpandCategoria
        ivExpandCategorias.setOnClickListener {
            if (categoriasPeliOculto.visibility == View.VISIBLE) {
                categoriasPeliOculto.visibility = View.GONE
                ivExpandCategorias.setImageResource(R.drawable.expand_more_24)
            } else {
                categoriasPeliOculto.visibility = View.VISIBLE
                ivExpandCategorias.setImageResource(R.drawable.expand_less_24)
            }
        }

        /**
         * Acordeon IDIOMAS
         */
        val idiomasPeliOculto = binding.tvIdiomaPeliOculto
        idiomasPeliOculto.text = idiomas
        val ivExpandIdiomas = binding.ivExpandIdioma
        ivExpandIdiomas.setOnClickListener {
            if (idiomasPeliOculto.visibility == View.VISIBLE) {
                idiomasPeliOculto.visibility = View.GONE
                ivExpandIdiomas.setImageResource(R.drawable.expand_more_24)
            } else {
                idiomasPeliOculto.visibility = View.VISIBLE
                ivExpandIdiomas.setImageResource(R.drawable.expand_less_24)
            }
        }

        /**
         * Acordeon EDAD
         */
        val edadPeliOculto = binding.tvEdadPeliOculto
        edadPeliOculto.text = edad
        val ivExpandEdad = binding.ivExpandEdad
        ivExpandEdad.setOnClickListener {
            if (edadPeliOculto.visibility == View.VISIBLE) {
                edadPeliOculto.visibility = View.GONE
                ivExpandEdad.setImageResource(R.drawable.expand_more_24)
            } else {
                edadPeliOculto.visibility = View.VISIBLE
                ivExpandEdad.setImageResource(R.drawable.expand_less_24)
            }
        }
    }
}
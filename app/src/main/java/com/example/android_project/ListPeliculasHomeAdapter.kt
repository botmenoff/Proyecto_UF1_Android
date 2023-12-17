package com.example.android_project

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_project.Models.Actores
import com.example.android_project.Models.Categorias
import com.example.android_project.Models.Idiomas
import com.example.android_project.Models.Peliculas
import com.example.android_project.Models.RestriccionEdad

class ListPeliculasHomeAdapter (val peliculas: MutableList<Peliculas>, val context: Context): RecyclerView.Adapter<ListPeliculasHomeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return peliculas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pelicula = peliculas[position]

        Glide.with(context)
            .load(pelicula.urlImagen)
            //.placeholder(R.drawable.placeholder) // Imagen de carga mientras se descarga
            //.error(R.drawable.error) // Imagen de error si falla la carga
            .into(holder.ivPelicula)

    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val ivPelicula = view.findViewById<ImageView>(R.id.ivPelicula)
    }

    fun generateDefaultPelis() {
        peliculas.add(
            Peliculas(
                "Peli 1", "Lorem Ipsum...",
                "https://play-lh.googleusercontent.com/SU1hRumo0t-zFebkVVlesNb6a1mHYPxxQJX-49jYayrMIrsmU135uxgcOglMcCB_kHfb=w240-h480-rw",
                false, mutableListOf(Idiomas.ESP, Idiomas.ITA), RestriccionEdad.TODO_PUBLICO, mutableListOf(Categorias.ACCION, Categorias.DRAMA),
                mutableListOf(Actores("Pablo", "Estudiante"), Actores("Ferran", "Estudiante"))))

        peliculas.add(
            Peliculas(
                "Peli 2", "Lorem Ipsum...",
                //"https://pics.filmaffinity.com/A_todo_gas-994796969-large.jpg",
                "https://play-lh.googleusercontent.com/SU1hRumo0t-zFebkVVlesNb6a1mHYPxxQJX-49jYayrMIrsmU135uxgcOglMcCB_kHfb=w240-h480-rw",
                false, mutableListOf(Idiomas.ESP, Idiomas.ITA), RestriccionEdad.TODO_PUBLICO, mutableListOf(Categorias.ACCION, Categorias.DRAMA),
                mutableListOf(Actores("Pablo", "Estudiante"), Actores("Ferran", "Estudiante"))))

        peliculas.add(
            Peliculas(
                "Peli 3", "Lorem Ipsum...",
                //"https://pics.filmaffinity.com/Piratas_del_Caribe_La_maldiciaon_de_la_Perla_Negra-627724446-large.jpg",
                "https://play-lh.googleusercontent.com/SU1hRumo0t-zFebkVVlesNb6a1mHYPxxQJX-49jYayrMIrsmU135uxgcOglMcCB_kHfb=w240-h480-rw",
                false, mutableListOf(Idiomas.ESP, Idiomas.ITA), RestriccionEdad.TODO_PUBLICO, mutableListOf(Categorias.ACCION, Categorias.DRAMA),
                mutableListOf(Actores("Pablo", "Estudiante"), Actores("Ferran", "Estudiante"))))
    }
}
package com.example.android_project

import android.content.Context
import android.content.Intent
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

class ListPeliculasAdapter (val peliculas: MutableList<Peliculas>, val context: Context): RecyclerView.Adapter<ListPeliculasAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return peliculas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pelicula = peliculas[position]

        mostrarPeli(pelicula, holder)
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val ivPelicula = view.findViewById<ImageView>(R.id.ivPelicula)
    }

    /**
     * Funcion que generar peliculas de Accion por defecto
     */
    fun generarPelisRecientes() {
        peliculas.add(
            Peliculas(
                "Inception",
                "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
                "https://play-lh.googleusercontent.com/SU1hRumo0t-zFebkVVlesNb6a1mHYPxxQJX-49jYayrMIrsmU135uxgcOglMcCB_kHfb=w240-h480-rw",
                mutableListOf(Idiomas.ESP, Idiomas.ITA),
                RestriccionEdad.MAYORES_DE_7,
                mutableListOf(Categorias.ESTRENO),
                mutableListOf(
                    Actores("Leonardo DiCaprio", "Actor"),
                    Actores("Joseph Gordon-Levitt", "Actor")
                )
            )
        )
    }

    fun generarPelisAccion() {
        peliculas.add(
            Peliculas(
                "Die Hard",
                "An NYPD officer tries to save his wife and several others taken hostage by German terrorists during a Christmas party at the Nakatomi Plaza in Los Angeles.",
                "https://play-lh.googleusercontent.com/SU1hRumo0t-zFebkVVlesNb6a1mHYPxxQJX-49jYayrMIrsmU135uxgcOglMcCB_kHfb=w240-h480-rw",
                mutableListOf(Idiomas.ESP, Idiomas.ITA),
                RestriccionEdad.MAYORES_DE_18,
                mutableListOf(Categorias.ACCION),
                mutableListOf(
                    Actores("Bruce Willis", "Actor"),
                    Actores("Alan Rickman", "Actor")
                )
            )
        )

        peliculas.add(
            Peliculas(
                "Mad Max: Fury Road",
                "In a post-apocalyptic wasteland, a woman rebels against a tyrannical ruler in search of her homeland with the help of a group of female prisoners, a psychotic worshiper, and a drifter named Max.",
                "https://play-lh.googleusercontent.com/SU1hRumo0t-zFebkVVlesNb6a1mHYPxxQJX-49jYayrMIrsmU135uxgcOglMcCB_kHfb=w240-h480-rw",
                mutableListOf(Idiomas.ESP, Idiomas.ITA),
                RestriccionEdad.MAYORES_DE_13,
                mutableListOf(Categorias.ACCION),
                mutableListOf(
                    Actores("Tom Hardy", "Actor"),
                    Actores("Charlize Theron", "Actress")
                )
            )
        )
    }
    fun generarPelisDrama() {
        peliculas.add(
            Peliculas(
                "Peli Drama 1",
                "Una historia emocionalmente impactante sobre...",
                "https://play-lh.googleusercontent.com/SU1hRumo0t-zFebkVVlesNb6a1mHYPxxQJX-49jYayrMIrsmU135uxgcOglMcCB_kHfb=w240-h480-rw",
                mutableListOf(Idiomas.ESP, Idiomas.ITA),
                RestriccionEdad.MAYORES_DE_13,
                mutableListOf(Categorias.DRAMA),
                mutableListOf(
                    Actores("Actor1", "Principal"),
                    Actores("Actriz2", "Principal")
                )
            )
        )
    }
    fun generarPelisComedia() {
        peliculas.add(
            Peliculas(
                "Peli Comedia 1",
                "Una comedia hilarante que sigue las desventuras de...",
                "https://play-lh.googleusercontent.com/SU1hRumo0t-zFebkVVlesNb6a1mHYPxxQJX-49jYayrMIrsmU135uxgcOglMcCB_kHfb=w240-h480-rw",
                mutableListOf(Idiomas.ESP, Idiomas.ITA),
                RestriccionEdad.MAYORES_DE_18,
                mutableListOf(Categorias.COMEDIA),
                mutableListOf(
                    Actores("Actriz3", "Principal"),
                    Actores("Actor4", "Principal")
                )
            )
        )

        peliculas.add(
            Peliculas(
                "Peli Comedia 2",
                "Una divertida comedia romántica que sigue a...",
                "https://play-lh.googleusercontent.com/SU1hRumo0t-zFebkVVlesNb6a1mHYPxxQJX-49jYayrMIrsmU135uxgcOglMcCB_kHfb=w240-h480-rw",
                mutableListOf(Idiomas.ESP, Idiomas.ITA),
                RestriccionEdad.MAYORES_DE_13,
                mutableListOf(Categorias.COMEDIA),
                mutableListOf(
                    Actores("Actor5", "Principal"),
                    Actores("Actriz6", "Principal")
                )
            )
        )
    }
    fun generarPelisCienciaFiccion() {
        peliculas.add(
            Peliculas(
                "Peli Ciencia Ficción 1",
                "Una emocionante aventura de ciencia ficción que se desarrolla en...",
                "https://play-lh.googleusercontent.com/SU1hRumo0t-zFebkVVlesNb6a1mHYPxxQJX-49jYayrMIrsmU135uxgcOglMcCB_kHfb=w240-h480-rw",
                mutableListOf(Idiomas.ESP, Idiomas.ITA),
                RestriccionEdad.MAYORES_DE_13,
                mutableListOf(Categorias.CIENCIA_FICCION),
                mutableListOf(
                    Actores("Actor7", "Principal"),
                    Actores("Actriz8", "Principal")
                )
            )
        )
    }
    fun generarPelisAnimacion() {
        peliculas.add(
            Peliculas(
                "Peli Animación 1",
                "Una encantadora película animada que sigue las peripecias de...",
                "https://play-lh.googleusercontent.com/SU1hRumo0t-zFebkVVlesNb6a1mHYPxxQJX-49jYayrMIrsmU135uxgcOglMcCB_kHfb=w240-h480-rw",
                mutableListOf(Idiomas.ESP, Idiomas.ITA),
                RestriccionEdad.TODO_PUBLICO,
                mutableListOf(Categorias.ANIMACION),
                mutableListOf(
                    Actores("Personaje Animado1", "Principal"),
                    Actores("Personaje Animado2", "Principal")
                )
            )
        )
    }
    fun generarPelisTerror() {
        peliculas.add(
            Peliculas(
                "Peli Terror 1",
                "Un thriller de terror psicológico que sigue a...",
                "https://play-lh.googleusercontent.com/SU1hRumo0t-zFebkVVlesNb6a1mHYPxxQJX-49jYayrMIrsmU135uxgcOglMcCB_kHfb=w240-h480-rw",
                mutableListOf(Idiomas.ESP, Idiomas.ITA),
                RestriccionEdad.MAYORES_DE_18,
                mutableListOf(Categorias.TERROR),
                mutableListOf(
                    Actores("Actor9", "Principal"),
                    Actores("Actriz10", "Principal")
                )
            )
        )

        peliculas.add(
            Peliculas(
                "Peli Terror 2",
                "Una historia aterradora que sigue los eventos paranormales en...",
                "https://play-lh.googleusercontent.com/SU1hRumo0t-zFebkVVlesNb6a1mHYPxxQJX-49jYayrMIrsmU135uxgcOglMcCB_kHfb=w240-h480-rw",
                mutableListOf(Idiomas.ESP, Idiomas.ITA),
                RestriccionEdad.MAYORES_DE_13,
                mutableListOf(Categorias.TERROR),
                mutableListOf(
                    Actores("Actriz11", "Principal"),
                    Actores("Actor12", "Principal")
                )
            )
        )
    }

    /**
     * @param p: Objeto de tipo Peliculas
     * @param h: Objeto de tipo ViewHolder donde se montara la pelicula
     * Función que muestra la imagen de una pelicula y le añade un evento de tipo `click`
     */
    fun mostrarPeli(p: Peliculas, h: ViewHolder) {
        Glide.with(context)
            .load(p.urlImagen)
            //.placeholder(R.drawable.placeholder) // Imagen de carga mientras se descarga
            //.error(R.drawable.error) // Imagen de error si falla la carga
            .into(h.ivPelicula)

        h.itemView.setOnClickListener {
            val context = h.itemView.context
            val intent = Intent(context, DetailsPeliculaView::class.java)
            intent.putExtra("titulo", p.titulo)
            intent.putExtra("urlImagen", p.urlImagen)
            intent.putExtra("descripcion", p.descripcion)
            intent.putExtra("reparto", p.reparto.joinToString("\n"))
            intent.putExtra("categorias", p.categorias.joinToString("\n"))
            intent.putExtra("idiomas", p.idiomasDisponible.joinToString("\n"))
            intent.putExtra("edad", p.restriccionEdad.toString())

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }
}
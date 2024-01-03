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

class ListPeliculasHomeAdapter (val peliculas: MutableList<Peliculas>, var categoriaSeccion: String, val context: Context): RecyclerView.Adapter<ListPeliculasHomeAdapter.ViewHolder>() {

    private var posicionComedia = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return peliculas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pelicula = peliculas[position]

        // TODO filtrar aqui por las categorias
        if (categoriaSeccion == "nueva" && pelicula.esNueva) {
            mostrarPeli(pelicula, holder, position)
        } else if (categoriaSeccion == "Comedia") {
            mostrarPeli(pelicula, holder, posicionComedia)
            posicionComedia++
        }else {
            val categoriasPelicula = pelicula.categorias.joinToString(", ")
            if (categoriasPelicula.contains(categoriaSeccion)) {
                mostrarPeli(pelicula, holder, position)
            }
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val ivPelicula = view.findViewById<ImageView>(R.id.ivPelicula)
    }

    /**
     * Funcion que generar peliculas por defecto
     */
    fun generateDefaultPelis() {
        peliculas.add(
            Peliculas(
                "Peli 1", "Lorem Ipsum...",
                "https://play-lh.googleusercontent.com/SU1hRumo0t-zFebkVVlesNb6a1mHYPxxQJX-49jYayrMIrsmU135uxgcOglMcCB_kHfb=w240-h480-rw",
                true, mutableListOf(Idiomas.ESP, Idiomas.ITA), RestriccionEdad.TODO_PUBLICO, mutableListOf(Categorias.ACCION),
                mutableListOf(Actores("Pablo", "Estudiante"), Actores("Ferran", "Estudiante"))))

        peliculas.add(
            Peliculas(
                "Peli 2", "Lorem Ipsum...",
                "https://play-lh.googleusercontent.com/SU1hRumo0t-zFebkVVlesNb6a1mHYPxxQJX-49jYayrMIrsmU135uxgcOglMcCB_kHfb=w240-h480-rw",
                false, mutableListOf(Idiomas.ESP, Idiomas.ITA), RestriccionEdad.TODO_PUBLICO, mutableListOf(Categorias.COMEDIA),
                mutableListOf(Actores("Pablo", "Estudiante"), Actores("Ferran", "Estudiante"))))

        peliculas.add(
            Peliculas(
                "Peli 3", "Lorem Ipsum...",
                "https://play-lh.googleusercontent.com/SU1hRumo0t-zFebkVVlesNb6a1mHYPxxQJX-49jYayrMIrsmU135uxgcOglMcCB_kHfb=w240-h480-rw",
                false, mutableListOf(Idiomas.ESP, Idiomas.ITA), RestriccionEdad.TODO_PUBLICO, mutableListOf(Categorias.DRAMA),
                mutableListOf(Actores("Pablo", "Estudiante"), Actores("Ferran", "Estudiante"))))

        peliculas.add(
            Peliculas(
                "Peli 4", "Lorem Ipsum...",
                "https://play-lh.googleusercontent.com/SU1hRumo0t-zFebkVVlesNb6a1mHYPxxQJX-49jYayrMIrsmU135uxgcOglMcCB_kHfb=w240-h480-rw",
                false, mutableListOf(Idiomas.ESP, Idiomas.ITA), RestriccionEdad.TODO_PUBLICO, mutableListOf(Categorias.CIENCIA_FICCION),
                mutableListOf(Actores("Pablo", "Estudiante"), Actores("Ferran", "Estudiante"))))

        peliculas.add(
            Peliculas(
                "Peli 5", "Lorem Ipsum...",
                "https://play-lh.googleusercontent.com/SU1hRumo0t-zFebkVVlesNb6a1mHYPxxQJX-49jYayrMIrsmU135uxgcOglMcCB_kHfb=w240-h480-rw",
                false, mutableListOf(Idiomas.ESP, Idiomas.ITA), RestriccionEdad.TODO_PUBLICO, mutableListOf(Categorias.ANIMACION),
                mutableListOf(Actores("Pablo", "Estudiante"), Actores("Ferran", "Estudiante"))))

        peliculas.add(
            Peliculas(
                "Peli 6", "Lorem Ipsum...",
                "https://play-lh.googleusercontent.com/SU1hRumo0t-zFebkVVlesNb6a1mHYPxxQJX-49jYayrMIrsmU135uxgcOglMcCB_kHfb=w240-h480-rw",
                false, mutableListOf(Idiomas.ESP, Idiomas.ITA), RestriccionEdad.TODO_PUBLICO, mutableListOf(Categorias.TERROR),
                mutableListOf(Actores("Pablo", "Estudiante"), Actores("Ferran", "Estudiante"))))
    }

    /**
     * @param p: Objeto de tipo Peliculas
     * @param h: Objeto de tipo ViewHolder donde se montara la pelicula
     * Función que muestra la imagen de una pelicula y le añade un evento de tipo `click`
     */
    fun mostrarPeli(p: Peliculas, h: ViewHolder, posicion: Int) {
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

        h.adapterPosition = posicion
    }
}
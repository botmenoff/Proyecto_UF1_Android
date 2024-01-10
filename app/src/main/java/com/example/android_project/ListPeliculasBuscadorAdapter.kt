package com.example.android_project

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_project.Models.Peliculas
import com.example.android_project.Models.PeliculasStore

class ListPeliculasBuscadorAdapter (val peliculas: MutableList<Peliculas>, val context: Context): RecyclerView.Adapter<ListPeliculasBuscadorAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list_buscador, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return peliculas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pelicula = peliculas[position]
        holder.tvNombrePeliBuscador.text = pelicula.titulo.toString()

        mostrarPeli(pelicula, holder)
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val ivPelicula = view.findViewById<ImageView>(R.id.ivPeliculaBuscador)
        val tvNombrePeliBuscador = view.findViewById<TextView>(R.id.tv_nombre_peli_buscador)
    }
    fun generarPelisBuscador () {
        for (pelis in PeliculasStore.todasPelis) {
            peliculas.add(pelis)
        }
        Log.i("------>", peliculas.size.toString())
        Log.i("------>", PeliculasStore.todasPelis.size.toString())

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
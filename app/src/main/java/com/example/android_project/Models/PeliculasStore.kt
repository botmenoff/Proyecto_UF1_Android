package com.example.android_project.Models

object PeliculasStore {
    val todasPelis: MutableList<Peliculas> = mutableListOf()

    fun agregarPelicula(pelicula: Peliculas) {
        todasPelis.add(pelicula)
    }
}
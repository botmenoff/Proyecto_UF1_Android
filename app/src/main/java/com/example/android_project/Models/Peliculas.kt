package com.example.android_project.Models

class Peliculas(
    val titulo: String,
    val descripcion: String,
    val urlImagen: String,
    val idiomasDisponible: MutableList<Idiomas>,
    val restriccionEdad: RestriccionEdad,
    val categorias: MutableList<Categorias>,
    val reparto: MutableList<Actores>
)
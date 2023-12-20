package com.example.android_project.Models

enum class Categorias(val nombre: String) {
    ACCION("Acción"),
    COMEDIA("Comedia"),
    DRAMA("Drama"),
    CIENCIA_FICCION("Ciencia Ficción"),
    ANIMACION("Animación"),
    TERROR("Terror");

    override fun toString(): String {
        return "$nombre\n"
    }
}
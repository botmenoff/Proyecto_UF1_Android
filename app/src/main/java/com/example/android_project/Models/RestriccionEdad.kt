package com.example.android_project.Models

enum class RestriccionEdad(val nombre: String) {
    TODO_PUBLICO("Apta para todos los públicos"),
    MAYORES_DE_7("Mayores de 7 años"),
    MAYORES_DE_13("Mayores de 13 años"),
    MAYORES_DE_18("Mayores de 18 años");

    override fun toString(): String {
        return nombre
    }
}
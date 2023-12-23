package com.example.android_project.Models

class Actores(val nombreDelActor: String, val nombreDelPersonaje: String) {
    override fun toString(): String {
        return "Nombre del actor: $nombreDelActor\nNombre del personaje: $nombreDelPersonaje\n"
    }
}
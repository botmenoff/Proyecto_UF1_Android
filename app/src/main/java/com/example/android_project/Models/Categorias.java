package com.example.android_project.Models;

public enum Categorias {
    ACCION("Acción"),
    COMEDIA("Comedia"),
    DRAMA("Drama"),
    CIENCIA_FICCION("Ciencia Ficción"),
    ANIMACION("Animación"),
    TERROR("Terror");

    private final String nombre;

    Categorias(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

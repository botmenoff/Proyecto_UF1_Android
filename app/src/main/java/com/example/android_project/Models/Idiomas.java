package com.example.android_project.Models;

public enum Idiomas {
    ESPANOL("Español"),
    INGLES("Inglés"),
    FRANCES("Francés"),
    ITALIANO("Italiano"),
    RUSO("Ruso");

    private final String nombre;

    Idiomas(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

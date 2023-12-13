package com.example.android_project.Models;

public enum RestriccionEdad {
    TODO_PUBLICO("Todo Público"),
    MAYORES_DE_7("Mayores de 7 años"),
    MAYORES_DE_13("Mayores de 13 años"),
    MAYORES_DE_18("Mayores de 18 años");

    private final String descripcion;

    RestriccionEdad(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}

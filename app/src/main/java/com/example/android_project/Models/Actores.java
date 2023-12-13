package com.example.android_project.Models;

public class Actores {
    // ATRIBUTOS
    private static int contadorId = 1; // Para hacer el id autoincremental
    private int id;
    private String nombre;

    private int edad;

    // CONSTRUCTOR
    public Actores(String nombre, int edad) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.edad = edad;
    }

}

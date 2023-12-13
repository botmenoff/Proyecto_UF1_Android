package com.example.android_project.Models;

import java.util.ArrayList;

public class Peliculas {

    // ATRIBUTOS
    private String titulo;
    private String descripcion;
    private String urlImagen;
    private Boolean esNueva;
    private ArrayList<Idiomas> idiomasDisponible;
    private RestriccionEdad restriccionEdad;
    private ArrayList<Categorias> categorias;
    private ArrayList<Actores> reparto;


    // CONSTRUCTOR
    public Peliculas(String titulo, String descripcion, String urlImagen, Boolean esNueva, ArrayList<Idiomas> idiomasDisponible, RestriccionEdad restriccionEdad, ArrayList<Categorias> categorias, ArrayList<Actores> reparto) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.esNueva = esNueva;
        this.idiomasDisponible = idiomasDisponible;
        this.restriccionEdad = restriccionEdad;
        this.categorias = categorias;
        this.reparto = reparto;
    }

}

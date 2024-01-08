package com.example.android_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android_project.Models.Peliculas
import com.example.android_project.databinding.ActivityMainBinding

import android.widget.TextView
import com.example.android_project.ApiCalls.ApiCalls
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val peliculas: MutableList<Peliculas> = mutableListOf()
    private lateinit var listPeliculasHomeAdapter: ListPeliculasHomeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}

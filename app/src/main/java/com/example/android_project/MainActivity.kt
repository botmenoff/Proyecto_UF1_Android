package com.example.android_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val changeViewButton: Button = findViewById(R.id.changeView)

        changeViewButton.setOnClickListener {
            val intent = Intent(this, Buscador::class.java)
            startActivity(intent)
        }
    }
}
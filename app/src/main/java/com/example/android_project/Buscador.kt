package com.example.android_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Buscador : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscador)

        // Para los filtros
        val bottomSheetFragment = BottomSheetFragment()
        val btn_filters = findViewById<ImageButton>(R.id.showFilters)

        btn_filters.setOnClickListener {
            bottomSheetFragment.show(supportFragmentManager, "Fragment to show")
        }
    }
}
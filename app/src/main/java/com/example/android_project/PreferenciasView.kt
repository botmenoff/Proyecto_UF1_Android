package com.example.android_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android_project.databinding.ActivityMainBinding
import com.example.android_project.databinding.ActivityPreferenciasViewBinding

class PreferenciasView : AppCompatActivity() {

    private lateinit var binding: ActivityPreferenciasViewBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferencias_view)

        binding = ActivityPreferenciasViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var ivCheckTodosPublicos = binding.ivCheckTodosPublicos
        var ivCheckSiete = binding.ivCheckSiete
        var ivCheckTrece = binding.ivCheckTrece
        var ivCheckDieciocho = binding.ivCheckDieciocho

        var lyTodosPublicos = binding.lyTodosPublicos
        var lyMasSiete = binding.lyMasSiete
        var lyMasTrece = binding.lyMasTrece
        var lyMasDieciocho = binding.lyMasDieciocho

        /**
         * Esta variable nos permitira saber cual es el layout que ha elegido el usuario
         */
        var layoutSeleccionado = lyTodosPublicos
        var ivCheckSelecionado = ivCheckTodosPublicos

        /**
         * Evento que muestra el check del LY "Apto para todos los públicos"
         */
        lyTodosPublicos.setOnClickListener {
            if (layoutSeleccionado != lyTodosPublicos) {
                ivCheckSelecionado.visibility = View.INVISIBLE // Ocultamos el Check del LY anterior
                ivCheckTodosPublicos.visibility = View.VISIBLE

                layoutSeleccionado = lyTodosPublicos // Actualizamos los LY y IV seleccionado
                ivCheckSelecionado = ivCheckTodosPublicos
            }
        }

        /**
         * Evento que muestra el check del LY "Mayores de 7 años"
         */
        lyMasSiete.setOnClickListener {
            if (layoutSeleccionado != lyMasSiete) {
                ivCheckSelecionado.visibility = View.INVISIBLE // Ocultamos el Check del LY anterior
                ivCheckSiete.visibility = View.VISIBLE

                layoutSeleccionado = lyMasSiete // Actualizamos los LY y IV seleccionado
                ivCheckSelecionado = ivCheckSiete
            }
        }

        /**
         * Evento que muestra el check del LY "Mayores de 13 años"
         */
        lyMasTrece.setOnClickListener {
            if (layoutSeleccionado != lyMasTrece) {
                ivCheckSelecionado.visibility = View.INVISIBLE // Ocultamos el Check del LY anterior
                ivCheckTrece.visibility = View.VISIBLE

                layoutSeleccionado = lyMasTrece // Actualizamos los LY y IV seleccionado
                ivCheckSelecionado = ivCheckTrece
            }
        }

        /**
         * Evento que muestra el check del LY "Mayores de 18 años"
         */
        lyMasDieciocho.setOnClickListener {
            if (layoutSeleccionado != lyMasDieciocho) {
                ivCheckSelecionado.visibility = View.INVISIBLE // Ocultamos el Check del LY anterior
                ivCheckDieciocho.visibility = View.VISIBLE

                layoutSeleccionado = lyMasDieciocho // Actualizamos los LY y IV seleccionado
                ivCheckSelecionado = ivCheckDieciocho
            }
        }
    }
}
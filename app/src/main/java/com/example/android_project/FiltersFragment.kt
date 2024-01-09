package com.example.android_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_project.Models.RestriccionEdad
import com.example.android_project.databinding.FiltersBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.fragment.app.viewModels


class FiltersFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FiltersBinding // Asegúrate de que el nombre del archivo de diseño coincide
    private var edadSeleccionadaString: String? = null
    private var edadSeleccionada: RestriccionEdad = RestriccionEdad.TODO_PUBLICO


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Utiliza el método inflate del View Binding para inflar la vista
        binding = FiltersBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Resto de tu código aquí...

        val closeButton = binding.closeEmergent
        closeButton.setOnClickListener {
            dismiss()
        }


        /**
         * COGEMOS TODOS LOS SWICH
         */
        val accionSw = binding.swAccion
        val comediaSw = binding.swComedia
        val dramaSw = binding.swDrama
        val cienciaSw = binding.swCienciaFiccion
        val animacionSw = binding.swAnimacion
        val terrorSw = binding.swTerror

        /**
         * CODIGO PARA MOVER EL CHECK
         */
        /**
         * RESTRICCION DE EDAD SELECCIONADA
         */
        var ivCheckTodosPublicos = binding.ivCheckTodosPublicos
        var ivCheckSiete = binding.ivCheckSiete
        var ivCheckTrece = binding.ivCheckTrece
        var ivCheckDieciocho = binding.ivCheckDieciocho

        var lyTodosPublicos = binding.lyTodosPublicos
        var lyMasSiete = binding.lyMasSiete
        var lyMasTrece = binding.lyMasTrece
        var lyMasDieciocho = binding.lyMasDieciocho

        /**
         * Estas variables nos permitiran saber cual es el layout que ha elegido el usuario
         */
        var layoutSeleccionado = lyTodosPublicos
        var ivCheckSelecionado = ivCheckTodosPublicos

        /**
         * Mostramos la edad que tenia guardada el usuario
         */
        val e = RestriccionEdad.values().find { it.nombre.equals(edadSeleccionadaString, ignoreCase = true) }
        if (e != null) {

            /**
             * Mostramos el check en el layout correspondiente
             */
            when (e) {
                RestriccionEdad.MAYORES_DE_7 -> {
                    layoutSeleccionado = lyMasSiete
                    ivCheckSelecionado = ivCheckSiete
                    ivCheckTodosPublicos.visibility = View.INVISIBLE
                    ivCheckSiete.visibility = View.VISIBLE
                }
                RestriccionEdad.MAYORES_DE_13 -> {
                    layoutSeleccionado = lyMasTrece
                    ivCheckSelecionado = ivCheckTrece
                    ivCheckTodosPublicos.visibility = View.INVISIBLE
                    ivCheckTrece.visibility = View.VISIBLE
                }
                RestriccionEdad.MAYORES_DE_18 -> {
                    layoutSeleccionado = lyMasDieciocho
                    ivCheckSelecionado = ivCheckDieciocho
                    ivCheckTodosPublicos.visibility = View.INVISIBLE
                    ivCheckDieciocho.visibility = View.VISIBLE
                }

                else -> {} // En el caso de que sea TODO_PUBLICO, no hacemos nada
            }
        }

        /**
         * Evento que muestra el check del LY "Apto para todos los públicos"
         */
        lyTodosPublicos.setOnClickListener {
            if (layoutSeleccionado != lyTodosPublicos) {
                ivCheckSelecionado.visibility = View.INVISIBLE // Ocultamos el Check del LY anterior
                ivCheckTodosPublicos.visibility = View.VISIBLE

                layoutSeleccionado = lyTodosPublicos // Actualizamos los LY y IV seleccionado
                ivCheckSelecionado = ivCheckTodosPublicos

                edadSeleccionada = RestriccionEdad.TODO_PUBLICO
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

                edadSeleccionada = RestriccionEdad.MAYORES_DE_7
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

                edadSeleccionada = RestriccionEdad.MAYORES_DE_13
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

                edadSeleccionada = RestriccionEdad.MAYORES_DE_18
            }
        }
    }
}

package com.example.android_project

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.android_project.Models.Categorias
import com.example.android_project.Models.RestriccionEdad
import com.example.android_project.databinding.ActivityPreferenciasViewBinding

class PreferenciasView : AppCompatActivity() {

    private lateinit var binding: ActivityPreferenciasViewBinding
    private var usuarioRegistrado: Boolean = false
    private var edadSeleccionada: RestriccionEdad = RestriccionEdad.TODO_PUBLICO
    private var categoriasPreferidas: MutableList<Categorias> = mutableListOf()

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferencias_view)

        binding = ActivityPreferenciasViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * Obtemos los parametros pasados en caso de tener
         */
        val extras = intent.extras
        val estaRegistrado = extras?.getBoolean("estaRegistrado")
        val nombreUsuario = extras?.getString("nombreUsuario").toString()
        val categoriasPreferidasString = extras?.getString("categoriasPreferidas").toString()
        val edadSeleccionadaString = extras?.getString("edadSeleccionada").toString()

        /**
         * NOMBRE DEL USUARIO
         */
        val inpNombre = binding.inpNombre
        if (estaRegistrado == true) {
            inpNombre.setText(nombreUsuario)
        }

        /**
         * RESTRICCION DE EDAD SELECCIONADA
         */
        val ivCheckTodosPublicos = binding.ivCheckTodosPublicos
        val ivCheckSiete = binding.ivCheckSiete
        val ivCheckTrece = binding.ivCheckTrece
        val ivCheckDieciocho = binding.ivCheckDieciocho

        val lyTodosPublicos = binding.lyTodosPublicos
        val lyMasSiete = binding.lyMasSiete
        val lyMasTrece = binding.lyMasTrece
        val lyMasDieciocho = binding.lyMasDieciocho

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
         * Desplegar o contraer el acordeon
         */
        val lySwEdadSeleccionadaOculto = binding.lySwEdadSeleccionadaOculto
        val lyAcordeonEdadVisible = binding.lyAcordeonEdadVisible
        val ivExpandRestriccionEdad = binding.ivExpandRestriccionEdad
        lyAcordeonEdadVisible.setOnClickListener {

            if (lySwEdadSeleccionadaOculto.visibility == View.VISIBLE) {
                lySwEdadSeleccionadaOculto.visibility = View.GONE
                ivExpandRestriccionEdad.setImageResource(R.drawable.expand_more_24)
            } else {
                lySwEdadSeleccionadaOculto.visibility = View.VISIBLE
                ivExpandRestriccionEdad.setImageResource(R.drawable.expand_less_24)
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

        /**
         * CATEGORIAS ELEGIDAS
         */

        val swAccion = binding.swAccion
        val swComedia = binding.swComedia
        val swDrama = binding.swDrama
        val swCienciaFiccion = binding.swCienciaFiccion
        val swAnimacion = binding.swAnimacion
        val swTerror = binding.swTerror

        /**
         * Guardamos en nuestro array de categorias preferidas las categorias que teniamos anteriormente
         */
        val categoriasArray = categoriasPreferidasString.split("\n,")
        categoriasPreferidas = Categorias.values()
            .filter { categoriasArray.any { categoriaArray -> it.nombre.equals(categoriaArray.replace("\n", ""), ignoreCase = true) } }
            .toMutableList()
        categoriasPreferidas.forEach { categoria ->
            when (categoria) {
                Categorias.ACCION -> swAccion.isChecked = true
                Categorias.COMEDIA -> swComedia.isChecked = true
                Categorias.DRAMA -> swDrama.isChecked = true
                Categorias.CIENCIA_FICCION -> swCienciaFiccion.isChecked = true
                Categorias.ANIMACION -> swAnimacion.isChecked = true
                Categorias.TERROR -> swTerror.isChecked = true
                else -> {}
            }
        }

        /**
         * Desplegar o contraer el acordeon
         */
        val lySwCategoriasFavoritasOculto = binding.lySwCategoriasFavoritasOculto
        val lyAcordeonCategoriasVisible = binding.lyAcordeonCategoriasVisible
        val ivExpandCategoriasFavoritas = binding.ivExpandCategoriasFavoritas
        lyAcordeonCategoriasVisible.setOnClickListener {
            Log.i("--->", "entra")
            if (lySwCategoriasFavoritasOculto.visibility == View.VISIBLE) {
                lySwCategoriasFavoritasOculto.visibility = View.GONE
                ivExpandCategoriasFavoritas.setImageResource(R.drawable.expand_more_24)
            } else {
                lySwCategoriasFavoritasOculto.visibility = View.VISIBLE
                ivExpandCategoriasFavoritas.setImageResource(R.drawable.expand_less_24)
            }
        }

        /**
         * Evento que guarda o elimina la categoria ACCION de las preferencias del usuario
         */
        swAccion.setOnClickListener {
            if (swAccion.isChecked) {
                categoriasPreferidas.add(Categorias.ACCION)
            } else {
                categoriasPreferidas.remove(Categorias.ACCION)
            }
        }

        /**
         * Evento que guarda o elimina la categoria COMEDIA de las preferencias del usuario
         */
        swComedia.setOnClickListener {
            if (swComedia.isChecked) {
                categoriasPreferidas.add(Categorias.COMEDIA)
            } else {
                categoriasPreferidas.remove(Categorias.COMEDIA)
            }
        }

        /**
         * Evento que guarda o elimina la categoria DRAMA de las preferencias del usuario
         */
        swDrama.setOnClickListener {
            if (swDrama.isChecked) {
                categoriasPreferidas.add(Categorias.DRAMA)
            } else {
                categoriasPreferidas.remove(Categorias.DRAMA)
            }
        }

        /**
         * Evento que guarda o elimina la categoria CIENCIA FICCION de las preferencias del usuario
         */
        swCienciaFiccion.setOnClickListener {
            if (swCienciaFiccion.isChecked) {
                categoriasPreferidas.add(Categorias.CIENCIA_FICCION)
            } else {
                categoriasPreferidas.remove(Categorias.CIENCIA_FICCION)
            }
        }

        /**
         * Evento que guarda o elimina la categoria ANIMACION de las preferencias del usuario
         */
        swAnimacion.setOnClickListener {
            if (swAnimacion.isChecked) {
                categoriasPreferidas.add(Categorias.ANIMACION)
            } else {
                categoriasPreferidas.remove(Categorias.ANIMACION)
            }
        }

        /**
         * Evento que guarda o elimina la categoria TERROR de las preferencias del usuario
         */
        swTerror.setOnClickListener {
            if (swTerror.isChecked) {
                categoriasPreferidas.add(Categorias.TERROR)
            } else {
                categoriasPreferidas.remove(Categorias.TERROR)
            }
        }

        val btnGuardar = binding.btnGuardar

        /**
         * Evento que comprueba que el usuario ha guardado bien sus preferencias y registra al usuario
         */
        btnGuardar.setOnClickListener {
            if (inpNombre.text.toString().isNotEmpty() && categoriasPreferidas.isNotEmpty()) {
                usuarioRegistrado = true
                Toast.makeText(this, "Preferencias guardadas exitosamente", Toast.LENGTH_SHORT).show()
            } else {
                usuarioRegistrado = false
                Toast.makeText(this, "Has de escribir tu nombre y seleccionar almenos 1 categoria", Toast.LENGTH_SHORT).show()
            }
        }

        /**
         * Evento MENU
         */
        val lyHome = binding.lyHome
        lyHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            if (usuarioRegistrado) {
                intent.putExtra("estaRegistrado", usuarioRegistrado)
                intent.putExtra("nombreUsuario", inpNombre.text.toString())
                intent.putExtra("categoriasPreferidas", categoriasPreferidas.joinToString(","))
                intent.putExtra("edadSeleccionada", edadSeleccionada.toString())
            }
            else if (!usuarioRegistrado && estaRegistrado == true) { // En el caso de que el usuario tenia guardado anteriormente sus preferencias
                intent.putExtra("estaRegistrado", estaRegistrado)
                intent.putExtra("nombreUsuario", nombreUsuario)
                intent.putExtra("categoriasPreferidas", categoriasPreferidasString)
                intent.putExtra("edadSeleccionada", edadSeleccionadaString)
            }
            startActivity(intent)
        }

        val lyBuscador = binding.lyBuscador
        lyBuscador.setOnClickListener {
            val intent = Intent(this, BuscadorView::class.java)
            if (usuarioRegistrado) {
                intent.putExtra("estaRegistrado", usuarioRegistrado)
                intent.putExtra("nombreUsuario", inpNombre.text.toString())
                intent.putExtra("categoriasPreferidas", categoriasPreferidas.joinToString(","))
                intent.putExtra("edadSeleccionada", edadSeleccionada.toString())
            }
            else if (!usuarioRegistrado && estaRegistrado == true) { // En el caso de que el usuario tenia guardado anteriormente sus preferencias
                intent.putExtra("estaRegistrado", estaRegistrado)
                intent.putExtra("nombreUsuario", nombreUsuario)
                intent.putExtra("categoriasPreferidas", categoriasPreferidasString)
                intent.putExtra("edadSeleccionada", edadSeleccionadaString)
            }
            startActivity(intent)
        }
    }
}
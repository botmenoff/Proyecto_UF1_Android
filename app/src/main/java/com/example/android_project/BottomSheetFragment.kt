package com.example.android_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.Toast
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment: BottomSheetDialogFragment() {

    private val filterList = ArrayList<String>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.filters, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val closeButton = view.findViewById<ImageButton>(R.id.closeEmergent)
        closeButton.setOnClickListener {
            dismiss()
        }

        /**
         * Buscar filtros
         * */
        val searchFilters = view.findViewById<Button>(R.id.apply_filters)
        searchFilters.setOnClickListener {
            searchFilters(filterList)
        }

        /**
         * Lista que añade o elimina los filtros seleccionados
         */

        val restriccion_mas_siete = view.findViewById<CheckBox>(R.id.restriccion_mas_siete)
        val restriccion_mas_catorce = view.findViewById<CheckBox>(R.id.restriccion_mas_catorze)
        val restriccion_mas_dieciocho = view.findViewById<CheckBox>(R.id.restriccion_mas_dieciocho)
        val categorias_accion = view.findViewById<CheckBox>(R.id.categorias_accion)
        val categorias_comedia = view.findViewById<CheckBox>(R.id.categorias_comedia)
        val categorias_drama = view.findViewById<CheckBox>(R.id.categorias_drama)
        val categorias_ciencia = view.findViewById<CheckBox>(R.id.categorias_ciencia)
        val categorias_animacion = view.findViewById<CheckBox>(R.id.categorias_animacion)
        val categorias_terror = view.findViewById<CheckBox>(R.id.categorias_terror)


        // Agregar escuchadores a los CheckBox
        restriccion_mas_siete.setOnCheckedChangeListener { _, isChecked ->
            updateFilterList("+7", isChecked)
        }

        restriccion_mas_catorce.setOnCheckedChangeListener { _, isChecked ->
            updateFilterList("+14", isChecked)
        }

        restriccion_mas_dieciocho.setOnCheckedChangeListener { _, isChecked ->
            updateFilterList("+18", isChecked)
        }

        categorias_accion.setOnCheckedChangeListener { _, isChecked ->
            updateFilterList("accion", isChecked)
        }

        categorias_comedia.setOnCheckedChangeListener { _, isChecked ->
            updateFilterList("comedia", isChecked)
        }

        categorias_drama.setOnCheckedChangeListener { _, isChecked ->
            updateFilterList("drama", isChecked)
        }

        categorias_ciencia.setOnCheckedChangeListener { _, isChecked ->
            updateFilterList("ciencia", isChecked)
        }

        categorias_animacion.setOnCheckedChangeListener { _, isChecked ->
            updateFilterList("animacion", isChecked)
        }

        categorias_terror.setOnCheckedChangeListener { _, isChecked ->
            updateFilterList("terror", isChecked)
        }
    }

    private fun updateFilterList(filter: String, isChecked: Boolean) {
        if (isChecked) {
            filterList.add(filter)
        } else {
            filterList.remove(filter)
        }
    }

    private fun searchFilters(filterList: ArrayList<String>) {
        // Aquí puedes realizar acciones con la lista de filtros seleccionados
        // Por ejemplo, mostrar un Toast con los filtros seleccionados
        val filtersText = if (filterList.isEmpty()) "No se han seleccionado filtros"
        else "Filtros seleccionados: ${filterList.joinToString(", ")}"

        // Mostrar Toast
        // Puedes cambiar 'requireContext()' por 'context' si estás fuera de un fragmento
        Toast.makeText(requireContext(), filtersText, Toast.LENGTH_SHORT).show()
    }
}

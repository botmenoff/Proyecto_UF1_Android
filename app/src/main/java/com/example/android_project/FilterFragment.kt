package com.example.android_project

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class FilterFragment: BottomSheetDialogFragment() {

    // ArrayList para guardar los filtros que el usuario selecciona
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

        // TODO: Hacer el esqueleto para pasar los filtros a la funcion de buscar
    }
}

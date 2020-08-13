package com.zentechnology.controles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

import android.widget.CheckBox

import android.widget.Toast

class CheckboxActivity : AppCompatActivity() {

    lateinit var checkbox: CheckBox
    lateinit var checkboxDesactivado: CheckBox
    lateinit var btnActivar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox)

        checkbox = findViewById(R.id.ckb1)
        checkboxDesactivado = findViewById(R.id.ckb2)
        btnActivar = findViewById(R.id.btnActivar)

        btnActivar.setOnClickListener {
            checkboxDesactivado.isEnabled = true
        }
    }

    fun obtenerEstado_click(view: View) {
        val state = "Estado: " + if (checkbox.isChecked()) "Checkeado" else "No Checkeado"
        Toast.makeText(this, state, Toast.LENGTH_LONG).show()
    }
}

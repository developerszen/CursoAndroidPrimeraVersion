package com.zentechnology.controles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_text_input_layout.*
import java.util.regex.Pattern

class TextInputLayoutActivity : AppCompatActivity() {

    private var tilNombre: TextInputLayout? = null
    private var tilTelefono: TextInputLayout? = null
    private var tilEmail: TextInputLayout? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_input_layout)

        tilNombre = findViewById(R.id.til_nombre)
        tilTelefono = findViewById(R.id.til_telefono)
        tilEmail = findViewById(R.id.til_correo)

        val botonAceptar = findViewById(R.id.btnAceptar) as Button
        botonAceptar.setOnClickListener {
            validarDatos()
        }
    }

    private fun esNombreValido(nombre: String): Boolean {
        val patron = Pattern.compile("^[a-zA-Z ]+\$")
        if (!patron.matcher(nombre).matches() || nombre.length > 30) {
            tilNombre?.setError("Nombre invalido")
            return false
        } else {
            tilNombre?.setError(null)
        }

        return true
    }

    private fun esCorreoValido(correo: String): Boolean {
        if(!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            tilEmail?.setError("Correo invalido")
            return false
        } else {
            tilEmail?.setError(null)
        }

        return true
    }

    private fun esTelefonoValido(telefono:String) :Boolean {
        if(!Patterns.PHONE.matcher(telefono).matches()) {
            tilTelefono?.setError("Telefono invalido")
            return false
        } else {
            tilTelefono?.setError(null)
        }

        return true
    }


    private fun validarDatos() {
        val nombre = tilNombre?.getEditText()!!.text.toString()
        val telefono = tilTelefono?.getEditText()!!.text.toString()
        val correo = tilEmail?.getEditText()!!.text.toString()

        val a = esNombreValido(nombre)
        val b = esTelefonoValido(telefono)
        val c = esCorreoValido(correo)

        if(a==true && b==true && c==true) {
            Toast.makeText(this, "Se guardo el registro", Toast.LENGTH_LONG).show()
        }

    }

}

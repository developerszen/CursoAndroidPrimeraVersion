package com.zentechnology.parametrosactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var texto: EditText
    lateinit var boton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texto = findViewById(R.id.texto1)
        boton = findViewById(R.id.boton1)

        boton.setOnClickListener{
            lanzarActivity(texto.text.toString())
        }
    }

    fun lanzarActivity(texto: String) {
        val i = Intent(this, SegundoActivity::class.java)
        if(texto == "" || texto == null) {
            i.putExtra("texto", "TEXTO VACIO")
        } else {
            i.putExtra("texto", texto)
        }

        startActivity(i)

    }
}

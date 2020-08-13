package com.zentechnology.controles

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ButtonsActivity : AppCompatActivity() {

    lateinit var boton1: Button
    lateinit var boton2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buttons)

        boton1 = findViewById(R.id.btn1)

        boton1.setOnClickListener {
            boton1.setText("Texto Cambiado")
        }

        boton2 = findViewById(R.id.btn2)

        /*
        boton2.setOnClickListener {

        }*/
    }

    fun boton2_click(view: View) {
        boton2.setBackgroundColor(Color.WHITE)
        boton2.setTextColor(Color.BLACK)
    }
}

package com.zentechnology.parametrosactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class SegundoActivity : AppCompatActivity() {

    lateinit var texto2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segundo)

        val value = intent.extras.getString("texto")

        texto2 = findViewById(R.id.texto2)
        texto2.setText(value)
    }

    fun retornar_click(view: View) {
        this.finish()
    }
}

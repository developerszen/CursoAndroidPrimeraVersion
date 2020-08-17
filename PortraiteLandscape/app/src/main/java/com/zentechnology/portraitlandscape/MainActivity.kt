package com.zentechnology.portraitlandscape

import android.content.res.Configuration
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.tvLayout)
        button = findViewById(R.id.button)

        var resources : Resources = button.resources

        button.setOnClickListener{
            if (resources.configuration.orientation === Configuration.ORIENTATION_PORTRAIT) {
                Toast.makeText(this, "Modo Portrait", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Modo Landscape", Toast.LENGTH_LONG).show()
            }
        }
    }
}

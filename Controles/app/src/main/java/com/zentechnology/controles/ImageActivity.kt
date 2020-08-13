package com.zentechnology.controles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class ImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        val image2 = findViewById<ImageView>(R.id.imvPaisaje2)
        val image1 = findViewById<ImageView>(R.id.imvPaisaje1)

        image1.setOnClickListener {
            Toast.makeText(applicationContext, "Click en la imagen 1", Toast.LENGTH_LONG).show()
        }

        image2.setOnClickListener {
            Toast.makeText(applicationContext, "Clic en la imagen 2", Toast.LENGTH_LONG).show()
        }
    }
}

package com.zentechnology.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), OnFragmentActionsListener {

    override fun onClickFragmentButton() {
        Toast.makeText(this, "El boton ha sido pulsado", Toast.LENGTH_LONG).show()
    }

    lateinit var btnRed: Button
    lateinit var btnBlue: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRed = findViewById(R.id.btnRed)
        btnBlue = findViewById(R.id.btnBlue)

        btnRed.setOnClickListener{
            replaceFragment(RedFragment())
        }

        btnBlue.setOnClickListener{
            replaceFragment(BlueFragment())
        }
    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}

package com.zentechnology.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlin.math.log

class GridLayoutActivity : AppCompatActivity() {

    var cadena = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_layout)
    }

    fun btnNumero1(view: View) {
        cadena = cadena + "1"
        Log.e("TAG", "Imprimir numero 1")
        Log.e("Numero", cadena)
    }
    fun btnNumero2(view: View) {
        cadena = cadena + "2"
        Log.e("TAG", "Imprimir numero 2")
        Log.e("Numero", cadena)
    }
    fun btnNumero3(view: View) {
        cadena = cadena + "3"
        Log.e("TAG", "Imprimir numero 3")
        Log.e("Numero", cadena)
    }
    fun btnNumero4(view: View) {
        cadena = cadena + "4"
        Log.e("TAG", "Imprimir numero 4")
        Log.e("Numero", cadena)
    }
    fun btnNumero5(view: View) {
        cadena = cadena + "5"
        Log.e("TAG", "Imprimir numero 5")
        Log.e("Numero", cadena)
    }
    fun btnNumero6(view: View) {
        cadena = cadena + "6"
        Log.e("TAG", "Imprimir numero 6")
        Log.e("Numero", cadena)
    }
    fun btnNumero7(view: View) {
        cadena = cadena + "7"
        Log.e("TAG", "Imprimir numero 7")
        Log.e("Numero", cadena)
    }
    fun btnNumero8(view: View) {
        cadena = cadena + "8"
        Log.e("TAG", "Imprimir numero 8")
        Log.e("Numero", cadena)
    }

    fun btnNumero9(view: View) {
        cadena = cadena + "9"
        Log.e("TAG", "Imprimir numero 9")
        Log.e("Numero", cadena)
    }
    fun btnNumero0(view: View) {
        cadena = cadena + "0"
        Log.e("TAG", "Imprimir numero 0")
        Log.e("Numero", cadena)
    }


    fun btnSignoDivision(view: View) {
        cadena = cadena + "/"
        Log.e("TAG", "Imprimir division")
        Log.e("Numero", cadena)
    }


    fun btnSignoPor(view: View) {
        cadena = cadena + "*"
        Log.e("TAG", "Imprimir multiplicacion")
        Log.e("Numero", cadena)
    }


    fun btnSignoResta(view: View) {
        cadena = cadena + "-"
        Log.e("TAG", "imprimir resta")
        Log.e("Numero", cadena)
    }

    fun btnSignoSuma(view: View) {
        cadena = cadena + "+"
        Log.e("TAG", "Imprimir suma")
        Log.e("Numero", cadena)
    }

    fun btnSignoIgual(view: View) {
        Log.e("TAG", "procesar calculadora")
        Log.e("Numero", cadena)

    }
}

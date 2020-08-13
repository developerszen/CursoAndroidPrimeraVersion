package com.zentechnology.layouts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlin.math.log

class GridLayoutActivity: AppCompatActivity() {

    var numero1 = 0
    var numero2 = 0
    var operando = false
    var signoOperando = "/"

    var cadena = ""

    lateinit var pantalla : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_layout)

        pantalla = findViewById<TextView>(R.id.pantalla)

    }

    fun realizarOperacion(valor1: Int, valor2: Int, signo: String): Double {
        if(signo == "+") {
            return (valor1 + valor2).toDouble()
        }
        if(signo == "-") {
            return (valor1 - valor2).toDouble()
        }
        if(signo == "*") {
            return (valor1 * valor2).toDouble()
        }
        if(signo == "/") {
            return valor1.toDouble() / valor2.toDouble()
        }

        return 0.0
    }

    fun btnNumero1(view: View) {

        if (operando) {
            numero2 = 1
        } else {
            numero1 = 1
        }

        cadena = cadena + "1"
        pantalla.setText(cadena)
    }
    fun btnNumero2(view: View) {
        if (operando) {
            numero2 = 2
        } else {
            numero1 = 2
        }

        cadena = cadena + "2"
        pantalla.setText(cadena)
    }
    fun btnNumero3(view: View) {
        if (operando) {
            numero2 = 3
        } else {
            numero1 = 3
        }

        cadena = cadena + "3"
        pantalla.setText(cadena)
    }
    fun btnNumero4(view: View) {
        if (operando) {
            numero2 = 4
        } else {
            numero1 = 4
        }

        cadena = cadena + "4"
        pantalla.setText(cadena)
    }
    fun btnNumero5(view: View) {
        if (operando) {
            numero2 = 5
        } else {
            numero1 = 5
        }

        cadena = cadena + "5"
        pantalla.setText(cadena)
    }
    fun btnNumero6(view: View) {
        if (operando) {
            numero2 = 6
        } else {
            numero1 = 6
        }

        cadena = cadena + "6"
        pantalla.setText(cadena)
    }
    fun btnNumero7(view: View) {
        if (operando) {
            numero2 = 7
        } else {
            numero1 = 7
        }

        cadena = cadena + "7"
        pantalla.setText(cadena)
    }
    fun btnNumero8(view: View) {
        if (operando) {
            numero2 = 8
        } else {
            numero1 = 8
        }

        cadena = cadena + "8"
        pantalla.setText(cadena)
    }

    fun btnNumero9(view: View) {
        if (operando) {
            numero2 = 9
        } else {
            numero1 = 9
        }

        cadena = cadena + "9"
        pantalla.setText(cadena)
    }

    fun btnNumero0(view: View) {
        if (operando) {
            numero2 = 0
        } else {
            numero1 = 0
        }

        cadena = cadena + "9"
        pantalla.setText(cadena)
    }

    fun btnSignoDivision(view: View) {
        operando = true
        signoOperando="/"
        cadena = cadena + "/"
        pantalla.setText(cadena)
    }

    fun btnSignoPor(view: View) {
        operando = true
        signoOperando="*"
        cadena = cadena + "*"
        pantalla.setText(cadena)
    }


    fun btnSignoResta(view: View) {
        operando = true
        signoOperando="-"
        cadena = cadena + "-"
        pantalla.setText(cadena)
    }

    fun btnSignoSuma(view: View) {
        operando = true
        signoOperando="+"
        cadena = cadena + "+"
        pantalla.setText(cadena)
    }

    fun btnSignoIgual(view: View) {
        var result = realizarOperacion(numero1, numero2, signoOperando)
        pantalla.setText(result.toString())
        operando = false
        signoOperando = ""
    }

    fun btnLimpiar(view: View) {
        cadena = ""
        pantalla.setText("")
        operando = false;
    }
}

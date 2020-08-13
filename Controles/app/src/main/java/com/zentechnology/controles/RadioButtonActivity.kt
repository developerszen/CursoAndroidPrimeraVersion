package com.zentechnology.controles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class RadioButtonActivity : AppCompatActivity() {

    lateinit var radioDeposito: RadioButton
    lateinit var radioPaypal: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)

        radioDeposito = findViewById(R.id.radio_deposito)
        radioPaypal = findViewById(R.id.radio_paypal)


        val contenedor = findViewById<RadioGroup>(R.id.radio_dias)
        val opcionDia = contenedor.getChildAt(2) as RadioButton
        opcionDia.isChecked = true
    }

    fun comprobarModoPago(v: View) {
        if(radioDeposito.isChecked()) {
            var text = "Debes realizar el pago en el banco"
            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
        }

        if (radioPaypal.isChecked()){
            var text = "El pago paypal no esta habilitado en bolivia"
            Toast.makeText(this, text, Toast.LENGTH_LONG).show()
        }
    }
}

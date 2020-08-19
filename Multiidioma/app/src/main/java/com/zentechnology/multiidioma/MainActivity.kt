package com.zentechnology.multiidioma

import android.content.DialogInterface
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity : AppCompatActivity() {

    private var button: Button? = null

    private var locale: Locale? = null
    private val config = Configuration()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        button!!.setOnClickListener{
            showDialog()
        }

    }

    fun showDialog() {
        val b = AlertDialog.Builder(this)
        b.setTitle(resources.getString(R.string.str_button))
        val types = resources.getStringArray(R.array.languages)

        b.setItems(types, DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
            when (which) {
                0 -> {
                    locale = Locale("en")
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        config.setLocale(locale)
                    } else {
                        config.locale = locale
                    }
                }
                1 -> {
                    locale = Locale("es")
                    config.locale = locale
                }
                2 -> {
                    locale = Locale("pt")
                    config.locale = locale
                }
            }

            resources.updateConfiguration(config, null)
            val refresh = Intent(this, MainActivity::class.java)
            startActivity(refresh)
            finish()
        })

        b.show()
    }
}

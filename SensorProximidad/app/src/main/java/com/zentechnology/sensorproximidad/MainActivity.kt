package com.zentechnology.sensorproximidad

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    lateinit var sensorManager: SensorManager
    lateinit var proximitySensor: Sensor

    lateinit var proximitySensorListener: SensorEventListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        proximitySensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY)

        if (proximitySensor == null) {
            Log.e("MainActivity", "Sensor de proximidad no esta disponible")
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        proximitySensorListener = object : SensorEventListener {
            override fun onSensorChanged(event: SensorEvent) {
                if (event.values[0] < proximitySensor.getMaximumRange())  {
                    getWindow().decorView.setBackgroundColor(Color.RED)
                } else {
                    getWindow().decorView.setBackgroundColor(Color.GREEN)
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

            }
        }

        sensorManager.registerListener(
            proximitySensorListener,
            proximitySensor, 2*1000*1000
        )
    }


    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(proximitySensorListener)
    }
}

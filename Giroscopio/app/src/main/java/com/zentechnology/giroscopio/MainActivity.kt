package com.zentechnology.giroscopio

import android.content.Context
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    lateinit var sensorManager: SensorManager
    lateinit var gyroscopeSensor: Sensor

    lateinit var gyroscopeSensorListener: SensorEventListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)

        gyroscopeSensorListener = object: SensorEventListener {
            override fun onSensorChanged(sensorEvent: SensorEvent) {
                if (sensorEvent.values[2] > 0.5f) {
                    window.decorView.setBackgroundColor(Color.BLUE)
                } else if (sensorEvent.values[2] < -0.5f) {
                    getWindow().getDecorView().setBackgroundColor(Color.YELLOW)
                }
            }

            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

            }
        }

        sensorManager.registerListener(
            gyroscopeSensorListener,
            gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL
        )
    }
}

package com.zentechnology.acelerometro

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.TextView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), SensorEventListener {

    lateinit var senSensorManager: SensorManager
    lateinit var senAccelerometer: Sensor

    private var lastUpdate: Long = 0
    private var last_x: Float = 0.toFloat()
    private var last_y: Float = 0.toFloat()
    private var last_z: Float = 0.toFloat()
    private val SHAKE_THRESHOLD = 600

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        senSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
        senSensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        senSensorManager.unregisterListener(this)
    }

    override fun onResume() {
        super.onResume()
        senSensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        val mySensor = event!!.sensor

        if(mySensor.type == Sensor.TYPE_ACCELEROMETER) {
            val x = event.values[0]
            val y = event.values[1]
            val z = event.values[2]

            val curTime = System.currentTimeMillis()

            if(curTime - lastUpdate > 100) {
                val diffTime = curTime - lastUpdate
                lastUpdate = curTime

                val speed = Math.abs(x + y + z - last_x - last_y - last_z) / diffTime * 10000

                if(speed > SHAKE_THRESHOLD) {
                    getRandomNumer()
                }


                last_x = x.toFloat()
                last_y = y.toFloat()
                last_z = z.toFloat()

            }
        }
    }

    fun getRandomNumer() {
        val numbersGenerated = ArrayList<Int>()

        var i = 0
        while (i < 6) {
            val randNumber = Random()
            val iNumber = randNumber.nextInt(48) + 1

            if(!numbersGenerated.contains(iNumber)) {
                numbersGenerated.add(iNumber)
            } else {
                i--
            }
            i++
        }


        var text = findViewById<TextView>(R.id.number_1)
        text.text = "" + numbersGenerated.get(0)

        text = findViewById<TextView>(R.id.number_2)
        text.text = "" + numbersGenerated.get(1)

        text = findViewById<TextView>(R.id.number_3)
        text.text = "" + numbersGenerated.get(2)


        text = findViewById<TextView>(R.id.number_4)
        text.text = "" + numbersGenerated.get(3)


        text = findViewById<TextView>(R.id.number_5)
        text.text = "" + numbersGenerated.get(4)


        text = findViewById<TextView>(R.id.number_6)
        text.text = "" + numbersGenerated.get(5)


        val ball1 = findViewById<FrameLayout>(R.id.ball_1)
        ball1.visibility = View.INVISIBLE

        val ball2 = findViewById<FrameLayout>(R.id.ball_2)
        ball2.visibility = View.INVISIBLE

        val ball3 = findViewById<FrameLayout>(R.id.ball_3)
        ball3.visibility = View.INVISIBLE

        val ball4 = findViewById<FrameLayout>(R.id.ball_4)
        ball4.visibility = View.INVISIBLE

        val ball5 = findViewById<FrameLayout>(R.id.ball_5)
        ball5.visibility = View.INVISIBLE

        val ball6 = findViewById<FrameLayout>(R.id.ball_6)
        ball6.visibility = View.INVISIBLE

        val a = AnimationUtils.loadAnimation(this, R.anim.move_down_ball_first)

        ball1.visibility = View.VISIBLE
        ball1.clearAnimation()
        ball1.startAnimation(a)

        ball2.visibility = View.VISIBLE
        ball2.clearAnimation()
        ball2.startAnimation(a)

        ball3.visibility = View.VISIBLE
        ball3.clearAnimation()
        ball3.startAnimation(a)

        ball4.visibility = View.VISIBLE
        ball4.clearAnimation()
        ball4.startAnimation(a)

        ball5.visibility = View.VISIBLE
        ball5.clearAnimation()
        ball5.startAnimation(a)

        ball6.visibility = View.VISIBLE
        ball6.clearAnimation()
        ball6.startAnimation(a)

    }

}

package com.zentechnology.camara

import android.Manifest
import android.app.Activity
import android.app.IntentService
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Camera
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.fotoapparat.Fotoapparat
import io.fotoapparat.configuration.CameraConfiguration
import io.fotoapparat.log.logcat
import io.fotoapparat.log.loggers
import io.fotoapparat.parameter.ScaleType
import io.fotoapparat.selector.back
import io.fotoapparat.selector.front
import io.fotoapparat.selector.off
import io.fotoapparat.selector.torch
import io.fotoapparat.view.CameraView
import java.io.File
import java.util.*



class MainActivity : AppCompatActivity() {

    var fotoapparat: Fotoapparat? = null
    var uuid = UUID.randomUUID()
    var randomUUIDString = uuid.toString()
    val filename =  randomUUIDString + ".png"
    val sd = Environment.getExternalStorageDirectory()
    val dest = File(sd, filename)

    var fotoappartState : FotoapparatState? = null
    var cameraStatus : CameraState? = null
    var flashState : FlashState? = null

    val permissions = arrayOf(android.Manifest.permission.CAMERA,
        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
        android.Manifest.permission.READ_EXTERNAL_STORAGE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createFotoapparat()

        cameraStatus = CameraState.BACK
        flashState = FlashState.OFF
        fotoappartState = FotoapparatState.OFF

        var fab_camera = findViewById<FloatingActionButton>(R.id.fab_camera)
        var fab_switch_camera = findViewById<FloatingActionButton>(R.id.fab_switch_camera)
        var fab_flash = findViewById<FloatingActionButton>(R.id.fab_flash)

        fab_camera.setOnClickListener{
            takePhoto()
        }

        fab_switch_camera.setOnClickListener{
            switchCamera()
        }

        fab_flash.setOnClickListener{
            changeFlashState()
        }
    }

    private fun createFotoapparat() {
        val cameraView = findViewById<CameraView>(R.id.camera_view)

        fotoapparat = Fotoapparat(
            context = this,
            view = cameraView,
            scaleType = ScaleType.CenterCrop,
            lensPosition = back(),
            logger = loggers(logcat()),
            cameraErrorCallback = {
                error -> println("error: $error")
            }
        )
    }

    private fun changeFlashState() {
        fotoapparat?.updateConfiguration(
            CameraConfiguration(
                flashMode = if(flashState == FlashState.TORCH) off() else torch()
            )
        )

        if(flashState == FlashState.TORCH) flashState = FlashState.OFF
        else flashState = FlashState.TORCH
    }

    private fun switchCamera() {
        fotoapparat?.switchTo(
            lensPosition = if(cameraStatus == CameraState.BACK) front() else back(),
            cameraConfiguration = CameraConfiguration()
        )

        if(cameraStatus == CameraState.BACK) cameraStatus = CameraState.FRONT
        else cameraStatus = CameraState.BACK
    }

    private fun takePhoto() {
        if(hasNoPermissions()) {
            val permissions = arrayOf(android.Manifest.permission.CAMERA,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
                android.Manifest.permission.READ_EXTERNAL_STORAGE)

            ActivityCompat.requestPermissions(this, permissions, 0)
        } else {
            fotoapparat?.takePicture()?.saveToFile(dest)
        }
    }

    private fun hasNoPermissions(): Boolean {
        return ContextCompat.checkSelfPermission(this,
            Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this,
            Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this,
            Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onStart() {
        super.onStart()

        if(hasNoPermissions()) {
            requestPermission()
        } else {
            fotoapparat?.start()
            fotoappartState = FotoapparatState.ON
        }
    }

    fun requestPermission() {
        ActivityCompat.requestPermissions(this, permissions, 0)
    }

    override fun onStop() {
        super.onStop()
        fotoapparat?.stop()
        FotoapparatState.OFF
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()

        if(!hasNoPermissions() && fotoappartState == FotoapparatState.OFF) {
            val intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    enum class CameraState {
        FRONT, BACK
    }

    enum class FlashState {
        TORCH, OFF
    }

    enum class FotoapparatState {
        ON, OFF
    }

}

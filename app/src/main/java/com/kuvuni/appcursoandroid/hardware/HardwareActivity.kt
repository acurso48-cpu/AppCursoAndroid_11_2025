package com.kuvuni.appcursoandroid.hardware

import android.content.Context
import android.hardware.camera2.CameraManager
import android.os.Bundle
import com.google.android.material.switchmaterial.SwitchMaterial
import com.kuvuni.appcursoandroid.BaseActivity
import com.kuvuni.appcursoandroid.R

class HardwareActivity : BaseActivity() {

    private lateinit var cameraManager: CameraManager
    private var cameraId: String? = null

    override fun getLayoutResource() = R.layout.activity_hardware

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        cameraManager = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        try {
            cameraId = cameraManager.cameraIdList[0] // Usamos la primera cámara
        } catch (e: Exception) {
            // Manejar el caso en que no hay cámara
        }

        val switchFlashlight = findViewById<SwitchMaterial>(R.id.switch_flashlight)
        switchFlashlight.setOnCheckedChangeListener { _, isChecked ->
            if (cameraId != null) {
                try {
                    cameraManager.setTorchMode(cameraId!!, isChecked)
                } catch (e: Exception) {
                    // Manejar posibles errores
                }
            }
        }
    }
}
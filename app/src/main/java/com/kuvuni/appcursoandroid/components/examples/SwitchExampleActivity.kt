package com.kuvuni.appcursoandroid.components.examples

import android.os.Bundle
import android.widget.TextView
import com.google.android.material.switchmaterial.SwitchMaterial
import com.kuvuni.appcursoandroid.BaseActivity
import com.kuvuni.appcursoandroid.R

class SwitchExampleActivity : BaseActivity() {
    override fun getLayoutResource() = R.layout.activity_switch_example

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textView = findViewById<TextView>(R.id.textView)
        val simpleSwitch = findViewById<SwitchMaterial>(R.id.simple_switch)

        simpleSwitch.setOnCheckedChangeListener { _, isChecked ->
            textView.text = if (isChecked) "Switch activado" else "Switch desactivado"
        }
    }
}
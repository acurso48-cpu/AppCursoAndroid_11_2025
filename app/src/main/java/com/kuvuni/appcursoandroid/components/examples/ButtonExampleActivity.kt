package com.kuvuni.appcursoandroid.components.examples

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.kuvuni.appcursoandroid.BaseActivity
import com.kuvuni.appcursoandroid.R

class ButtonExampleActivity : BaseActivity() {
    override fun getLayoutResource() = R.layout.activity_button_example

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textView = findViewById<TextView>(R.id.textView)

        findViewById<Button>(R.id.simple_button).setOnClickListener {
            textView.text = "Botón simple presionado"
        }

        findViewById<Button>(R.id.icon_button).setOnClickListener {
            Toast.makeText(this, "Botón con icono presionado", Toast.LENGTH_SHORT).show()
        }
    }
}
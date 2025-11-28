package com.kuvuni.appcursoandroid.navigation

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import com.kuvuni.appcursoandroid.BaseActivity
import com.kuvuni.appcursoandroid.R
import com.kuvuni.appcursoandroid.navigation.examples.NavComponentExampleActivity
import com.kuvuni.appcursoandroid.navigation.examples.NavigationFirstActivity

class NavigationActivity : BaseActivity() {
    override fun getLayoutResource() = R.layout.activity_navigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Intent Explícito
        findViewById<Button>(R.id.btn_explicit_intent).setOnClickListener {
            startActivity(Intent(this, NavigationFirstActivity::class.java))
        }

        // Intent Implícito para abrir URL
        findViewById<Button>(R.id.btn_open_url).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://developer.android.com"))
            startActivity(intent)
        }

        // Intent Implícito para compartir texto
        findViewById<Button>(R.id.btn_share_text).setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "¡Estoy aprendiendo a usar Intents en Android!")
            }
            startActivity(Intent.createChooser(intent, "Compartir con"))
        }

        // Ejemplo con Navigation Component
        findViewById<Button>(R.id.btn_nav_component_example).setOnClickListener {
            startActivity(Intent(this, NavComponentExampleActivity::class.java))
        }
    }
}
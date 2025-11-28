package com.kuvuni.appcursoandroid.layouts.examples

import android.os.Bundle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.kuvuni.appcursoandroid.BaseActivity
import com.kuvuni.appcursoandroid.R

class CoordinatorLayoutExampleActivity : BaseActivity() {
    override fun getLayoutResource() = R.layout.activity_coordinator_layout_example

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val coordinatorLayout = findViewById<CoordinatorLayout>(R.id.coordinator_layout)
        val fab = findViewById<FloatingActionButton>(R.id.fab_coordinator)

        fab.setOnClickListener {
            Snackbar.make(coordinatorLayout, "¡El FAB se ha movido!", Snackbar.LENGTH_LONG).show()
        }
    }
}
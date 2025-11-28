package com.kuvuni.appcursoandroid.components.examples

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import com.kuvuni.appcursoandroid.BaseActivity
import com.kuvuni.appcursoandroid.R

class GridViewExampleActivity : BaseActivity() {
    override fun getLayoutResource() = R.layout.activity_grid_view_example

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val gridView = findViewById<GridView>(R.id.grid_view_example)

        val data = (1..20).map { "Elemento $it" }

        val adapter = ArrayAdapter(this, R.layout.item_scroll_example, R.id.item_text, data)
        gridView.adapter = adapter
    }
}
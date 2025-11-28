package com.kuvuni.appcursoandroid.components.examples

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.kuvuni.appcursoandroid.BaseActivity
import com.kuvuni.appcursoandroid.R

class ListViewExampleActivity : BaseActivity() {
    override fun getLayoutResource() = R.layout.activity_list_view_example

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val listView = findViewById<ListView>(R.id.list_view_example)

        val data = (1..20).map { "Elemento $it" }

        val adapter = ArrayAdapter(this, R.layout.item_scroll_example, R.id.item_text, data)
        listView.adapter = adapter
    }
}
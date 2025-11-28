package com.kuvuni.appcursoandroid.components.examples

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.kuvuni.appcursoandroid.BaseActivity
import com.kuvuni.appcursoandroid.R

class SpinnerExampleActivity : BaseActivity() {
    override fun getLayoutResource() = R.layout.activity_spinner_example

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textView = findViewById<TextView>(R.id.textView)
        val spinner = findViewById<Spinner>(R.id.simple_spinner)

        val items = listOf("Selecciona una opción", "Opción 1", "Opción 2", "Opción 3")

        // Custom adapter to disable and style the first item (the hint)
        val adapter = object : ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items) {
            override fun isEnabled(position: Int): Boolean {
                // Disable the first item
                return position != 0
            }

            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getDropDownView(position, convertView, parent) as TextView
                if (position == 0) {
                    // Set the hint text color to grey
                    view.setTextColor(ContextCompat.getColor(context, android.R.color.darker_gray))
                } else {
                    // Set the regular text color
                    view.setTextColor(ContextCompat.getColor(context, android.R.color.black))
                }
                return view
            }

            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = super.getView(position, convertView, parent) as TextView
                if (position == 0) {
                    // Set the hint text color for the selected item
                    view.setTextColor(ContextCompat.getColor(context, android.R.color.darker_gray))
                } else {
                    view.setTextColor(ContextCompat.getColor(context, android.R.color.black))
                }
                return view
            }
        }

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                if (position > 0) {
                    textView.text = "Seleccionado: ${items[position]}"
                } else {
                    textView.text = "Ejemplo Práctico"
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // No hacer nada
            }
        }
    }
}
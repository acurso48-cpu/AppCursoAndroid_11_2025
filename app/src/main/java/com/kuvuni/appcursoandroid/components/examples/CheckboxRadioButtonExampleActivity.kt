package com.kuvuni.appcursoandroid.components.examples

import android.os.Bundle
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.TextView
import com.kuvuni.appcursoandroid.BaseActivity
import com.kuvuni.appcursoandroid.R

class CheckboxRadioButtonExampleActivity : BaseActivity() {
    override fun getLayoutResource() = R.layout.activity_checkbox_radiobutton_example

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val textView = findViewById<TextView>(R.id.titleTextView)
        val checkBox = findViewById<CheckBox>(R.id.checkbox)
        val radioGroup = findViewById<RadioGroup>(R.id.radio_group)

        checkBox.setOnCheckedChangeListener { _, isChecked ->
            textView.text = if (isChecked) "CheckBox marcado" else "CheckBox desmarcado"
        }

        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val selectedOption = when (checkedId) {
                R.id.radio_button1 -> "Opción 1 seleccionada"
                R.id.radio_button2 -> "Opción 2 seleccionada"
                else -> ""
            }
            textView.text = selectedOption
        }
    }
}
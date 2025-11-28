package com.kuvuni.appcursoandroid.fragments

import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.kuvuni.appcursoandroid.BaseActivity
import com.kuvuni.appcursoandroid.R

class FragmentsActivity : BaseActivity() {
    override fun getLayoutResource() = R.layout.activity_fragments

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            // Cargar el primer fragment por defecto
            replaceFragment(FragmentA())
        }

        findViewById<Button>(R.id.btn_fragment_a).setOnClickListener {
            replaceFragment(FragmentA())
        }

        findViewById<Button>(R.id.btn_fragment_b).setOnClickListener {
            replaceFragment(FragmentB())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
package com.kuvuni.appcursoandroid.navigation.examples

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.kuvuni.appcursoandroid.BaseActivity
import com.kuvuni.appcursoandroid.R

class NavigationFirstActivity : BaseActivity() {
    override fun getLayoutResource() = R.layout.activity_navigation_first

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        findViewById<Button>(R.id.btn_navigate_to_second).setOnClickListener {
            startActivity(Intent(this, NavigationSecondActivity::class.java))
        }
    }
}
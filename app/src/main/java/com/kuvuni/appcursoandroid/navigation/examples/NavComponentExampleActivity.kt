package com.kuvuni.appcursoandroid.navigation.examples

import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.kuvuni.appcursoandroid.BaseActivity
import com.kuvuni.appcursoandroid.R

class NavComponentExampleActivity : BaseActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun getLayoutResource() = R.layout.activity_nav_component_example

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
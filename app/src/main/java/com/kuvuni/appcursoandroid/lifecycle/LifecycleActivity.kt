package com.kuvuni.appcursoandroid.lifecycle

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.TextView
import com.kuvuni.appcursoandroid.BaseActivity
import com.kuvuni.appcursoandroid.R

class LifecycleActivity : BaseActivity() {

    private val TAG = "LifecycleActivity"
    private lateinit var logTextView: TextView

    override fun getLayoutResource() = R.layout.activity_lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logTextView = findViewById(R.id.lifecycle_log_textview)
        logTextView.movementMethod = ScrollingMovementMethod() // Para que el TextView sea desplazable

        if (savedInstanceState == null) {
            addLog("onCreate()\t- La activity se crea por primera vez.")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        addLog("onSaveInstanceState()\t- Se guarda el estado de la app.")
        outState.putString("lifecycle_log", logTextView.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        logTextView.text = savedInstanceState.getString("lifecycle_log")
        addLog("onRestoreInstanceState()\t- Se restaura el estado de la app.")
    }

    override fun onStart() {
        super.onStart()
        addLog("onStart()\t- La activity está a punto de hacerse visible.")
    }

    override fun onResume() {
        super.onResume()
        addLog("onResume()\t- La activity es visible y está en primer plano.")
    }

    override fun onPause() {
        super.onPause()
        addLog("onPause()\t- La activity está a punto de pasar a segundo plano.")
    }

    override fun onStop() {
        super.onStop()
        addLog("onStop()\t- La activity ya no es visible.")
    }

    override fun onRestart() {
        super.onRestart()
        addLog("onRestart()\t- La activity vuelve a estar en primer plano después de estar detenida.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()\t- La activity está a punto de ser destruida.")
    }

    private fun addLog(message: String) {
        val currentLog = logTextView.text.toString()
        logTextView.text = if (currentLog.isEmpty()) message else "$currentLog\n$message"
        Log.d(TAG, message)
    }
}
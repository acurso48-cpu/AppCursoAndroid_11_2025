package com.kuvuni.appcursoandroid.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.kuvuni.appcursoandroid.BaseActivity
import com.kuvuni.appcursoandroid.R

class NotificationsActivity : BaseActivity() {

    private val CHANNEL_ID = "example_channel"

    override fun getLayoutResource() = R.layout.activity_notifications

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        createNotificationChannel()

        findViewById<Button>(R.id.btn_show_notification).setOnClickListener {
            showTestNotification()
        }
    }

    private fun createNotificationChannel() {
        // Crear el NotificationChannel solo en API 26+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Canal de Ejemplo"
            val descriptionText = "Este es un canal para notificaciones de ejemplo."
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            // Registrar el canal en el sistema
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun showTestNotification() {
        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.ic_notification_overlay)
            .setContentTitle("Notificación de Prueba")
            .setContentText("¡Hola! Esta es una notificación de ejemplo.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)

        with(NotificationManagerCompat.from(this)) {
            // notificationId es un ID único para cada notificación que publicas
            notify(1, builder.build())
        }
    }
}
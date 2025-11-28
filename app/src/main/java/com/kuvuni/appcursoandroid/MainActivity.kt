package com.kuvuni.appcursoandroid

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kuvuni.appcursoandroid.apis.ApisActivity
import com.kuvuni.appcursoandroid.components.ComponentsActivity
import com.kuvuni.appcursoandroid.fragments.FragmentsActivity
import com.kuvuni.appcursoandroid.layouts.LayoutsActivity
import com.kuvuni.appcursoandroid.lifecycle.LifecycleActivity
import com.kuvuni.appcursoandroid.navigation.NavigationActivity
import com.kuvuni.appcursoandroid.notifications.NotificationsActivity
import com.kuvuni.appcursoandroid.permissions.PermissionsActivity
import com.kuvuni.appcursoandroid.persistence.PersistenceActivity
import com.kuvuni.appcursoandroid.recyclerview.RecyclerViewActivity

data class MainMenuItem(val title: String, val iconResId: Int, val activityClass: Class<*>)

class MainActivity : BaseActivity() {
    override fun getLayoutResource() = R.layout.activity_main
    override val showUpButton = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView = findViewById<RecyclerView>(R.id.main_menu_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 columnas

        val menuItems = listOf(
            MainMenuItem("Layouts", android.R.drawable.ic_menu_gallery, LayoutsActivity::class.java),
            MainMenuItem("Components", android.R.drawable.ic_menu_manage, ComponentsActivity::class.java),
            MainMenuItem("Lifecycle", android.R.drawable.ic_menu_rotate, LifecycleActivity::class.java),
            MainMenuItem("Navigation", android.R.drawable.ic_menu_directions, NavigationActivity::class.java),
            MainMenuItem("RecyclerView", android.R.drawable.ic_menu_sort_by_size, RecyclerViewActivity::class.java),
            MainMenuItem("Persistence", android.R.drawable.ic_menu_save, PersistenceActivity::class.java),
            MainMenuItem("APIs", android.R.drawable.ic_menu_share, ApisActivity::class.java),
            MainMenuItem("Permissions", android.R.drawable.ic_lock_lock, PermissionsActivity::class.java),
            MainMenuItem("Notifications", android.R.drawable.ic_notification_overlay, NotificationsActivity::class.java),
            MainMenuItem("Fragments", android.R.drawable.ic_input_get, FragmentsActivity::class.java)
        )

        recyclerView.adapter = MainMenuAdapter(menuItems)
    }
}

class MainMenuAdapter(private val menuItems: List<MainMenuItem>) : RecyclerView.Adapter<MainMenuAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.menu_item_icon)
        val title: TextView = view.findViewById(R.id.menu_item_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_main_menu, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = menuItems[position]
        holder.icon.setImageResource(item.iconResId)
        holder.title.text = item.title

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, item.activityClass)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = menuItems.size
}

package com.kuvuni.appcursoandroid.components

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kuvuni.appcursoandroid.BaseActivity
import com.kuvuni.appcursoandroid.R
import com.kuvuni.appcursoandroid.components.examples.*

data class ComponentMenuItem(val title: String, val iconResId: Int, val activityClass: Class<*>)

class ComponentsActivity : BaseActivity() {
    override fun getLayoutResource() = R.layout.activity_components

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView = findViewById<RecyclerView>(R.id.components_menu_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 columnas

        val menuItems = listOf(
            ComponentMenuItem("TextView", R.drawable.ic_components_textview, TextViewExampleActivity::class.java),
            ComponentMenuItem("EditText", R.drawable.ic_components_edittext, EditTextExampleActivity::class.java),
            ComponentMenuItem("Button", R.drawable.ic_components_button, ButtonExampleActivity::class.java),
            ComponentMenuItem("ImageView", R.drawable.ic_components_imageview, ImageViewExampleActivity::class.java),
            ComponentMenuItem("CheckBox & RadioButton", R.drawable.ic_components_checkbox, CheckboxRadioButtonExampleActivity::class.java),
            ComponentMenuItem("Switch", R.drawable.ic_components_switch, SwitchExampleActivity::class.java),
            ComponentMenuItem("Spinner", R.drawable.ic_components_spinner, SpinnerExampleActivity::class.java),
            ComponentMenuItem("ScrollView", R.drawable.ic_components_scroll, ScrollExampleActivity::class.java),
            ComponentMenuItem("ListView", R.drawable.ic_components_listview, ListViewExampleActivity::class.java),
            ComponentMenuItem("GridView", R.drawable.ic_components_gridview, GridViewExampleActivity::class.java)
        )

        recyclerView.adapter = ComponentsMenuAdapter(menuItems)
    }
}

class ComponentsMenuAdapter(private val menuItems: List<ComponentMenuItem>) : RecyclerView.Adapter<ComponentsMenuAdapter.ViewHolder>() {

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

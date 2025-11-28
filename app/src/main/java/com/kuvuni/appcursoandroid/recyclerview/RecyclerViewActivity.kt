package com.kuvuni.appcursoandroid.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kuvuni.appcursoandroid.BaseActivity
import com.kuvuni.appcursoandroid.R

data class ExampleItem(val title: String, val iconResId: Int)

class RecyclerViewActivity : BaseActivity() {
    override fun getLayoutResource() = R.layout.activity_recycler_view

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_main_example)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val items = listOf(
            ExampleItem("Ejemplo 1", R.drawable.ic_components_button),
            ExampleItem("Ejemplo 2", R.drawable.ic_components_imageview),
            ExampleItem("Ejemplo 3", R.drawable.ic_components_scroll),
            ExampleItem("Ejemplo 4", R.drawable.ic_intents),
            ExampleItem("Ejemplo 5", R.drawable.ic_layouts_grid),
            ExampleItem("Ejemplo 6", R.drawable.ic_hardware),
            ExampleItem("Ejemplo 7", R.drawable.ic_testing),
            ExampleItem("Ejemplo 8", android.R.drawable.ic_notification_overlay)
        )

        recyclerView.adapter = ExampleAdapter(items)
    }
}

class ExampleAdapter(private val items: List<ExampleItem>) : RecyclerView.Adapter<ExampleAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.item_title)
        val icon: ImageView = view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.icon.setImageResource(item.iconResId)
    }

    override fun getItemCount() = items.size
}

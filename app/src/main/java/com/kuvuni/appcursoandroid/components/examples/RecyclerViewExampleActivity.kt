package com.kuvuni.appcursoandroid.components.examples

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kuvuni.appcursoandroid.BaseActivity
import com.kuvuni.appcursoandroid.R

data class RecyclerViewItem(val title: String, val imageResId: Int)

class RecyclerViewExampleActivity : BaseActivity() {
    override fun getLayoutResource() = R.layout.activity_recycler_view_example

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_example)
        val data = (1..20).map { RecyclerViewItem("Elemento $it", R.drawable.ic_components_recyclerview) }

        recyclerView.adapter = RecyclerViewExampleAdapter(data)

        // Iniciar con un LinearLayoutManager por defecto
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Botones para cambiar el LayoutManager
        findViewById<Button>(R.id.btn_linear_layout_manager).setOnClickListener {
            recyclerView.layoutManager = LinearLayoutManager(this)
        }

        findViewById<Button>(R.id.btn_grid_layout_manager).setOnClickListener {
            recyclerView.layoutManager = GridLayoutManager(this, 3)
        }
    }
}

class RecyclerViewExampleAdapter(private val data: List<RecyclerViewItem>) : RecyclerView.Adapter<RecyclerViewExampleAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.titleTextView.text = data[position].title
        holder.imageView.setImageResource(data[position].imageResId)
    }

    override fun getItemCount() = data.size
}

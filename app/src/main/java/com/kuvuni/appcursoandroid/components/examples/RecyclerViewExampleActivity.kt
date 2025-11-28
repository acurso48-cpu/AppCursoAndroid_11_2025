package com.kuvuni.appcursoandroid.components.examples

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

data class RecyclerViewItem(val title: String, val imageResId: Int)

class RecyclerViewExampleActivity : BaseActivity() {
    override fun getLayoutResource() = R.layout.activity_recycler_view_example

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_example)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val data = listOf(
            RecyclerViewItem("Elemento 1", R.mipmap.ic_launcher_round),
            RecyclerViewItem("Elemento 2", R.mipmap.ic_launcher_round),
            RecyclerViewItem("Elemento 3", R.mipmap.ic_launcher_round),
            RecyclerViewItem("Elemento 4", R.mipmap.ic_launcher_round),
            RecyclerViewItem("Elemento 5", R.mipmap.ic_launcher_round),
            RecyclerViewItem("Elemento 6", R.mipmap.ic_launcher_round),
            RecyclerViewItem("Elemento 7", R.mipmap.ic_launcher_round),
            RecyclerViewItem("Elemento 8", R.mipmap.ic_launcher_round)
        )

        recyclerView.adapter = RecyclerViewExampleAdapter(data)
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

package com.kuvuni.appcursoandroid.components.examples

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kuvuni.appcursoandroid.BaseActivity
import com.kuvuni.appcursoandroid.R

class ScrollExampleActivity : BaseActivity() {
    override fun getLayoutResource() = R.layout.activity_scroll_example

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView = findViewById<RecyclerView>(R.id.vertical_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Creamos una lista de 20 items para asegurarnos de que el contenido es desplazable
        val data = (1..20).map { "Item $it" }
        recyclerView.adapter = ScrollExampleAdapter(data)
    }
}

class ScrollExampleAdapter(private val data: List<String>) : RecyclerView.Adapter<ScrollExampleAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_scroll_example, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = data[position]
    }

    override fun getItemCount() = data.size
}

package com.kuvuni.appcursoandroid.layouts

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
import com.kuvuni.appcursoandroid.layouts.examples.*

data class LayoutMenuItem(val title: String, val iconResId: Int, val activityClass: Class<*>)

class LayoutsActivity : BaseActivity() {
    override fun getLayoutResource() = R.layout.activity_layouts

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView = findViewById<RecyclerView>(R.id.layouts_menu_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 columnas

        val menuItems = listOf(
            LayoutMenuItem("LinearLayout", R.drawable.ic_layouts_linear, LinearLayoutExampleActivity::class.java),
            LayoutMenuItem("ConstraintLayout", R.drawable.ic_layouts_constraint, ConstraintLayoutExampleActivity::class.java),
            LayoutMenuItem("RelativeLayout", R.drawable.ic_layouts_relative, RelativeLayoutExampleActivity::class.java),
            LayoutMenuItem("FrameLayout", R.drawable.ic_layouts_frame, FrameLayoutExampleActivity::class.java),
            LayoutMenuItem("TableLayout", R.drawable.ic_layouts_table, TableLayoutExampleActivity::class.java),
            LayoutMenuItem("GridLayout", R.drawable.ic_layouts_grid, GridLayoutExampleActivity::class.java),
            LayoutMenuItem("CoordinatorLayout", R.drawable.ic_layouts_coordinator, CoordinatorLayoutExampleActivity::class.java),
            LayoutMenuItem("MotionLayout", R.drawable.ic_layouts_motion, MotionLayoutExampleActivity::class.java)
        )

        recyclerView.adapter = LayoutsMenuAdapter(menuItems)
    }
}

class LayoutsMenuAdapter(private val menuItems: List<LayoutMenuItem>) : RecyclerView.Adapter<LayoutsMenuAdapter.ViewHolder>() {

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

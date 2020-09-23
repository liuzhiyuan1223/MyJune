package com.june.component_recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.june.R
import org.w3c.dom.Text

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val itemTv: TextView
    init {
        itemTv = itemView.findViewById<TextView>(R.id.item_tv)
    }
}
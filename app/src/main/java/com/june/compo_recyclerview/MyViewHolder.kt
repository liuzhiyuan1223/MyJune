package com.june.compo_recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.june.R

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val itemTv: TextView
    init {
        itemTv = itemView.findViewById<TextView>(R.id.item_tv)
    }
}
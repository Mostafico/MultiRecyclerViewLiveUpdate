package com.devgeeks.multirecyclerviewliveupdate

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OrderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setOrderID(id: String){
        itemView.findViewById<TextView>(R.id.tvStatus).text = id
    }
}
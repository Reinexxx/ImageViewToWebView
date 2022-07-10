package com.example.imageviewtowebview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    val dataList = mutableListOf<ItemData>()

    private lateinit var listener: OnImageClickListener

    interface OnImageClickListener {
        fun onItemClick(data: ItemData)
    }

    fun setOnImageClickListener(listener: OnImageClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cell, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.imageBtn.setImageResource(dataList[position].image)
        holder.imageBtn.setOnClickListener {
            listener.onItemClick(dataList[position])
        }
        holder.titleText.setOnClickListener {
            holder.titleText.text = "TEXT"
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun addData(data: List<ItemData>) {
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()
    }

    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageBtn: ImageButton = itemView.findViewById(R.id.ib_item_btn)
        val titleText: TextView = itemView.findViewById(R.id.tv_title)
    }

}
package com.example.project_001

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListStreamerAdapter(private val listStreamer: ArrayList<Streamer>) : RecyclerView.Adapter<ListStreamerAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgLayout: ImageView = itemView.findViewById(R.id.tv_layout)
        val tvName: TextView = itemView.findViewById(R.id.tv_streamer_name)
        val tvDsc:TextView = itemView.findViewById(R.id.tv_streamer_desc)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_streamer, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int =listStreamer.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, image) = listStreamer[position]
        holder.imgLayout.setBackgroundResource(image)
        holder.tvName.text = name
        holder.tvDsc.text = description
//        holder.imgPhoto.setImageResource(photo)
//        holder.tvName.text = name
//        holder.tvDescription.text = description
    }

}
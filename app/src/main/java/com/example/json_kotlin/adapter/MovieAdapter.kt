package com.example.json_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.json_kotlin.R
import com.example.json_kotlin.model.TopMovie

class MovieAdapter(val results: ArrayList<TopMovie>
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        val binding =
        LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView
    }

    override fun getItemCount() = results.size

    class ViewHolder (val view: View) : RecyclerView.ViewHolder(view)

}
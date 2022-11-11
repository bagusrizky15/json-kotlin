package com.example.json_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.json_kotlin.R
import com.example.json_kotlin.databinding.ItemMoviesBinding
import com.example.json_kotlin.model.ResponseModel
import okhttp3.internal.notify

class MovieAdapter (val data: ArrayList<ResponseModel.Movies>, val context: Context) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemMoviesBinding.bind(view)
        val tvTitle = binding.tvTitle
        val tvDesc = binding.tvDesc

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = data[position].title
        holder.tvDesc.text = data[position].overview

    }

    override fun getItemCount(): Int = data.size

    fun setData(data: ArrayList<ResponseModel.Movies>){
        data.clear()
        data.addAll(data)
        notifyDataSetChanged()
    }

}
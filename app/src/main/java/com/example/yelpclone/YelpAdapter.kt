package com.example.yelpclone

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_restaurant.view.*

class YelpAdapter(private val context: Context, private val data: List<YelpRes>) : RecyclerView.Adapter<YelpAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_restaurant,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val restaurant = data[position]
        holder.bind(restaurant)
    }

    override fun getItemCount() = data.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(restaurant: YelpRes) {
           itemView.tvName.text = restaurant.name

        }
    }

}

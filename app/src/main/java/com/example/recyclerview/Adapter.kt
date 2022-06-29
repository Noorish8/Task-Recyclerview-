package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adapter (val context: Context, val list: List<Model>):RecyclerView.Adapter<Adapter.ViewHolder>(){

    class ViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        val textView1: TextView = itemView.findViewById(R.id.txt_name)
        val image1: ImageView = itemView.findViewById(R.id.img)

//        fun bind(modal: Model){
//
//            image1.setImageResource(modal.img)
//
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView1.text = list.get(position).name.toString()
        Glide.with(context)
            .load(list.get(position).image)
            .into(holder.image1)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
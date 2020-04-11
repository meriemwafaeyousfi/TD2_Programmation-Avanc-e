package com.example.td4_exo3_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.example_item.view.*

class ExempleAdapter (private var examplelist: List<ExampleItem>/*, var onTaskListner : OnTaskListner*/): RecyclerView.Adapter <ExempleAdapter.ExampleViewHolder>() {

    class ExampleViewHolder (itemView: View/*, var ontasklistner : OnTaskListner*/) : RecyclerView.ViewHolder(itemView)/*, View.OnClickListener*/{
        val imageView : ImageView = itemView.image_view
        val textView : TextView = itemView.text_view
        val textViewDate : TextView = itemView.text_view_2
/*
        init {
            itemView.setOnClickListener(this)

        }
        override fun onClick(v: View?){
            ontasklistner.onTaskClick(adapterPosition)
        }*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_item,
            parent, false)

        return ExampleViewHolder(itemView/*, onTaskListner*/)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        val currentitem = examplelist[position]

        holder.imageView.setImageResource(currentitem.imageResource)
        holder.textView.text = currentitem.text
        holder.textViewDate.text = currentitem.date

    }

    override fun getItemCount() = examplelist.size
/*    public interface OnTaskListner{
        fun onTaskClick(position : Int)
    }*/

}


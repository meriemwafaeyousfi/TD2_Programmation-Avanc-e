package com.example.exo4

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.exo5.Mot
import com.example.exo5.MotActivity
import com.example.exo5.R

import kotlinx.android.synthetic.main.list_item.view.*

class MotAdapter(val context : Context,val mots :  MutableList<Mot>) : RecyclerView.Adapter<MotAdapter.MyViewHolder>(){
    inner class MyViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

        var currentMot :   Mot ? = null
        var currentPos : Int =0

        init {
            itemView.setOnClickListener{
                val intent = Intent(context, MotActivity()::class.java)
                intent.putExtra("motDef",currentMot!!.definition)
                intent.putExtra("mot",currentMot!!.mot)
                intent.putExtra("motImg",currentMot!!.image)
                intent.putExtra("vocal",currentMot!!.vocal)
                intent.putExtra("videoMot",currentMot!!.video)
                context.startActivity(intent)
            }


        }
        fun setData(mot :Mot?, pos : Int){
            itemView.def.text= mot!!.mot
           // itemView.img =mot!!.image
            this.currentMot= mot
            this.currentPos = pos
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(context).inflate(R.layout.list_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  mots.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val mot = mots[position]
        holder.setData(mot,position)
    }
}
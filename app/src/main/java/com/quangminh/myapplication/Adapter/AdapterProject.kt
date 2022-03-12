package com.quangminh.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.quangminh.myapplication.R

class AdapterProject(var workList : List<String>) : RecyclerView.Adapter<AdapterProject.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterProject.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_project, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return workList.size
    }

    override fun onBindViewHolder(holder: AdapterProject.ViewHolder, position: Int) {
        var work : String = workList[position]

        holder.text1.setText(work)
    }

    inner class ViewHolder(itemview : View): RecyclerView.ViewHolder(itemview){
        lateinit var carView : CardView
        lateinit var text1 : TextView
        init {
            carView = itemview.findViewById(R.id.cardView)
            carView.background = null

            text1 = itemview.findViewById(R.id.work)
        }

    }
}
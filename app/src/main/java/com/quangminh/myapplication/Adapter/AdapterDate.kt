package com.quangminh.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.quangminh.myapplication.R
import java.sql.Array
import java.util.zip.Inflater

class AdapterDate( var dateList : ArrayList<String>, var weekDay : ArrayList<Int>) : RecyclerView.Adapter<AdapterDate.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_date, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {

        return dateList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //get ngày từ list
        var currentItem = dateList[position]
        holder.dayInMonth.setText(currentItem)
        //chyển đổi thứ từ list
        var currentItem2 = weekDay[position].toString()
        if (currentItem2.equals("1")){
            currentItem2 = "CN"
        }

        if(currentItem2.equals("CN")){
            holder.weekdays.setText("CN")
        }else{
            holder.weekdays.setText("T" + currentItem2)
        }

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        lateinit var weekdays : TextView
        lateinit var dayInMonth : TextView

        init {
            //ánh xạ view
            weekdays = itemView.findViewById(R.id.week_day)
            dayInMonth = itemView.findViewById(R.id.day_of_month)
        }
    }
}
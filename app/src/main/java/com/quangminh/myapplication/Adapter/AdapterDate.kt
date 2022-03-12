package com.quangminh.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.quangminh.myapplication.R

class AdapterDate( var dateList : ArrayList<String>, var weekDay : ArrayList<Int>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType==0){
            val v: View = LayoutInflater.from(parent.context).inflate(R.layout.layout_date, parent, false)
            return ViewHolder1(v)
        }else {
            val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_date_week, parent, false)
            return ViewHolder2(v)
        }
    }

    override fun getItemCount(): Int {
        return dateList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder.itemViewType==0){
            (holder as ViewHolder1).bind(dateList[position], weekDay[position])
        }else if (holder.itemViewType==1){
            (holder as ViewHolder2).bind(dateList[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        if(dateList.size>7){
            return 0
        }
        return 1
    }

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//
//        var v: View = LayoutInflater.from(parent.context).inflate(R.layout.layout_date, parent, false)
//        if (viewType==0){
//            return ViewHolder(v)
//        }else if (viewType==1){
//            v = LayoutInflater.from(parent.context).inflate(R.layout.layout_date_week, parent, false)
//            return ViewHolder(v)
//        }
//
//        return ViewHolder(v)
//    }
//
//    override fun getItemCount(): Int {
//
//        return dateList.size
//    }
//
//
//    override fun getItemViewType(position: Int): Int {
//        if(dateList.size>7){
//            return 0
//        }
//        return 1
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//
//        if (holder.itemViewType==0){
//            //get ngày từ list
//            var currentItem = dateList[position]
//            holder.dayInMonth.setText(currentItem)
//            //chyển đổi thứ từ list
//            var currentItem2 = weekDay[position].toString()
//            if (currentItem2.equals("1")){
//                currentItem2 = "CN"
//            }
//
//            if(currentItem2.equals("CN")){
//                holder.weekdays.setText("CN")
//            }else{
//                holder.weekdays.setText("T" + currentItem2)
//            }
//        }else if (holder.itemViewType==1){
//            var currentItem3 = dateList[position]
//        }
//
//
//
//    }
//
    inner class ViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView){
        lateinit var weekdays : TextView
        lateinit var dayInMonth : TextView

        init {
            //ánh xạ view
            weekdays = itemView.findViewById(R.id.week_day)
            dayInMonth = itemView.findViewById(R.id.day_of_month)


        }
        fun bind(date: String, weekDay: Int) {
            dayInMonth.setText(date)
            if(weekDay.toString().equals("1")){
                weekdays.setText("CNn")
            }else{
                weekdays.text="T"+weekDay
            }
        }
    }

    inner class ViewHolder2(itemView: View): RecyclerView.ViewHolder(itemView){
        lateinit var dayOfWeek : TextView
        init {
            dayOfWeek = itemView.findViewById(R.id.weekOd)


        }
        fun bind(dateList: String) {
            dayOfWeek.text = dateList
        }
    }
}
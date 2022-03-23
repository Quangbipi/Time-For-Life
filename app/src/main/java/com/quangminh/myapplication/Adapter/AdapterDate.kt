package com.quangminh.myapplication.Adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.DashPathEffect
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.quangminh.myapplication.Interface.DayOnClick
import com.quangminh.myapplication.R
import com.quangminh.myapplication.StaticClass
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.Map as Map1

class AdapterDate( var dateList : ArrayList<String>, var weekDay : ArrayList<Int>, val listener : DayOnClick,  var itemViewType : Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var map : HashMap<Int, Boolean>
    var mapClick : HashMap<Int, Boolean>

    init {
        map = HashMap<Int, Boolean>()
        for(i in 0..dateList.size-1){
            map.put(i, false)
            map.toSortedMap()
            Log.d("Map", "All keys: ${map.keys}")
        }

        mapClick = HashMap<Int, Boolean>()
    }
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

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)  {
        if (holder.itemViewType==0){

            (holder as ViewHolder1).bind(dateList[position], weekDay[position])

            var cal = Calendar.getInstance()
            var today = cal.get(Calendar.DATE)

                //Viết hàm check nếu map [i] = true thì đổi màu click và ngược lại
            map.replace(today-2, true)
            if(map[position]==true){
                Log.d("ii", "key: $position, value: ${map[position]}")
                holder.cardD.setCardBackgroundColor(Color.parseColor(StaticClass.COLOR_CLICK))
                holder.dayInMonth.setTextColor(Color.parseColor(StaticClass.COLOR_MAIN))
                holder.weekdays. setTextColor(Color.parseColor(StaticClass.COLOR_MAIN))
            }else{
                holder.cardD.setCardBackgroundColor(Color.parseColor(StaticClass.COLOR_UNCLICK));
                holder.dayInMonth.setTextColor(Color.parseColor(StaticClass.COLOR_TEXT_UNCLICK))
                holder.weekdays. setTextColor(Color.parseColor(StaticClass.COLOR_TEXT_UNCLICK))
            }

                //holder.cardD.setCardBackgroundColor(Color.parseColor(StaticClass.COLOR_CLICK));
                //Log.d("Map", "All keys: ${map.keys}, ${map.values}")



            holder.itemView.setOnClickListener {
                listener.onItemClick(position)
                map.forEach { i, b ->
                    map[i] = false
                    //holder.cardD.setCardBackgroundColor(Color.parseColor(StaticClass.COLOR_UNCLICK));
                }
                //set value cho map
                map.replace(position, true)

                notifyDataSetChanged()
            }

        }else if (holder.itemViewType==1){

            (holder as ViewHolder2).bind(dateList[position])


            if(mapClick[position]==true){
                Log.d("ii", "key: $position, value: ${mapClick[position]}")
                holder.dayOfWeek.setTextColor(Color.parseColor(StaticClass.COLOR_MAIN))
            }else if(map[position]==false){
                holder.dayOfWeek.setTextColor(Color.parseColor(StaticClass.COLOR_TEXT_UNCLICK))
            }

            holder.itemView.setOnClickListener {
                listener.onItemClick(position)
                //set tất cả gái trị ,ap = false
                map.forEach { i, b ->
                    map[i] = false

                    //holder.cardD.setCardBackgroundColor(Color.parseColor(StaticClass.COLOR_UNCLICK));
                }
                //set value cho map
                map.replace(position, true)

                if(mapClick.containsKey(position)){
                    mapClick.remove(position)
                }else{
                    mapClick.put(position, true)
                }


                notifyDataSetChanged()
            }
        }else if(holder.itemViewType == 2){
            (holder as ViewHolder2).bind(dateList[position])
            holder.dayOfWeek.setTextColor(Color.parseColor(StaticClass.COLOR_MAIN))
        }
    }

//    private fun Today(): Boolean {
//        var cal: Calendar = Calendar.getInstance()
//        var today : Int = cal.get(Calendar.DAY_OF_MONTH)
//        if()
//        return false
//    }


    //set item view type
    override fun getItemViewType(position: Int): Int {
        if(itemViewType==0){
            return 0
        }else if(itemViewType==1){
            return 1
        }
        return 2

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
    inner class ViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        var weekdays : TextView
        var dayInMonth : TextView
        var cardD: CardView

        init {
            //ánh xạ view
            weekdays = itemView.findViewById(R.id.week_day)
            dayInMonth = itemView.findViewById(R.id.day_of_month)
            cardD = itemView.findViewById(R.id.cardDate)
            itemView.setOnClickListener { this }
        }

        fun bind(date: String, weekDay: Int) {

            dayInMonth.setText(date)

            if(weekDay.toString().equals("1")){
                weekdays.setText("CN")
                weekdays.setTextColor(Color.RED)
            }else{
                weekdays.text="T"+weekDay
            }


        }
        override fun onClick(p0: View?) {

//        val position : Int = layoutPosition
//        if(position != RecyclerView.NO_POSITION) {
//            listener.onItemClick(position)
//        }


        }



}

    inner class ViewHolder2(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        lateinit var dayOfWeek : TextView
        init {
            dayOfWeek = itemView.findViewById(R.id.weekOd)

        }
        fun bind(dateList: String) {
            dayOfWeek.text = dateList
            if (dateList.equals("CN")){
                dayOfWeek.setTextColor(Color.RED)
            }
        }

        override fun onClick(p0: View?) {

        }
    }


}



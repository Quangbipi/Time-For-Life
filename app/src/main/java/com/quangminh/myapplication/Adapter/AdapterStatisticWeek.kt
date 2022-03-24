package com.quangminh.myapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.quangminh.myapplication.R
import com.quangminh.myapplication.model.ModelWeekTest

class AdapterStatisticWeek (var listModelWeekTest: ArrayList<ModelWeekTest>) : RecyclerView.Adapter<AdapterStatisticWeek.WeekViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_week, parent, false)
        return WeekViewHolder(v)
    }

    override fun getItemCount(): Int {
        return listModelWeekTest.size
    }

    override fun onBindViewHolder(holder: WeekViewHolder, position: Int) {
        (holder as WeekViewHolder).bind(listModelWeekTest[position])

    }

    inner class WeekViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        lateinit var  week: TextView
        lateinit var score : TextView
        lateinit var complete : TextView
        lateinit var failed : TextView
        lateinit var totalPj: TextView

        init {
            week = itemView.findViewById(R.id.tvWeek)
            score = itemView.findViewById(R.id.tvScore)
            complete = itemView.findViewById(R.id.tvComplete)
            failed = itemView.findViewById(R.id.tvFailed)
            totalPj = itemView.findViewById(R.id.tvPj)
        }
        fun bind(modelWeekTest: ModelWeekTest){
            if (listModelWeekTest.size<=5){
                week.setText("Tuần: ${modelWeekTest.week}")
                score.setText("Điểm: ${modelWeekTest.score}")
                complete.setText("Hoàn thành: ${modelWeekTest.complete}")
                failed.setText("Thất bại: ${modelWeekTest.failed}")
                totalPj.setText("Công việc: ${modelWeekTest.total_pj}")
            }else if(listModelWeekTest.size>5){
                week.setText("Tháng: ${modelWeekTest.week}")
                score.setText("Điểm: ${modelWeekTest.score}")
                complete.setText("Hoàn thành: ${modelWeekTest.complete}")
                failed.setText("Thất bại: ${modelWeekTest.failed}")
                totalPj.setText("Công việc: ${modelWeekTest.total_pj}")
            }

        }
    }
}
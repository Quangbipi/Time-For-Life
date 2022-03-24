package com.quangminh.myapplication

import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class GetDate {
    lateinit var listDay : ArrayList<String>
    lateinit var weekDay : ArrayList<Int>
    lateinit var cal : Calendar

    fun getDateOfMont(month : Int) : ArrayList<String>{
        listDay = arrayListOf()

        listDay.clear()

        cal = Calendar.getInstance()
        //set tháng
        cal.set(Calendar.MONTH, month)
        //
        cal.set(Calendar.DAY_OF_MONTH, month)
        // lấy max day của 1 tháng
        var maxDay : Int = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
        //set format cal
        var formater = SimpleDateFormat("dd")

        for(i in 1.. maxDay){
            cal.set(Calendar.DAY_OF_MONTH, i+1)
            listDay.add(formater.format(cal.time))

        }

        return listDay

    }

    fun getWeekOfMont(month : Int) : ArrayList<Int>{

        weekDay = arrayListOf()


        weekDay.clear()

        cal = Calendar.getInstance()
        //set tháng
        cal.set(Calendar.MONTH, month)
        //
        cal.set(Calendar.DAY_OF_MONTH, month)
        // lấy max day của 1 tháng
        var maxDay : Int = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
        //set format cal
        var formater = SimpleDateFormat("dd")

        for(i in 1.. maxDay){
            cal.set(Calendar.DAY_OF_MONTH, i+1)
            weekDay.add(cal.get(Calendar.DAY_OF_WEEK))
        }

        return weekDay
    }
}
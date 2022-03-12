package com.quangminh.myapplication.Fragments

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.quangminh.myapplication.Adapter.AdapterDate
import com.quangminh.myapplication.Adapter.AdapterProject
import com.quangminh.myapplication.AddActivity
import com.quangminh.myapplication.R
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList


class ProjectFragment : Fragment() {
    lateinit var recycleView : RecyclerView
    lateinit var recyclerView2: RecyclerView

    lateinit var monthYear: TextView
    lateinit var add : ImageView
    //khai báo adapter
    lateinit var adapter_date : AdapterDate
    lateinit var adapterProject: AdapterProject

    //khai báo list dl
    lateinit var dayList : ArrayList<String>
    lateinit var weekDayList : ArrayList<Int>
    lateinit var workList: ArrayList<String>

    lateinit var linearLayoutManager: LinearLayoutManager
    lateinit var linearLayoutManager2: LinearLayoutManager
    lateinit var cal : Calendar

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ánh xạ
        var view : View = inflater.inflate(R.layout.fragment_project, container, false)
        anhXa(view)

        // khai báo calendar
        cal = Calendar.getInstance()
        getDateOfMont(cal.get(Calendar.MONTH))

        AddProject()

        //set layoutManager
        setManager()

        //even
        add.setOnClickListener {

            val intent = Intent (context, AddActivity::class.java)
            startActivity(intent)
        }


        return view
    }

    override fun onResume() {
        super.onResume()
        setAdapter()

    }

    private fun anhXa(view: View){
        recycleView = view.findViewById(R.id.rcv_day)
        recyclerView2 = view.findViewById(R.id.rcw_pj)
        add = view.findViewById(R.id.add)
    }

    private fun setManager(){
        linearLayoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        recycleView.layoutManager = linearLayoutManager

        linearLayoutManager2 = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView2.layoutManager = linearLayoutManager2
    }

    private fun setAdapter(){

        adapter_date = AdapterDate(dayList, weekDayList)
        recycleView.adapter = adapter_date
        // adapter của phần hiển thị công việc
        adapterProject = AdapterProject(workList)
        recyclerView2.adapter=adapterProject
    }

    //add ngày và thứ vào array
    @RequiresApi(Build.VERSION_CODES.O)
    fun getDateOfMont(month : Int){

        dayList = arrayListOf()
        weekDayList= arrayListOf()

        dayList.clear()
        weekDayList.clear()

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
            dayList.add(formater.format(cal.time))
            weekDayList.add(cal.get(Calendar.DAY_OF_WEEK))
        }

    }

    fun  AddProject(){
        workList = arrayListOf()
        workList.add("Họp team mobile")
        workList.add("Họp team mobile")
        workList.add("Họp team mobile")
        workList.add("Họp team mobile")
        workList.add("Họp team mobile")
    }
}



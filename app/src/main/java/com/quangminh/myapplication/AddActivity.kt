package com.quangminh.myapplication

import android.app.TimePickerDialog
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.quangminh.myapplication.Adapter.AdapterDate
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class AddActivity : AppCompatActivity() {
    // khao báo view
    lateinit var rcw_day_2: RecyclerView
    lateinit var spiner : Spinner
    lateinit var spiner2 : Spinner
    lateinit var back : ImageButton
    lateinit var timeStart : TextView
    lateinit var timeEnd : TextView
    //khai báo manager
    lateinit var layoutManager: LinearLayoutManager
    //khai báo adapter
    lateinit var adapterDate: AdapterDate
    //khai báo list
    lateinit var listDay : ArrayList<String>
    lateinit var weekDay :ArrayList<Int>
    //khai báo Calender
    lateinit var cal: Calendar

    lateinit var s: String

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        cal = Calendar.getInstance()
        getDateOfMont(cal.get(Calendar.MONTH))

       anhXa()
        setManager()
        setAdapterspiner()

        back.setOnClickListener {
            val inten = Intent(this, MainActivity::class.java)
            startActivity(inten)
        }

        timeStart.setOnClickListener {
            getTimeSE(timeStart)
        }
        timeEnd.setOnClickListener {
            getTimeSE(timeEnd)
        }



        spiner.onItemSelectedListener = object : AdapterView.OnItemClickListener,
            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                var s: String = p2.toString()
                Toast.makeText(this@AddActivity, s+ "111", Toast.LENGTH_SHORT).show()
                if(p2 == 0){
                    adapterDate = AdapterDate(listDay, weekDay)
                    rcw_day_2.adapter = adapterDate
                }else if( p2 == 1){
                    var wd : ArrayList<String> = arrayListOf("T2","T3","T4","T5","T6","T7", "CN" )
                    adapterDate = AdapterDate(wd, weekDay)
                    rcw_day_2.adapter=adapterDate


                }
            }

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

        }





    }

    private fun getTimeSE(time : TextView) {



        val timePickerDialog = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            cal.set(Calendar.MINUTE, minute)
            time.text = SimpleDateFormat("HH:mm").format(cal.time)
        }
        TimePickerDialog(this, timePickerDialog, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()

    }

    private fun anhXa() {
        rcw_day_2 = findViewById(R.id.rcw_day_2)
        spiner = findViewById(R.id.spn_time)
        spiner2 = findViewById(R.id.spiner_minute)
        back = findViewById(R.id.back_setting)
        timeStart = findViewById(R.id.time_start)
        timeEnd = findViewById(R.id.time_end)
    }

    override fun onResume() {
        super.onResume()
        

    }
    
    override fun onStart() {
        super.onStart()

        adapterDate = AdapterDate(listDay, weekDay)
        rcw_day_2.adapter = adapterDate

    }

    private fun setManager(){
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rcw_day_2.layoutManager = layoutManager
    }

    private fun setAdapterspiner(){
        var adapterSpiner : ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this, R.array.spiner_cycle, R.layout.color_spiner)
        adapterSpiner.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spiner.adapter = adapterSpiner

        var adapterSpiner2 : ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this, R.array.spiner_before, R.layout.support_simple_spinner_dropdown_item)

        spiner2.adapter = adapterSpiner2
    }
    //add ngày và thứ vào array
    @RequiresApi(Build.VERSION_CODES.O)
    fun getDateOfMont(month : Int){
        listDay = arrayListOf()
        weekDay = arrayListOf()

        listDay.clear()
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
            listDay.add(formater.format(cal.time))
            weekDay.add(cal.get(Calendar.DAY_OF_WEEK))
        }

    }
}
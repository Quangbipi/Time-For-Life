package com.quangminh.myapplication

import android.app.TimePickerDialog
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.quangminh.myapplication.Adapter.AdapterDate
import com.quangminh.myapplication.Interface.DayOnClick
import java.text.SimpleDateFormat
import java.util.*

class AddActivity : AppCompatActivity(), DayOnClick{
    // khao báo view
    lateinit var rcw_day_2: RecyclerView
    lateinit var spiner : Spinner
    lateinit var spiner2 : Spinner
    lateinit var back : ImageButton
    lateinit var timeStart : TextView
    lateinit var timeEnd : TextView
    lateinit var important : TextView // qtrong
    lateinit var urgency : TextView // kcap
    lateinit var insignificance : TextView // kqtrong
    lateinit var notUrgent: TextView // k kcap
    lateinit var alamTv : TextView
    lateinit var kpiTv : TextView
    lateinit var notifiTv : TextView
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
    var a = true
    var n = true
    var k = true






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        cal = Calendar.getInstance()
        getDateOfMont(cal.get(Calendar.MONTH))

       initView()
        //setManager()
        setAdapterspiner()

        // event click
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

        important.setOnClickListener {
            setBgk(it)
        }
        insignificance.setOnClickListener {
            setBgk(it)
        }
        urgency.setOnClickListener {
            setBgk(it)
        }
        notUrgent.setOnClickListener {
            setBgk(it)
        }

        alamTv.setOnClickListener {
            setDrawableTv(it)
        }
        notifiTv.setOnClickListener {
            setDrawableTv(it)
        }
        kpiTv.setOnClickListener {
            setDrawableTv(it)
        }

        layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        rcw_day_2.layoutManager = layoutManager

        spiner.onItemSelectedListener = object : AdapterView.OnItemClickListener,
            AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

//                var s: String = p2.toString()
                //Toast.makeText(this@AddActivity, s+ "111", Toast.LENGTH_SHORT).show()
                if(p2 == 0){
                    adapterDate = AdapterDate(listDay, weekDay,this@AddActivity, StaticClass.ITEM_VIEW_TYPE_0)
                    rcw_day_2.adapter = adapterDate
                    var cal = Calendar.getInstance()
                    scrollItem(cal.get(Calendar.DATE))
                }else if( p2 == 1){
                    var wd : ArrayList<String> = arrayListOf("T2","T3","T4","T5","T6","T7", "CN" )
                    adapterDate = AdapterDate(wd, weekDay, this@AddActivity, StaticClass.ITEM_VIEW_TYPE_1)
                    rcw_day_2.adapter=adapterDate
                }else{
                    var wd : ArrayList<String> = arrayListOf("T2","T3","T4","T5","T6","T7", "T8" )
                    adapterDate = AdapterDate(wd, weekDay, this@AddActivity, StaticClass.ITEM_VIEW_TYPE_2)
                    rcw_day_2.adapter=adapterDate
                }
            }

            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

            }

        }





    }

    // event Click notifi
    private fun setDrawableTv(it: View?) {
        when(it){
            alamTv->{

                if(a==true){
                    alamTv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_notifi_2, 0 , 0 ,0 )
                    Toast.makeText(this, "Bật chức năng báo thức", Toast.LENGTH_SHORT).show()
                    a=false
                }else if (a==false){
                    alamTv.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_alarm_bl, 0 ,0 ,0 )
                    Toast.makeText(this, "Tắt chức năng báo thức", Toast.LENGTH_SHORT).show()
                    a=true
                }
            }
            notifiTv->{
                if(n==true){
                    notifiTv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_notifi, 0 , 0 ,0 )
                    Toast.makeText(this, "Bật chức năng thông báo", Toast.LENGTH_SHORT).show()
                    n=false
                }else if (n==false){
                    notifiTv.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.ic_notifi_bl, 0 ,0 ,0 )
                    Toast.makeText(this, "Tắt chức năng thông báo", Toast.LENGTH_SHORT).show()
                    n=true
                }
            }
            kpiTv->{
                if(k==true){
                    kpiTv.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_kpi, 0 , 0 ,0 )
                    Toast.makeText(this, "Bật chức năng tính điểm", Toast.LENGTH_SHORT).show()
                    k=false
                }else if (k==false){
                    kpiTv.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.kpi_bl, 0 ,0 ,0 )
                    Toast.makeText(this, "Tắt chức năng tính điểm", Toast.LENGTH_SHORT).show()
                    k=true
                }
            }
        }


    }

    // đổi bgk khi click vào
    private fun setBgk(it: View) {
        if(it == important){
            insignificance.background = getDrawable(R.drawable.custom_bgk_priority_3)
            important.background = getDrawable(R.drawable.custom_bgk_priority_1)
        }else if (it == insignificance){
            insignificance.background = getDrawable(R.drawable.custom_bgk_priority_4)
            important.background = getDrawable(R.drawable.custom_bgk_priority_3)
        }else if (it == urgency){
            urgency.background = getDrawable(R.drawable.custom_bgk_priority_5)
            notUrgent.background = getDrawable(R.drawable.custom_bgk_priority_3)
        }else if (it == notUrgent){
            urgency.background = getDrawable(R.drawable.custom_bgk_priority_3)
            notUrgent.background = getDrawable(R.drawable.custom_bgk_priority_2)
        }
    }

    // Scroll view hiển thị ngày về giữa
    private fun scrollItem(index :Int) {
        layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        Toast.makeText(this, "$index", Toast.LENGTH_SHORT).show()
        if(layoutManager==null){

        }
        (rcw_day_2.layoutManager as LinearLayoutManager).scrollToPositionWithOffset(index -5, 0)

    }

    // Time Picker Dialog
    private fun getTimeSE(time : TextView) {



        val timePickerDialog = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hour)
            cal.set(Calendar.MINUTE, minute)
            time.text = SimpleDateFormat("HH:mm").format(cal.time)
        }
        TimePickerDialog(this, timePickerDialog, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()

    }

    private fun initView() {
        rcw_day_2 = findViewById(R.id.rcw_day_2)
        spiner = findViewById(R.id.spn_time)
        spiner2 = findViewById(R.id.spiner_minute)
        back = findViewById(R.id.back_setting)
        timeStart = findViewById(R.id.time_start)
        timeEnd = findViewById(R.id.time_end)

        important = findViewById(R.id.quan_trong)
        insignificance = findViewById(R.id.kquan_trong)
        urgency = findViewById(R.id.khan_cap)
        notUrgent = findViewById(R.id.kkhan_cap)

        alamTv = findViewById(R.id.alarm_tv)
        kpiTv = findViewById(R.id.kpi_tv)
        notifiTv = findViewById(R.id.notifi_tv)
    }

    override fun onResume() {
        super.onResume()
        

    }
    
    override fun onStart() {
        super.onStart()

        adapterDate = AdapterDate(listDay, weekDay, this, StaticClass.ITEM_VIEW_TYPE_0)
        rcw_day_2.adapter = adapterDate

    }

//    private fun setManager(){
//        layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        rcw_day_2.layoutManager = layoutManager
//    }

    // set AdapterSpiner cho spiner
    private fun setAdapterspiner(){
        var adapterSpiner : ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this, R.array.spiner_cycle, R.layout.color_spiner)
        adapterSpiner.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spiner.adapter = adapterSpiner

        var adapterSpiner2 : ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this, R.array.spiner_before, R.layout.support_simple_spinner_dropdown_item)

        spiner2.adapter = adapterSpiner2
    }
    //add ngày và thứ vào array

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

    override fun onItemClick(position: Int) {
        //Toast.makeText(this, "Click $position", Toast.LENGTH_SHORT).show()

    }


}
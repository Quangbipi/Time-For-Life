package com.quangminh.myapplication

import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.quangminh.myapplication.Adapter.AdapterDate
import com.quangminh.myapplication.Adapter.AdapterSpiner
import com.quangminh.myapplication.Interface.DayOnClick

class ChangeActivity : AppCompatActivity(), DayOnClick {


    lateinit var rcw_day : RecyclerView
    lateinit var spinerTime : Spinner
    lateinit var timeBefore : Spinner
    lateinit var edtReplace : EditText
    lateinit var tvStarReplace : TextView
    lateinit var tvEndReplace : TextView
    lateinit var important : TextView // qtrong
    lateinit var urgency : TextView // kcap
    lateinit var insignificance : TextView // kqtrong
    lateinit var notUrgent: TextView // k kcap
    lateinit var alarm : TextView
    lateinit var notifi : TextView
    lateinit var evalute : TextView
    lateinit var adapterDate : AdapterDate
    lateinit var getDate: GetDate
    lateinit var adtSpiner :AdapterSpiner
    lateinit var cal:Calendar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change)

        initView()
        setAdapterSpiner()
    }

    private fun initView() {
        rcw_day = findViewById(R.id.rcw_day_3)
        spinerTime = findViewById(R.id.spn_time_2)
        timeBefore = findViewById(R.id.spiner_minute_replace)
        edtReplace = findViewById(R.id.edt_misstion_replace)
        tvStarReplace = findViewById(R.id.time_start_replace)
        tvEndReplace = findViewById(R.id.time_end_replace)
        important = findViewById(R.id.quan_trong_replace)
        urgency = findViewById(R.id.khan_cap_replace)
        insignificance = findViewById(R.id.kquan_trong_replace)
        notUrgent = findViewById(R.id.kkhan_cap_replace)
        alarm = findViewById(R.id.alarm_tv_replace)
        notifi = findViewById(R.id.notifi_tv_replace)
        evalute = findViewById(R.id.kpi_tv_replace)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onStart() {
        super.onStart()

        cal = Calendar.getInstance()
        getDate = GetDate()
        adapterDate = AdapterDate(getDate.getDateOfMont(cal.get(Calendar.MONTH)), getDate.getWeekOfMont(cal.get(Calendar.MONTH)), this, StaticClass.ITEM_VIEW_TYPE_0)
        rcw_day.adapter=adapterDate
    }

    private fun setAdapterSpiner(){
        adtSpiner = AdapterSpiner()
        spinerTime.adapter = adtSpiner.setAdapterspiner(this, StaticClass.TYPE_SPINER_0)
        timeBefore.adapter = adtSpiner.setAdapterspiner(this, StaticClass.TYPE_SPINER_1)
    }
    override fun onItemClick(position: Int) {
        TODO("Not yet implemented")
    }

}
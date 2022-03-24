package com.quangminh.myapplication.Fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.quangminh.myapplication.Adapter.AdapterStatisticWeek
import com.quangminh.myapplication.R
import com.quangminh.myapplication.model.ModelWeekTest

class StatisticByMonthFragment : Fragment() {

    lateinit var rcWeek : RecyclerView
    lateinit var lineChar: LineChart

    lateinit var adapterStatisticWeek : AdapterStatisticWeek

    lateinit var listModelWeekTest : ArrayList<ModelWeekTest>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_statistics_by_month, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(view)
        setData()
        setChart()
        setUpChart()
    }

    private fun initView(view: View) {
        rcWeek = view.findViewById(R.id.rcWeek)
        lineChar = view.findViewById(R.id.pieChartWeek)

    }

    private fun setUpChart(){
        var lineData : LineDataSet = LineDataSet(DataVal(), "")
        lineData.lineWidth = 2f // set độ dày line
        lineData.circleRadius = 0f //set độ dày chấm
        lineData.circleHoleRadius = 0.01f //set chấm
        lineData.setCircleColor(Color.WHITE)
        lineData.isHighlightEnabled = false
        lineData.setColor(resources.getColor(R.color.line, null), 1000)// màu line
        lineData.highLightColor= resources.getColor(R.color.line, null)
        lineData.setDrawValues(false)//set chỉ số ở chấm
        lineData.setDrawCircles(false) //set chấm

        lineData.mode = LineDataSet.Mode.CUBIC_BEZIER // set mod
        lineData.cubicIntensity = 0.2f // độ smooth
        lineData.setDrawFilled(true) // màu dưới line
        lineData.fillColor = resources.getColor(R.color.line, null)// set màu ở dưới line
        lineData.fillAlpha = 20 // set dộ mờ

        var lengend: Legend = lineChar.legend
        lengend.isEnabled = false
        lengend.orientation = Legend.LegendOrientation.HORIZONTAL
        lengend.textColor = Color.RED

        var dataSet:ArrayList<ILineDataSet> = arrayListOf()
        dataSet.add(lineData)

        var data : LineData = LineData(dataSet)
        lineChar.data = data
        lineChar.invalidate()

    }

    private fun setChart(){
        //set đường bên phải
        lineChar.axisLeft.setDrawGridLines(false) // line ngang
        lineChar.axisLeft.setDrawLabels(false)// set chỉ số trái
        lineChar.axisLeft.setDrawAxisLine(false) // cột trái cuối

        // set đường dưới
        lineChar.xAxis.setDrawGridLines(true)// line dọc
        lineChar.xAxis.setDrawLabels(true)// chỉ số ngang
        lineChar.xAxis.setDrawAxisLine(true) // line ngang
        lineChar.xAxis.axisLineColor = resources.getColor(R.color.line, null)
        lineChar.xAxis.axisLineWidth = 3f // kích thước lỉn
        lineChar.xAxis.position= XAxis.XAxisPosition.BOTTOM//vị trí line
        lineChar.xAxis.setDrawGridLinesBehindData(false)
        lineChar.xAxis.gridColor = Color.WHITE
        lineChar.xAxis.gridLineWidth = 0.5f

        // set đường phải
        lineChar.axisRight.setDrawGridLines(false)//line ngang
        lineChar.axisRight.setDrawLabels(false)//chỉ số phải
        lineChar.axisRight.setDrawAxisLine(false)//line phải cuối

        lineChar.description.isEnabled=false
        lineChar.animateX(500, Easing.EaseInBounce)
        lineChar.xAxis.valueFormatter= MyAxisValueFormater()
        lineChar.xAxis.textSize = 10f
    }

    private fun DataVal() : ArrayList<Entry>{
       var dataVal : ArrayList<Entry> = arrayListOf()
        dataVal.add(Entry(1F,2F))
        dataVal.add(Entry(2F,4F))
        dataVal.add(Entry(3F,3F))
        dataVal.add(Entry(4F, 6F))
        dataVal.add(Entry(5F,7F))
        return dataVal
    }

    inner class MyAxisValueFormater : ValueFormatter() {
        override fun getAxisLabel(value: Float, axis: AxisBase?): String {
            axis!!.setLabelCount(5, true)
            return "Tuần " + value.toInt()
        }
    }
    override fun onStart() {
        super.onStart()
        adapterStatisticWeek = AdapterStatisticWeek(listModelWeekTest)
        rcWeek.adapter = adapterStatisticWeek
    }

    private fun setData(){
        listModelWeekTest = arrayListOf()
        listModelWeekTest.add(ModelWeekTest(1, 5, 5, 5, 10))
        listModelWeekTest.add(ModelWeekTest(2, 5, 5, 5, 10))
        listModelWeekTest.add(ModelWeekTest(3, 5, 5, 5, 10))
        listModelWeekTest.add(ModelWeekTest(4, 5, 5, 5, 10))

    }


}
package com.quangminh.myapplication.Fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate.rgb
import com.quangminh.myapplication.Adapter.AdapterMisstion
import com.quangminh.myapplication.R
import com.quangminh.myapplication.model.ModelTest

class StatisticByDayFragment:Fragment() {

    lateinit var pieChart: PieChart
    lateinit var listWork : ArrayList<ModelTest>
    lateinit var adapterMisstion : AdapterMisstion

    lateinit var rcw1 : RecyclerView
    lateinit var rcw2 : RecyclerView

    lateinit var infor: ImageView
    lateinit var inforTab : FrameLayout

    var count : Int = 0
    companion object {
        val MATERIAL_COLOR_S : IntArray = intArrayOf(
                rgb("#D7ECFC"), rgb("#D9D7FC"), rgb("#FBD7FC"), rgb("#FCD7E2"), rgb("#C4C1C1")
        )

        val VORDIPLOM_COLOR_S : IntArray = intArrayOf(Color.rgb(215, 236, 252), Color.rgb(217, 215, 252), Color.rgb(251, 215, 252),
                Color.rgb(252, 215, 226), Color.rgb(196, 193, 193))

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_statistics_by_day, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)

        setUpPieChart()
        loadChartData()
        dataTest()

        infor.setOnClickListener {

            if(count == 0){
                inforTab.visibility= View.INVISIBLE
                count = 1
            }else if(count ==1){
                inforTab.visibility = View.VISIBLE
                count =0
            }

        }
    }

    override fun onResume() {
        super.onResume()
        setAdapter()
    }
    // set thuộc tính màu, dữ liệu cho pie chart
    private fun loadChartData() {

        var dataChart : ArrayList<PieEntry> = arrayListOf()
        dataChart.add(PieEntry(0.1f, ""))
        dataChart.add(PieEntry(0.15f, ""))
        dataChart.add(PieEntry(0.08f, ""))
        dataChart.add(PieEntry(0.25f, ""))
        dataChart.add(PieEntry(0.42f, ""))

        var colors: ArrayList<Int> = arrayListOf()
        for(color in MATERIAL_COLOR_S){
            colors.add(color)
        }
        for(color in VORDIPLOM_COLOR_S){
            colors.add(color)
        }

        var pieChartSet : PieDataSet = PieDataSet(dataChart, "")
        pieChartSet.setColors(colors)

        var pieData : PieData = PieData(pieChartSet)
        pieData.setDrawValues(true)
        pieData.setValueFormatter(PercentFormatter(pieChart))
        pieData.setValueTextSize(12f)
        pieData.setValueTextColor(Color.BLACK)

        pieChart.data = pieData
        pieChart.invalidate()


    }

    // set up pie chart
    private fun setUpPieChart() {

        pieChart.setDrawHoleEnabled(true)
        pieChart.setUsePercentValues(true)
        pieChart.setEntryLabelColor(Color.BLACK)
        pieChart.setEntryLabelTextSize(12F)
        pieChart.getDescription().setEnabled(false);

        var legend: Legend = pieChart.legend
        legend.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        legend.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
        legend.orientation = Legend.LegendOrientation.VERTICAL
        legend.setDrawInside(false)
        legend.isEnabled = false


    }


    private fun initView(view: View) {

        pieChart = view.findViewById(R.id.pieChart)
        rcw1 = view.findViewById(R.id.rcw_dth)
        rcw2 = view. findViewById(R.id.rcw_ht)
        infor = view.findViewById(R.id.imageView5)
        inforTab = view.findViewById(R.id.fr1 )


    }

    private fun dataTest(){

        listWork = arrayListOf()
        listWork.add(ModelTest("Làm việc 1", "9", "1"))
        listWork.add(ModelTest("Làm việc 1", "9", "2"))
        listWork.add(ModelTest("Làm việc 1", "9", "3"))
        listWork.add(ModelTest("Làm việc 1", "9","4"))
        listWork.add(ModelTest("Làm việc 1", "9", "1"))

    }

    private fun setAdapter(){
        adapterMisstion = AdapterMisstion(listWork)
        rcw1.adapter = adapterMisstion

        rcw2.adapter = adapterMisstion
    }

}
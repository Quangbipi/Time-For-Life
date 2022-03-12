package com.quangminh.myapplication

import com.quangminh.myapplication.model.*
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarItemView
import com.google.android.material.navigation.NavigationBarView
import com.quangminh.myapplication.Adapter.ViewPagerAdapterDay

class MainActivity : AppCompatActivity(){

    lateinit var bottomNavigationView: BottomNavigationView
    lateinit var viewPager : ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_app_bar)
        viewPager = findViewById(R.id.viewPager)

        bottomNavigationView.setBackgroundColor(0)

        setUpViewPager()

        bottomNavigationView.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener {

            when(it.itemId){
                R.id.home->{
                    viewPager.setCurrentItem(0)
                    true
                }
                else->{
                    false
                }
            }


        })
    }

    fun setUpViewPager(){
        var viewPagerAdapter : ViewPagerAdapterDay = ViewPagerAdapterDay(supportFragmentManager, lifecycle)
        viewPager.adapter = viewPagerAdapter
    }


}
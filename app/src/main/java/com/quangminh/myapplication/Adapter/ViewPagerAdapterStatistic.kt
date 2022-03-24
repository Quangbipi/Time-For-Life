package com.quangminh.myapplication.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.quangminh.myapplication.Fragments.StatisticByDayFragment
import com.quangminh.myapplication.Fragments.StatisticByMonthFragment
import com.quangminh.myapplication.Fragments.StatisticByYearFragment

class ViewPagerAdapterStatistic (fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                StatisticByDayFragment()
            }
            1->{
                StatisticByMonthFragment()
            }
            2->{
                StatisticByYearFragment()
            }
            else->{
                Fragment()
            }
        }

    }
}
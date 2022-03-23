package com.quangminh.myapplication.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.quangminh.myapplication.Fragments.ProjectFragment
import com.quangminh.myapplication.Fragments.StatsticByDayFragment

class ViewPagerAdapterStatistic (fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return 1
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->{
                StatsticByDayFragment()
            }
            else->{
                Fragment()
            }
        }

    }
}
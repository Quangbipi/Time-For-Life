package com.quangminh.myapplication.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.quangminh.myapplication.Fragments.ProjectFragment
import com.quangminh.myapplication.Fragments.StatisticalFragment2

class ViewPagerAdapterDay (fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
       return when(position){
            0->{
                ProjectFragment()
            }
            1->{
                StatisticalFragment2()
            }
           else ->{
               Fragment()
           }

       }
    }
}
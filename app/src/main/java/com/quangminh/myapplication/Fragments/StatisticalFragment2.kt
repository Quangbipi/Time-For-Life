package com.quangminh.myapplication.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.convertTo
import androidx.fragment.app.Fragment
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.viewpager2.widget.ViewPager2
import com.quangminh.myapplication.Adapter.ViewPagerAdapterStatistic
import com.quangminh.myapplication.R

class StatisticalFragment2 : Fragment() {

    lateinit var viewPager2: ViewPager2
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_statistical, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)

        setAdapterViewPager()
    }

    private fun setAdapterViewPager() {
        var viewPagerAdapterStatistic : ViewPagerAdapterStatistic = ViewPagerAdapterStatistic(childFragmentManager, lifecycle)
        viewPager2.adapter = viewPagerAdapterStatistic
    }

    private fun init(view: View) {
        viewPager2 = view.findViewById(R.id.view_pager)
    }


}
package com.quangminh.myapplication.Adapter

import android.content.Context
import android.widget.Adapter
import android.widget.ArrayAdapter
import com.quangminh.myapplication.R

class AdapterSpiner {

    fun setAdapterspiner(context : Context, type : Int): ArrayAdapter<CharSequence>{
        return when(type){
            0->{
                var adapterSpiner : ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(context, R.array.spiner_cycle, R.layout.color_spiner)
                adapterSpiner.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
                return adapterSpiner
            }

            else -> {
                var adapterSpiner2 : ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(context, R.array.spiner_before, R.layout.support_simple_spinner_dropdown_item)
                return adapterSpiner2

            }
        }


    }
}
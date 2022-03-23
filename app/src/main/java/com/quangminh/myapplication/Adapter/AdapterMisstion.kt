package com.quangminh.myapplication.Adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.quangminh.myapplication.R
import com.quangminh.myapplication.StaticClass
import com.quangminh.myapplication.model.ModelTest

class AdapterMisstion (var workList : ArrayList<ModelTest>) : RecyclerView.Adapter<AdapterMisstion.ViewHolder>() {

    companion object{
        val KIND_A : String= "1"
        val KIND_B : String= "2"
        val KIND_C : String= "3"
        val KIND_D : String= "4"
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterMisstion.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.layout_work_progress, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return workList.size
    }

    override fun onBindViewHolder(holder: AdapterMisstion.ViewHolder, position: Int) {

        var modelTest : ModelTest = workList[position]

        if (modelTest.kind== StaticClass.KIND_A){
            var img : Drawable? = holder.work.context.getDrawable(R.drawable.ic_ellipse_91)
            holder.work.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null)
        }else if(modelTest.kind== StaticClass.KIND_B){
            var img : Drawable? = holder.work.context.getDrawable(R.drawable.ic_ellipse_71)
            holder.work.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null)
        }else if(modelTest.kind== StaticClass.KIND_C){
            var img : Drawable? = holder.work.context.getDrawable(R.drawable.ic_ellipse_61)
            holder.work.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null)
        }else if(modelTest.kind== StaticClass.KIND_D){
            var img : Drawable? = holder.work.context.getDrawable(R.drawable.ic_ellipse_51)
            holder.work.setCompoundDrawablesWithIntrinsicBounds(img, null, null, null)
        }
        holder.work.setText(modelTest.work)
        holder.time.setText(modelTest.time )
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        lateinit var  work : TextView
        lateinit var time : TextView

        init {
            work = itemView.findViewById(R.id.workkk)
            time = itemView.findViewById(R.id.time)
        }

    }
}
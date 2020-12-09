package com.june.compo_recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.june.R

private const val TAG = "MyRecyclerAdapter"

class MyRecyclerAdapter(context: Context) : RecyclerView.Adapter<MyViewHolder>() {

    val mContext = context
    val dataList: MutableList<DataModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val rootView =
            LayoutInflater.from(mContext).inflate(R.layout.layout_recyclerview_item, parent, false)
        return MyViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val dataModel = dataList[position]
        holder.itemTv.setText(dataModel.name)
        holder.itemTv.setOnClickListener {
            dataModel.clickCallBack?.onClick()
        }
    }

    //暂时不使用
    fun updateView(dataModel: DataModel) {
        dataList.add(dataModel)
        notifyDataSetChanged()
    }
}
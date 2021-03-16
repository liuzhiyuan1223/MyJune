package com.june.frame_lifecycle

import android.view.View
import android.widget.TextView
import androidx.lifecycle.Observer


class MyObserver : Observer<DataModelLife> {

    lateinit var view : View

    fun initView(view : View){
        this.view = view
    }

    override fun onChanged(t: DataModelLife) {
        val textView = view as TextView
        textView.text = t.name
    }
}
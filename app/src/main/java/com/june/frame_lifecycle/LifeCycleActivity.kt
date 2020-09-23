package com.june.frame_lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.june.R
import kotlinx.android.synthetic.main.activity_life_cycle.*

class LifeCycleActivity : AppCompatActivity() {

    val curActivity = this
    val myObserver: MyObserver
    lateinit var viewModel: MyViewModel
    var count: Int = 0

    init {
        myObserver = MyObserver()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)

        viewModel = ViewModelProvider(curActivity).get(MyViewModel::class.java)
        //初始化观察者关系
        viewModel.myLiveData.observe(curActivity, myObserver)

        addViewToObserver(tvShowLiveDataId)

        initClickFunction() //初始化点击功能
    }

    fun addViewToObserver(view: View) {
        myObserver.initView(view)
    }

    fun initClickFunction() {
        btnMockDataComingId.setOnClickListener {
            viewModel.updateMyLiveData(DataModelLife((++count).toString()))
        }
    }
}
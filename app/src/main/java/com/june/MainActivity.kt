package com.june

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.june.component_floatview.FloatViewActivity
import com.june.component_navigation.NavigActivity
import com.june.component_recyclerview.DataModel
import com.june.component_recyclerview.InterfaceClickCallback
import com.june.component_recyclerview.MyRecyclerAdapter
import com.june.frame_lifecycle.LifeCycleActivity
import com.june.language_java.JavaLangActivity
import com.june.process_thread.ThreadTestCl
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "july"

class MainActivity : AppCompatActivity() {

    val mContext: Context = this
    lateinit var myRecyclerAdapter: MyRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycleViewContainer()

        //查看一下主线程的优先级
        ThreadTestCl.printMainThreadPriority();
    }

    fun initRecycleViewContainer() {
        val layoutMan: LinearLayoutManager = LinearLayoutManager(mContext)
        layoutMan.orientation = LinearLayoutManager.VERTICAL
        viewConRecyclerView.layoutManager = layoutMan

        myRecyclerAdapter = MyRecyclerAdapter(mContext)
        for (dataModel in initDataList()) {
            myRecyclerAdapter.dataList.add(dataModel)
        }

        viewConRecyclerView.adapter = myRecyclerAdapter
    }

    //添加数据
    fun initDataList(): MutableList<DataModel> {
        val dataList: MutableList<DataModel> = mutableListOf()
        //更新测试数据
        val dataModel1 = DataModel()
        dataModel1.name = "btnToActLifeCyle"
        dataModel1.setClickCallback(object : InterfaceClickCallback {
            override fun onClick() {
                val intent = Intent(mContext, LifeCycleActivity::class.java)
                startActivity(intent)
            }
        })

        val dataModel2 = DataModel()
        dataModel2.name = "btnToJavaLangTest"
        dataModel2.setClickCallback(object : InterfaceClickCallback {
            override fun onClick() {
                val intent = Intent(mContext, JavaLangActivity::class.java)
                startActivity(intent)
            }
        })

        val dataModel3 = DataModel()
        dataModel3.name = "btnToFloatView"
        dataModel3.setClickCallback(object : InterfaceClickCallback {
            override fun onClick() {
                val intent = Intent(mContext, FloatViewActivity::class.java)
                startActivity(intent)
            }
        })

        val dataModel4 = DataModel()
        dataModel4.name = "btnToNavigActivity"
        dataModel4.setClickCallback(object : InterfaceClickCallback {
            override fun onClick() {
                val intent = Intent(mContext, NavigActivity::class.java)
                startActivity(intent)
            }
        })

        dataList.add(dataModel1)
        dataList.add(dataModel2)
        dataList.add(dataModel3)
        dataList.add(dataModel4)

        return dataList
    }
}
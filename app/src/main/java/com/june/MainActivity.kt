package com.june

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.june.component_floatview.FloatViewActivity
import com.june.component_recyclerview.DataModel
import com.june.component_recyclerview.MyRecyclerAdapter
import com.june.frame_lifecycle.LifeCycleActivity
import com.june.language_java.JavaLangActivity
import com.june.project_javaparser.JavaParserActivity
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    val mContext : Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycleViewContainer()

        initBtnFunction()
    }

    fun initBtnFunction(){
        //跳转到LifeCycleActivity
        btnToActLifeCyle.setOnClickListener {
            val intent = Intent(mContext , LifeCycleActivity::class.java)
            startActivity(intent)
        }

        //跳转到JavaLangActivity
        btnToJavaLangTest.setOnClickListener {
            val intent = Intent(mContext , JavaLangActivity::class.java)
            startActivity(intent)
        }

        //跳转到btnToFloatView
        btnToFloatView.setOnClickListener {
            val intent = Intent(mContext , FloatViewActivity::class.java)
            startActivity(intent)
        }

        //跳转到btnToJavaParse
        btnToJavaParse.setOnClickListener {
            val intent = Intent(mContext , JavaParserActivity::class.java)
            startActivity(intent)
        }
    }

    fun initRecycleViewContainer(){
        val layoutMan : LinearLayoutManager = LinearLayoutManager(mContext)
        layoutMan.orientation = LinearLayoutManager.VERTICAL
        viewConRecyclerView.layoutManager = layoutMan

        val myRecyclerAdapter = MyRecyclerAdapter(mContext)
        viewConRecyclerView.adapter = myRecyclerAdapter

        //更新测试数据
        val dataModel1 = DataModel()
        dataModel1.name = "这是一条测试数据1"
        dataModel1.clickEvent = {
            Log.d(TAG, "点击了 dataModel1 : ")
        }
        myRecyclerAdapter.updateView(dataModel1)

        val dataModel2 = DataModel()
        dataModel2.name = "这是一条测试数据2"
        myRecyclerAdapter.updateView(dataModel2)
    }
}
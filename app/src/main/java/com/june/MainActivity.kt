package com.june

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.june.compo_floatview.FloatViewActivity
import com.june.comp_navigation.NavigActivity
import com.june.compo_recyclerview.DataModel
import com.june.compo_recyclerview.InterfaceClickCallback
import com.june.compo_recyclerview.MyRecyclerAdapter
import com.june.frame_lifecycle.LifeCycleActivity
import com.june.frame_okhttp.NetUtilActivity
import com.june.language_java.JavaLangActivity
import com.june.other_utils.LogCharlesRangIp
import com.june.permission.CarmeraPermissonActivity
import com.june.process_thread.ThreadTestCl
import com.june.understand_fragment.MyFragActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.june.comp_edittext.TestEditTextActivity
import com.june.comp_scroll.MyElemeActivity
import com.june.comp_scroll2.main.ScrollMainActivity
import com.june.xml_parser.XMLParserActivity
import com.june.comp_ui.UITestActivity

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


    override fun onResume() {
        super.onResume()
        LogCharlesRangIp.logCharlesIp(this) //打印所有的ip地址
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

    val dataList: MutableList<DataModel> = mutableListOf()

    //添加数据
    fun initDataList(): MutableList<DataModel> {
        addItemToList("1-btnToActLifeCyle", LifeCycleActivity::class.java)
        addItemToList("2-btnToJavaLangTest", JavaLangActivity::class.java)
        addItemToList("3-btnToFloatView", FloatViewActivity::class.java)
        addItemToList("4-btnToNavigActivity", NavigActivity::class.java)
        addItemToList("5-btnToCarmeraPermissonActivity", CarmeraPermissonActivity::class.java)
        addItemToList("6-btnToMyFragActivity", MyFragActivity::class.java)
        addItemToList("7-btnToNetUtilActivity", NetUtilActivity::class.java) //构建自己的网络请求mock器
        addItemToList("9-btnToTestEditTextActivity", TestEditTextActivity::class.java)
        addItemToList("10-btnToXMLParserActivity", XMLParserActivity::class.java)
        addItemToList("11-btnToUITestActivity", UITestActivity::class.java)
        addItemToList("12-btnToMyElemeActivity", MyElemeActivity::class.java)
        addItemToList("13-btnToScrollMainActivity", ScrollMainActivity::class.java)

        return dataList
    }

    private fun addItemToList(@NonNull nameOfDes : String,@NonNull cls : Class<out Activity>){ //注意这个泛型的使用<out XX>
        val newDataModel = DataModel()
        newDataModel.name = nameOfDes //用于recyclerview展示item的title
        newDataModel.setClickCallback(object : InterfaceClickCallback { //用于recyclerview的item点击事件处理
            override fun onClick() {
                val intent = Intent(mContext, cls)
                startActivity(intent)
            }
        })
        dataList.add(newDataModel)
    }
}
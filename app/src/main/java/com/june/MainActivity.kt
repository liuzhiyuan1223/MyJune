package com.june

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.june.comp_counttimer_card.CancelCardTimerActivity
import com.june.comp_download.DownLoadActivity
import com.june.comp_floatview.FloatViewActivity
import com.june.comp_navigation.NavigActivity
import com.june.compo_recyclerview.DataModel
import com.june.compo_recyclerview.InterfaceClickCallback
import com.june.compo_recyclerview.MyRecyclerAdapter
import com.june.frame_lifecycle.LifeCycleActivity
import com.june.frame_okhttp.NetUtilActivity
import com.june.lang_java.JavaLangActivity
import com.june.other_utils.LogCharlesRangIp
import com.june.permission.CarmeraPermissonActivity
import com.june.process_thread.ThreadTestCl
import com.june.understand_fragment.MyFragActivity
import kotlinx.android.synthetic.main.activity_main.*
import com.june.comp_edittext.TestEditTextActivity
import com.june.comp_fragment.MyFragAvtivityFirst
import com.june.comp_pack_name.PrintPackNameActivity
//import com.june.comp_qr_code.activity.CaptureActivity
import com.june.comp_scroll.MyElemeActivity
import com.june.comp_scroll2.main.ScrollMainActivity
import com.june.comp_text.TextTestActivity
import com.june.xml_parser.XMLParserActivity
import com.june.comp_ui.UITestActivity
import com.june.lang_kotlin.KotTestActivity

class MainActivity : AppCompatActivity() {

    val mContext: Context = this
    lateinit var myRecyclerAdapter: MyRecyclerAdapter
    val dataList: MutableList<DataModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycleViewContainer()

        //查看一下主线程的优先级
//        ThreadTestCl.printMainThreadPriority();
    }

    override fun onResume() {
        super.onResume()
//        LogCharlesRangIp.logCharlesIp(this) //打印所有的ip地址
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
    /**
     * 反编译出来的Java代码
     */
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
        addItemToList("14-btnToMyFragAvtivityFirst", MyFragAvtivityFirst::class.java)
        addItemToList("15-btnToTextTestActivity", TextTestActivity::class.java)
        addItemToList("16-btnToKotTestActivity", KotTestActivity::class.java)
        addItemToList("17-btnToCancelCardTimerActivity", CancelCardTimerActivity::class.java)
        addItemToList("18-btnToPrintPackNameActivity", PrintPackNameActivity::class.java)
        addItemToList("19-btnToDownLoadActivity", DownLoadActivity::class.java)

        return dataList
    }

    private fun addItemToList(@NonNull nameOfDes : String,@NonNull cls : Class<out Activity>){ //注意这个泛型的使用<out XX>
        val newDataModel = DataModel()
        newDataModel.let {
            it.name = nameOfDes
            it.setClickCallback(object : InterfaceClickCallback { //用于recyclerview的item点击事件处理
                override fun onClick() {
                    startActivity(Intent(mContext, cls))
                }
            })
        }
        dataList.add(newDataModel)
    }
}
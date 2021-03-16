package com.june

//import com.june.comp_qr_code.activity.CaptureActivity
import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tools.float_tool.FloatTools
import com.example.tools.float_tool.fun_1.IStartWebListener
import com.june.comp_counttimer_card.CancelCardTimerActivity
import com.june.comp_download.DownLoadActivity
import com.june.comp_edittext.TestEditTextActivity
import com.june.comp_floatview.FloatViewActivity
import com.june.comp_floatview.ViewTestActivity
import com.june.comp_floatview.simple_case.SimpleFloatViewActivity
import com.june.comp_floatview.test_decor_float.FloatMainActivity
import com.june.comp_fragment.MyFragAvtivityFirst
import com.june.comp_navigation.NavigActivity
import com.june.comp_pack_name.PrintPackNameActivity
import com.june.comp_scroll.MyElemeActivity
import com.june.comp_scroll2.main.ScrollMainActivity
import com.june.comp_text.TextTestActivity
import com.june.comp_ui.UITestActivity
import com.june.compo_recyclerview.DataModel
import com.june.compo_recyclerview.InterfaceClickCallback
import com.june.compo_recyclerview.MyRecyclerAdapter
import com.june.frame_lifecycle.LifeCycleActivity
import com.june.frame_okhttp.NetUtilActivity
import com.june.fun_app_server.ServerManagerActivity
import com.june.lang_java.JavaLangActivity
import com.june.lang_kotlin.KotTestActivity
import com.june.permission.CarmeraPermissonActivity
import com.june.test_my_sweet_june_lib.TestSweetJuneLibActivity
import com.june.understand_fragment.MyFragActivity
import com.june.use_surfaceview.TestSurfaceViewActivity
import com.june.use_surfaceview.dynamic_view.SurfaceViewDynDrawDemoActivity
import com.june.xml_parser.XMLParserActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val mContext: Context = this
    lateinit var myRecyclerAdapter: MyRecyclerAdapter
    val dataList: MutableList<DataModel> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecycleViewContainer()
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
        addItemToList("20-btnToTestSurfaceViewActivity", TestSurfaceViewActivity::class.java)
        addItemToList("21-btnToSurfaceViewDynDrawDemoActivity", SurfaceViewDynDrawDemoActivity::class.java)
        addItemToList("22-btnToServerManagerActivity", ServerManagerActivity::class.java)
        addItemToList("23-btnToViewTestActivity", ViewTestActivity::class.java)
        addItemToList("24-btnToSimpleFloatViewActivity", SimpleFloatViewActivity::class.java)
        addItemToList("25-btnToTestSweetJuneLibActivity", TestSweetJuneLibActivity::class.java)
        addItemToList("26-btnToFloatMainActivity", FloatMainActivity::class.java)

        return dataList
    }

    private fun addItemToList(@NonNull nameOfDes : String, @NonNull cls : Class<out Activity>){ //注意这个泛型的使用<out XX>
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
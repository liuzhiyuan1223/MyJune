package com.june.test_my_sweet_june_lib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tools.float_tool.FloatTools
import com.example.tools.float_tool.fun_1.IStartWebListener
import com.june.MyApplication
import com.june.R
import kotlinx.android.synthetic.main.activity_test_sweet_june_lib.*

class TestSweetJuneLibActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_sweet_june_lib)

        mStartTest.setOnClickListener {
            //初始化并创建悬浮窗工具
            FloatTools.get().apply {
                this.init(MyApplication.getInstance()) //初始化操作
                this.createFloateView(this@TestSweetJuneLibActivity, object : IStartWebListener {
                    override fun onStartWebClick(url: String) {

                    }
                })
            }
        }
    }



    //测试spring注解管理
}
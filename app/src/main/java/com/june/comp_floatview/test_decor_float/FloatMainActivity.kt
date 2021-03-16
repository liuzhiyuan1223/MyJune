package com.june.comp_floatview.test_decor_float

import android.content.Intent
import android.os.Bundle
import com.june.R
import kotlinx.android.synthetic.main.float_activity_main.*

class FloatMainActivity : FloatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.float_activity_main)
        btnSecond.setOnClickListener {
            startActivity(Intent(this, FloatSecondActivity::class.java))
        }

        // 展示/隐藏悬浮窗
        chkShowFloatWindow.setOnCheckedChangeListener { _, isChecked ->
            showFloatWindow(isChecked) //根据勾选值显示或隐藏悬浮窗
        }
    }

    override fun onResume() {
        super.onResume()
        chkShowFloatWindow.isChecked = FloatActivity.isShowing(this)
    }
}
package com.june.comp_floatview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.view.marginTop
import com.june.R

class ViewTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_test)

        val textView = TextView(this)
        textView.text = "测试文字"
        textView.setTextColor(resources.getColor(R.color.color_white_opacity_84))

        val layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.topMargin = 50
        layoutParams.leftMargin = 500

        val decorView = window.decorView as FrameLayout
        decorView.addView(textView, layoutParams)

    }
}
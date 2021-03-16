package com.june.comp_ui

import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.june.R
import com.june.comp_floatview.test_decor_float.FloatActivity
import kotlinx.android.synthetic.main.activity_u_i_test.*

class UITestActivity : AppCompatActivity() {

    private var offX = 0
    private var offY = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_i_test)

        val textView1 = TextView(this)
        textView1.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        textView1.text = "1111111111"

        val textView2 = TextView(this)
        textView2.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        textView2.text = "2222222222"

        mContainerUiTest.addView(textView1, 1)
        mContainerUiTest.addView(textView2, 2)


        //测试位置刷新
        mTvTestUi.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent): Boolean {

                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        offX =
                            event.rawX.toInt() - mTvTestUi.x.toInt()
                        offY =
                            event.rawY.toInt() - mTvTestUi.y.toInt()
                        return true
                    }
                    MotionEvent.ACTION_UP -> {
                        return true
                    }
                    MotionEvent.ACTION_MOVE -> {
                        mTvTestUi.x = event.rawX - offX
                        mTvTestUi.y = event.rawY - offY
                        return true
                    }
                }

                return false
            }
        })
    }
}

package com.june.comp_text

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.june.R
import kotlinx.android.synthetic.main.activity_text_test.*

class TextTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_test)

        //设置text1
        mTxtFirst.setText(baseContext.resources.getString(R.string.format_txt_1, 666, 888))
        mTxtSecond.setText(baseContext.resources.getString(R.string.format_txt_2, "210112天气好"))
    }
}
package com.june.comp_floatview.test_decor_float

import android.os.Bundle
import com.june.R
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.activity_second_float.*

class FloatSecondActivity : FloatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_float)
        btnBack.setOnClickListener { onBackPressed() }
        chkShowFloatWindow.setOnCheckedChangeListener { _, isChecked ->
            showFloatWindow(
                isChecked
            )
        }
    }

    override fun onResume() {
        super.onResume()
        chkShowFloatWindow.isChecked = FloatActivity.isShowing(this)
    }
}
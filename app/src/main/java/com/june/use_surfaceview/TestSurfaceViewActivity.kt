package com.june.use_surfaceview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.june.R
import kotlinx.android.synthetic.main.activity_test_surface_view.*

class TestSurfaceViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_surface_view)

//        mBtnRun.setOnClickListener { mSurfaceView.run() }
    }
}
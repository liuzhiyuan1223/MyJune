package com.june.understand_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.june.R

class MyFragActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_frag)

        supportFragmentManager.beginTransaction()
    }

    override fun onBackPressed() {
        super.onBackPressed()

    }
}
package com.june.comp_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.june.R

class MyFragAvtivitySecond : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myfragment_second)

        intent.putExtra("param_int", 5)
        setResult(6, intent)

        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed(Runnable { finish() }, 2000)
    }
}
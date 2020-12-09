package com.june.comp_ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.june.R
import kotlinx.android.synthetic.main.activity_u_i_test.*

class UITestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_i_test)

        mTvTestUi.isEnabled = false //无法响应onTouch事件
        mTvTestUi.focusable = View.NOT_FOCUSABLE
        mTvTestUi.isSelected = true

//        filterCountry("EU", 1000, fun (name : String) : Boolean{
//            return name == "China"
//        })

//        filterCountry("EU", 1000, {(countryName) -> countryName == "China"})
    }

    fun filterCountry(name : String, count : Int, filter : (String) -> Boolean){
        val list = mutableListOf<String>()
        if(filter(name)){
            list.add(name)
        }
    }

    //filter
//    fun filter(name : String) : Boolean{
//        return name == "China"
//    }


//    override fun onSaveInstanceState(outState: Bundle) {
//        outState.putChar("",'a')
//        super.onSaveInstanceState(outState)
//    }
}

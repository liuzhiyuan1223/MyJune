package com.june.lang_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.june.R

private const val TAG = "july"
class KotTestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kot_test)

        var p : Person? = null
//        p?.name = null
//        testFun1(p)

        testFun2(p?.name)
    }

    fun testFun1(person: Person?){
        val nameTest = person?.name ?: "666"
        Log.d(TAG, "testFun: $nameTest" )
    }

    fun testFun2(name: String?){
        Log.d(TAG, "testFun12: 执行")
    }


    fun getModel() : Bird?{
        val duck : Duck? = null
        return duck
    }

    open class Bird{
    }

    class Duck : Bird() {
    }
}
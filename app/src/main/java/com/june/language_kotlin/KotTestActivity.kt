package com.june.language_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.june.R

class KotTestActivity : AppCompatActivity() {

    private val testFile by lazy {
        TestClass()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kot_test)
    }


    //值传递
//    fun testValuePass(tInt : Int, tPerson: Person){
//        tInt = 4;
//        tPerson = Person("zhangsan")
//    }

    class TestClass {
        val type: Int = 0
    }

    fun testList(list: List<TestClass>) {
        list.filter {
            val b = it.type % 2 == 0
            val b1 = it.type % 3 == 0
            b1 || b
        }

        val map = list.map {
            Person(it.toString())
        }
    }

    class Person(name : String){
    }
}
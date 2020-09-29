package com.june.language_kotlin

class Lambda_lang {

    fun testLambda(){

        setTestCl(object : TestCl(){
            override fun runMe() {
                TODO("Not yet implemented")
            }
        })

    }

    fun setTestCl(cl : TestCl){
        cl.runMe()
    }

    abstract class TestCl{
        abstract fun runMe()
    }
}
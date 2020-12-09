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



    //1.使用接口回调方法
    fun mainTest1(){
        mListener?.onClickTest() //通过接口回调方法，达到执行方法的目的
    }

    //测试代码
    var mListener : MyClickListener? = null
    fun setMyClickListener(listener : MyClickListener?){
        mListener = listener
    }


    interface MyClickListener {
        fun onClickTest() : String
    }



    //2.使用Lambda表达式。达到执行方法的目的
    fun mainTest2(){
//        f(
//            {print("1")}
//        )
//
//        f{
//            print("2")
//        }
    }


    val test : () -> Unit = fun(){

    }


    //1.匿名函数
    val f: (Int) -> Unit = fun(i: Int) {
        print("")
    }

    //等价于lambada表达式的写法
    val f2 : (Int) -> Unit = {
        p: Int -> {}
//        p -> {} 第二种写法：基于类型推导
        "Hello"
    }


    //2.Lambda表示式
    val f1: (Int) -> Unit = {
            p: Int -> print("")
    }



}
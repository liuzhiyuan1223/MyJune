package com.june

import android.app.Activity
import android.app.Application
import android.content.res.Configuration
import java.util.*

class MyApplication : Application() {

    companion object{
        private var sInstance: MyApplication? = null

        @JvmStatic
        fun getInstance()  = sInstance!!
    }


    /**
     * 在创建应用程序时调用，可以重写这个方法来实例化应用程序单态，以及创建和实例化任何应用
     * 程序状态变量或共享资源
     */
    override fun onCreate() {
        super.onCreate()

        sInstance = this

        activities = LinkedList<Activity>()

//        registerActivityLifecycleCallbacks()
    }

    var globalVar: String? = null

    /**
     * 单例模式
     * @return
     */
    private var activities: MutableList<Activity>? = null

    /**
     * 添加activity
     * @param a
     */
    fun addActivity(a: Activity) {
        activities!!.add(a)
    }

    /**
     * 遍历所有Activity并finish
     */
    fun finishActivity() {
        for (activity in activities!!) {
            if (activity != null && !activity.isFinishing) {
                activity.finish()
            }
        }
    }
}
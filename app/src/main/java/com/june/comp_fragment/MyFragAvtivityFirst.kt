package com.june.comp_fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.june.R

private const val TAG = "MyFragAvtivityFirst"

class MyFragAvtivityFirst : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myfragment_first)

        //创建一个fragment
        addFragment(this, R.id.container_frag, MyFragmentFirst())
    }

    //测试代码
    fun addFragment(activity: FragmentActivity, resourceId: Int, fragment: Fragment?) {
        if (fragment == null) {
            return
        }
        val manager = activity.supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(resourceId, fragment, fragment.javaClass.simpleName)
//        transaction.addToBackStack(fragment.javaClass.simpleName)
        transaction.commitAllowingStateLoss()
    }
}
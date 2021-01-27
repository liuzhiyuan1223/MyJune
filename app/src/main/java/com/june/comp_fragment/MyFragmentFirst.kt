package com.june.comp_fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.june.R

private const val TAG = "july"

class MyFragmentFirst : Fragment() {

    companion object{
        const val REQUEST_CODE = 6
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mRootView = LayoutInflater.from(context).inflate(R.layout.frag_first, container, false)
        val mTvStartSecondAct = mRootView.findViewById<TextView>(R.id.mTvStartSecondAct)
        //点击btn跳转
        mTvStartSecondAct.setOnClickListener {
            startActivityForResult(Intent(context, MyFragAvtivitySecond::class.java), REQUEST_CODE)
            Log.d(TAG, "onCreate: ")
        }
        return mRootView
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        if(requestCode == REQUEST_CODE && ){
//
//        }


        val intValue = data?.getIntExtra("param_int", -1)
        Log.d(TAG, "startActivityForResult, intValue =  " + intValue)
    }
}
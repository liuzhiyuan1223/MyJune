package com.june.lang_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.june.R;

public class JavaLangActivity extends AppCompatActivity {

    private static final String TAG = "JavaLangActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_lang);

        testChars();
    }

    //测试&&和||是否有短路效果
    private void testChars(){
        JavaLangTestObj obj = null;
        if(obj == null || obj.name.length() == 0){
            Log.d(TAG, "1-||可以短路testChars: ");
        }
//        if(obj.name.length() == 0 || obj == null){
//            Log.d(TAG, "2-||可以短路testChars: ");
//        }

//        if(obj == null && obj.name.length() == 0){
//            Log.d(TAG, "&&可以短路testChars: ");
//        }


    }

    class JavaLangTestObj{
        String name = "";
    }

    //值传递
    void testValuePass(int tInt, JavaLangTestObj tPerson){
        tInt = 4;
        tPerson = new JavaLangTestObj();
    }
}
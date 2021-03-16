package com.june.lang_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.june.R;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class JavaLangActivity extends AppCompatActivity {

    private static final String TAG = "july";


    private String mStr = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_lang);

//        testChars();

        testBytes();

//        Person person = new Person();
//        person.hotal = new Hotal();
//        person.hotal.testStr = "1";
//
//        mStr = person.hotal.testStr;
//
//        Log.d(TAG, "person.hotal: " + person.hotal);
//        Log.d(TAG, "str = 1;person.hotal.testStr: " + person.hotal.testStr.hashCode());
//
//        person.hotal.testStr = "2";
//        Log.d(TAG, "str = 2;person.hotal.testStr: " + person.hotal.testStr.hashCode());
    }


    /*
     *用途:Hook简单举例（View点击事件）
     */
    public static void hookOnClickListener(View view) throws Exception {
        // 第一步：反射得到 ListenerInfo 对象
        Method getListenerInfo = View.class.getDeclaredMethod("getListenerInfo");
        getListenerInfo.setAccessible(true);
        Object listenerInfo = getListenerInfo.invoke(view);

        // 第二步：得到原始的 OnClickListener事件方法
        Class<?> listenerInfoClz = Class.forName("android.view.View$ListenerInfo");
        Field mOnClickListener = listenerInfoClz.getDeclaredField("mOnClickListener");
        mOnClickListener.setAccessible(true);
        View.OnClickListener originOnClickListener = (View.OnClickListener) mOnClickListener.get(listenerInfo);

        // 第三步：用 Hook代理类 替换原始的 OnClickListener
        View.OnClickListener hookedOnClickListener = new HookedClickListener(originOnClickListener);
        mOnClickListener.set(listenerInfo, hookedOnClickListener);
    }

    public static class HookedClickListener implements View.OnClickListener {

        private View.OnClickListener origin;

        public HookedClickListener(View.OnClickListener origin) {
            this.origin = origin;
        }

        @Override
        public void onClick(View v) {
            // Toast.makeText(v.getContext(), "你的点击事件被赵星海劫持了！", Toast.LENGTH_SHORT).show();
            if (origin != null) {
                origin.onClick(v);
            }
        }

    }




    private void testBytes(){
//        String s1 = "abc";
//        String s2 = "测试文字";
//
//        for (byte b : s2.getBytes()){
//            Log.d(TAG, "testBytes: " + b);
//        }

        Map mapTest = new HashMap<>();
        mapTest.put("一", "张张");
        mapTest.put("二", "李李");
        mapTest.put("三", "旺旺");

        Gson gson = new Gson();
        String sTxt = gson.toJson(mapTest);

        Log.d(TAG, "sTxt: " + sTxt);
    }


    class Person{
        public Hotal hotal;
    }


    class Hotal{
        String testStr;
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
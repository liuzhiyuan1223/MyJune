package com.june.other_utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import java.io.FileWriter;

public class LogCharlesRangIp {

    private static Activity mAct;

    public static void logCharlesIp(Activity context) {
        mAct = context;
        requestWritePer(context);

//        String s = "<ipRange><ip><int>172</int><int>23</int><int>40</int><int>225</int></ip><mask><int>255</int><int>255</int><int>255</int><int>255</int></mask></ipRange>";
        String s = "<ipRange><ip><int>172</int><int>23</int><int>40</int><int>x</int></ip><mask><int>255</int><int>255</int><int>255</int><int>255</int></mask></ipRange>";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 255; i++) {
            sb.append(s.replace("x", i + ""));
        }
//        System.out.println();
//        System.out.println(sb.toString());
//        System.out.println();

        testOnResume(sb.toString());
    }


    public static void testOnResume(String str) {
        android.content.Intent intent = mAct.getIntent();
        if (true) {
            try {
                java.io.File sdCardDir = android.os.Environment.getExternalStorageDirectory();
                java.io.BufferedWriter writer = new java.io.BufferedWriter(new FileWriter(sdCardDir.getCanonicalPath() + "/charip.txt"));
                writer.write(str);
                writer.flush();

                writer.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }
    }


    private static void requestWritePer(Activity act) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
            if (ActivityCompat.checkSelfPermission(act, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(act, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 666);
            }
        }
    }
}

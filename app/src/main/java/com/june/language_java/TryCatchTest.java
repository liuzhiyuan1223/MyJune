package com.june.language_java;

import android.content.pm.ApplicationInfo;
import android.util.Log;
import android.widget.Toast;

public class TryCatchTest {

    private static final String TAG = "TryCatchTest";

    private void tMe(){
        try {
            Log.d(TAG, "tMe: ");
        }catch (Exception e){
            Log.d(TAG, "tMe: ");
        }
    }
}

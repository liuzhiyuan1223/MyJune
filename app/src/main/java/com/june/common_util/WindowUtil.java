package com.june.common_util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class WindowUtil {

    //获取状态栏高度
    public static int getStatusBarHeight(Context context){
        Resources resources = context.getResources();
        int resId = resources.getIdentifier("status_bar_height", "dimen", "android");
        return resources.getDimensionPixelSize(resId);
    }


    public static int getWindowWidth(Context context){
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if(displayMetrics == null){
            return 0;
        }
        return displayMetrics.widthPixels;
    }

    public static int getWindowHeight(Context context){
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if(displayMetrics == null){
            return 0;
        }
        return displayMetrics.heightPixels;
    }
}

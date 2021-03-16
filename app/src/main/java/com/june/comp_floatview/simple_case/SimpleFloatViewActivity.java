package com.june.comp_floatview.simple_case;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.june.R;

public class SimpleFloatViewActivity extends AppCompatActivity {

    private WindowManager windowManager;
    private WindowManager.LayoutParams layoutParams;

    //状态栏高度.
    int statusBarHeight = -1;
    private boolean isShowFun = false;
    //判断是否是滑动操作的最小距离阈值
    private int mTouchSlop = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_float_view2);

        mTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();

        if (!requestFloatPermission()) {
            Toast.makeText(this, "当前无权限，请授权", Toast.LENGTH_SHORT);
            startActivityForResult(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName())), 0);
        } else {
            //用于检测状态栏高度.
            int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) statusBarHeight = getResources().getDimensionPixelSize(resourceId);
            layoutParams = new WindowManager.LayoutParams();

            windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
            layoutParams = new WindowManager.LayoutParams();
            layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
            layoutParams.format = PixelFormat.TRANSLUCENT;// 支持透明
            layoutParams.format = PixelFormat.RGBA_8888;
            layoutParams.flags |= WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE; // 焦点
            layoutParams.width = WindowManager.LayoutParams.WRAP_CONTENT;
            layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
            layoutParams.x = 0; //窗口位置的偏移量
            layoutParams.y = 0;
            View view = showFloatView();
            windowManager.addView(view, layoutParams);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private View showFloatView() {
        LinearLayout floatView = (LinearLayout) LayoutInflater.from(getBaseContext()).inflate(R.layout.layout_float_view, null);
        View flagFloatView = floatView.findViewById(R.id.flag_float_view);

        TextView mTvFunOne = floatView.findViewById(R.id.fun_one); //第一项功能
        mTvFunOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SimpleFloatViewActivity.this, "fun - 1", Toast.LENGTH_SHORT).show();
            }
        });
        TextView mTvFunTwo = floatView.findViewById(R.id.fun_two); //第二项功能
        mTvFunTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SimpleFloatViewActivity.this, "fun - 2", Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayout mContainerFun = floatView.findViewById(R.id.container_fun);
        floatView.setOnTouchListener(new View.OnTouchListener() {
            private int startX;
            private int startY;
            // 是否点击
            boolean isPerformClick;

            @Override
            public boolean onTouch(View view, MotionEvent event) {

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        this.startX = (int) event.getRawX();
                        this.startY = (int) event.getRawY();
                        isPerformClick = true;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        if (Math.abs(startX - event.getX()) >= mTouchSlop || Math.abs(startY - event.getY()) >= mTouchSlop) {
                            isPerformClick = false;

                            int nowX = (int) event.getRawX();
                            int nowY = (int) event.getRawY();
                            int movedX = nowX - this.startX;
                            int movedY = nowY - this.startY;
                            this.startX = nowX;
                            this.startY = nowY;
                            layoutParams.x = layoutParams.x + movedX;
                            layoutParams.y = layoutParams.y + movedY;
                            windowManager.updateViewLayout(view, layoutParams);
                        }
                        break;
                    case MotionEvent.ACTION_UP:
                        if (isPerformClick) {
                            handleFloatIconClick(mContainerFun);
                        }
                }
                return false;
            }
        });
        return floatView;
    }

    private void handleFloatIconClick(View view) {
        if (!isShowFun) { //不展示的情况下
            isShowFun = !isShowFun;
            view.setVisibility(View.VISIBLE);
        } else {
            isShowFun = !isShowFun;
            view.setVisibility(View.GONE);
        }
    }

    private boolean requestFloatPermission() {
        return Settings.canDrawOverlays(this);
    }
}
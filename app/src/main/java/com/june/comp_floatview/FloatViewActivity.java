package com.june.comp_floatview;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.june.R;
import com.june.comp_floatview.view.FloatWindow;
import com.june.comp_floatview.view.PermissionListener;
import com.june.comp_floatview.view.Screen;
import com.june.comp_floatview.view.ViewStateListener;

public class FloatViewActivity extends AppCompatActivity {

    private Button btn;
    private static final String TAG = "FloatViewActivity";

    //展示功能区域
    private boolean isShowFun = false;
    WindowManager.LayoutParams params;
    WindowManager windowManager;
    //状态栏高度.
    int statusBarHeight = -1;
    //判断是否是滑动操作的最小距离阈值
    private int mTouchSlop = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float_view);

//        if (FloatWindow.mFloatWindowMap != null && FloatWindow.mFloatWindowMap.size() == 0) createFloatView();
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        createFloatView();
    }

    private void createFloatView() {
        //测试代码
        mTouchSlop = ViewConfiguration.get(this).getScaledTouchSlop();

        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageResource(R.drawable.icon);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FloatViewActivity.this, "onClick", Toast.LENGTH_SHORT).show();
            }
        });

        //测试代码
        LinearLayout floatView = (LinearLayout) LayoutInflater.from(getBaseContext()).inflate(R.layout.layout_float_view, null);
        View flagFloatView = floatView.findViewById(R.id.flag_float_view);
        LinearLayout mContainerFun = floatView.findViewById(R.id.container_fun);

        //用于检测状态栏高度.
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) statusBarHeight = getResources().getDimensionPixelSize(resourceId);

        flagFloatView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isShowFun) { //不展示的情况下
                    isShowFun = !isShowFun;
                    mContainerFun.setVisibility(View.VISIBLE);
                } else {
                    isShowFun = !isShowFun;
                    mContainerFun.setVisibility(View.GONE);
                }
            }
        });

        flagFloatView.setOnTouchListener(new View.OnTouchListener() {
            int startX, startY;
            // 是否点击
            boolean isPerformClick;

            @Override
            public boolean onTouch(View v, MotionEvent event) { //加一个click和touch的if-else
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = (int) event.getX();
                        startY = (int) event.getY();
                        isPerformClick = true;
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        if (Math.abs(startX - event.getX()) >= mTouchSlop || Math.abs(startY - event.getY()) >= mTouchSlop) {
                            isPerformClick = false;

                            params.x = (int) event.getRawX() - 150;
                            params.y = (int) event.getRawY() - 150 - statusBarHeight;
                            windowManager.updateViewLayout(flagFloatView, params);
                        }
                        return true;
                    case MotionEvent.ACTION_UP:
                        if (isPerformClick) {
//                            flagFloatView.performClick();
                            handleClick(mContainerFun);
                        }
                        return !isPerformClick;
                }
                //更新悬浮窗的位置
//                params.x = (int) event.getRawX() - 150;
//                params.y = (int) event.getRawY() - 150 - statusBarHeight;
//                windowManager.updateViewLayout(flagFloatView, params);
                return false;
//                params.x = (int) event.getRawX() - 150;
//                params.y = (int) event.getRawY() - 150 - statusBarHeight;
//                windowManager.updateViewLayout(floatView,params);
//                return false;
            }
        });

        FloatWindow.with(getApplicationContext())
//                .setView(imageView)
                .setView(floatView)
                .setWidth(Screen.width, 0.2f) //设置悬浮控件宽高
//                .setHeight(Screen.width, 0.2f)
                .setHeight(Screen.width, 1f)
                .setX(Screen.width, 0.8f)
                .setY(Screen.height, 0.3f)
//                .setMoveType(MoveType.slide,100,-100)
//                .setMoveStyle(500, new BounceInterpolator())
//                .setFilter(true, A_Activity.class, C_Activity.class)
                .setViewStateListener(mViewStateListener)
                .setPermissionListener(mPermissionListener)
                .setDesktopShow(true)
                .build();
    }


    private void handleClick(View view){
        if (!isShowFun) { //不展示的情况下
            isShowFun = !isShowFun;
            view.setVisibility(View.VISIBLE);
        } else {
            isShowFun = !isShowFun;
//            mContainerFun.setVisibility(View.GONE);
            view.setVisibility(View.GONE);
        }
    }


    private final PermissionListener mPermissionListener = new PermissionListener() {
        @Override
        public void onSuccess() {
            Log.d(TAG, "onSuccess");
        }

        @Override
        public void onFail() {
            Log.d(TAG, "onFail");
        }
    };

    private final ViewStateListener mViewStateListener = new ViewStateListener() {
        @Override
        public void onPositionUpdate(int x, int y) {
            Log.d(TAG, "onPositionUpdate: x=" + x + " y=" + y);
        }

        @Override
        public void onShow() {
            Log.d(TAG, "onShow");
        }

        @Override
        public void onHide() {
            Log.d(TAG, "onHide");
        }

        @Override
        public void onDismiss() {
            Log.d(TAG, "onDismiss");
        }

        @Override
        public void onMoveAnimStart() {
            Log.d(TAG, "onMoveAnimStart");
        }

        @Override
        public void onMoveAnimEnd() {
            Log.d(TAG, "onMoveAnimEnd");
        }

        @Override
        public void onBackToDesktop() {
            Log.d(TAG, "onBackToDesktop");
        }
    };
}
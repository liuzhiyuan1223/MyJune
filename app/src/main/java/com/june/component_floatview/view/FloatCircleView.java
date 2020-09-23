package com.june.component_floatview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import com.june.R;
import com.june.common_util.WindowUtil;
import com.june.component_floatview.IUpdateFloatViewCallback;
import com.june.component_floatview.model.PositionInfo;

public class FloatCircleView extends LinearLayout {
    private IUpdateFloatViewCallback mUpdateCallback;
    private int startX;
    private int startY;

    public FloatCircleView(Context context) {
        super(context);
        initView(context);
    }

    public void addCallBack(IUpdateFloatViewCallback iUpdateFloatViewCallback) {
        this.mUpdateCallback = iUpdateFloatViewCallback;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = (int) event.getX(); //组件局部X
                startY = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                int posiX = (int) event.getRawX(); //屏幕绝对X
                int posiY = (int) event.getRawY();

                int statusBarHeight = WindowUtil.getStatusBarHeight(getContext());
                if (mUpdateCallback != null) {
                    mUpdateCallback.update(new PositionInfo(posiX - startX, posiY - startY - statusBarHeight ));
                }
                break;
            case MotionEvent.ACTION_UP:
                break;

            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    public FloatCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public FloatCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.layout_float_view, this, false);
    }
}

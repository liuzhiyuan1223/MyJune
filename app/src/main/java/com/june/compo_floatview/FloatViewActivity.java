package com.june.compo_floatview;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import com.june.R;
import com.june.common_util.WindowUtil;
import com.june.compo_floatview.model.PositionInfo;
import com.june.compo_floatview.view.FloatCircleView;

public class FloatViewActivity extends AppCompatActivity {

    private WindowManager mWindowManager;
    private FloatCircleView mView;
    private WindowManager.LayoutParams mLayoutParam;
    private Context mContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float_view);

        createFloatView();
    }

    void createFloatView() {
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        mLayoutParam = new WindowManager.LayoutParams();
        mView = new FloatCircleView(this);
        mView.addCallBack(new IUpdateFloatViewCallback() {
            @Override
            public void update(PositionInfo positionInfo) {
                updateFloatView(mView, positionInfo);
            }
        });

//        mLayoutParam.format = PixelFormat.RGBA_8888;
        mLayoutParam.gravity = Gravity.LEFT | Gravity.TOP;
        mLayoutParam.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        mLayoutParam.width = getResources().getDimensionPixelSize(R.dimen._50_dp);
        mLayoutParam.height = getResources().getDimensionPixelSize(R.dimen._50_dp);

        mLayoutParam.x = (int)(WindowUtil.getWindowWidth(mContext) * 3 / 4);
        mLayoutParam.y = (int)(WindowUtil.getWindowHeight(mContext) * 3 / 4);

        mWindowManager.addView(mView, mLayoutParam);
    }

    //更新floatView的位置
    private void updateFloatView(View view, PositionInfo positionInfo) {
        mLayoutParam.x = positionInfo.x;
        mLayoutParam.y = positionInfo.y;
        mWindowManager.updateViewLayout(view, mLayoutParam);
    }
}
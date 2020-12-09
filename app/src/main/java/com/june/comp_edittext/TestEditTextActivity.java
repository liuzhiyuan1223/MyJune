package com.june.comp_edittext;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.june.R;

public class TestEditTextActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "july6";
    private EditText mEtTestView;
    private FrameLayout flTest;
    private TextView mTvTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_edit_text);
        initGlobalView();

        initInputMode();
    }

    /**
     * 键盘的调起和隐藏
     * 1.键盘的状态描述:
     * (1)显式打开SHOW_FORCED / 显式关闭 : 用户的直接操作可以成为"显式"
     * (2)隐式打开SHOW_IMPLICIT / 隐式关闭 : 非用户的操作可以成为"隐式"
     *
     */
    private void initInputMode() {
        mEtTestView.post(new Runnable() {
            @Override
            public void run() {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                //1.
                imm.toggleSoftInputFromWindow(mEtTestView.getWindowToken(),0 ,0);

                //2. 弹出键盘
                imm.showSoftInput(mEtTestView, InputMethodManager.SHOW_IMPLICIT);

                //3. 设置了这个方法后，原本如果是弹出键盘的状态，则隐藏；反之亦然
                imm.toggleSoftInput(0, InputMethodManager.HIDE_IMPLICIT_ONLY);

                //4. 收起键盘
                imm.hideSoftInputFromWindow(TestEditTextActivity.this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

                //5. 获取输入法打开的状态
                boolean isSoftInputActivie = imm.isActive();


            }
        });

    }

    private void initGlobalView() {
        mEtTestView = findViewById(R.id.et_test);
        mEtTestView.setOnClickListener(this);
        mTvTv = findViewById(R.id.tv_tv);
        mTvTv.setOnClickListener(this);
        flTest = findViewById(R.id.fl_test);
        flTest.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.et_test:
                Log.d(TAG, "onClick: EditText ");
                break;
            case R.id.fl_test:
                Log.d(TAG, "onClick: FrameLayout ");
                break;
            case R.id.tv_tv:
                Log.d(TAG, "onClick: tv_tv ");
                break;
            default:
                break;
        }
    }
}
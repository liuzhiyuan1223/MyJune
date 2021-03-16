package com.june.comp_floatview.function_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.june.R;

public class FuncitonView extends LinearLayout {

    public FuncitonView(Context context) {
        super(context);
        init();
    }

    public FuncitonView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.float_function_view, this, true);
    }

}

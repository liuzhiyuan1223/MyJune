package com.june.comp_scroll.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.flyco.tablayout.SlidingTabLayout;
import com.jaeger.library.StatusBarUtil;
import com.june.R;
import com.june.comp_scroll.adapter.ElemeDetailAdapter;
import com.june.comp_scroll.fragment.FoodFragment;
import com.june.comp_scroll.fragment.TabFragment;
import com.june.comp_scroll.widget.ElemeFoodNestedScrollLayout;
import com.june.comp_scroll.widget.ElemeNestedScrollLayout;

public class TopBarLayout extends ConstraintLayout {
    public TopBarLayout(Context context) {
        super(context);
    }

    public TopBarLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TopBarLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int newHeightMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight() + getStatusBarHeight(), MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, newHeightMeasureSpec);
    }

    /**
     * 获取状态栏高度
     */
    private int getStatusBarHeight() {
        int resourceId = getContext().getResources().getIdentifier("status_bar_height", "dimen", "android");
        return getContext().getResources().getDimensionPixelSize(resourceId);
    }
}

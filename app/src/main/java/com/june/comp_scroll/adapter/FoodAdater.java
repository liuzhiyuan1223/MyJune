package com.june.comp_scroll.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.june.R;

import java.util.List;

/**
 * @author: pengguanming
 * @data: 2019-11-24
 * @function:
 */
public class FoodAdater extends BaseQuickAdapter<Integer, BaseViewHolder> {

    public FoodAdater(@Nullable List<Integer> data) {
        super(R.layout.item_food_laypout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Integer item) {
    }
}

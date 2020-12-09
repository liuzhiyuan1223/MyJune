package com.june.comp_scroll.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.june.R;
import com.june.comp_scroll.MyElemeActivity;
import com.june.comp_scroll.adapter.FoodAdater;


public class TabFragment extends Fragment {
    private String name;

    public static Fragment newInstance(String name) {
        Bundle args = new Bundle();
        args.putString("data",name);
        TabFragment fragment = new TabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!=null) {
            name=getArguments().getString("data");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text_layout, container, false);
        TextView textView = view.findViewById(R.id.tv_fragment_tab_text);
        textView.setText(name);
        return view;
    }
}

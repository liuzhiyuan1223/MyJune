package com.june.principle_android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.june.R;

public class MyFragment extends Fragment {

    private static final String ARG_PARAM = "param_key";
    private String mParam;
    private Activity mActivity;

    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (Activity) context;
        mParam = getArguments().getString(ARG_PARAM);  //获取参数
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.layout_of_frag, container, false);
        TextView view = root.findViewById(R.id.text);
        view.setText(mParam);
        return root;
    }
    public static MyFragment newInstance(String str) {
        MyFragment fragment = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM, str);
        fragment.setArguments(bundle);   //设置参数
        return fragment;
    }
}

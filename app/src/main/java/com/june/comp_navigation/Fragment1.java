package com.june.comp_navigation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.june.R;

public class Fragment1 extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return LayoutInflater.from(getContext()).inflate(R.layout.layout_fragment1, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //初始化action
//                findNavController().navigate(R.id.step_2, null);
                NavHostFragment.findNavController(Fragment1.this).navigate(R.id.action_fragment1_to_fragment2);
            }
        });


//        view.findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //初始化action
//                Navigation.createNavigateOnClickListener(R.id.next_action);
//            }
//        });

    }
}

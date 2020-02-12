package com.example.gb_android_client.Calculator;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gb_android_client.R;
import com.example.gb_android_client.myMVP.MyView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment implements MyView {


    public CalculatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculator, container, false);
    }

}

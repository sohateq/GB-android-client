package com.example.gb_android_client.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.gb_android_client.Calculator.CalculatorFragment;
import com.example.gb_android_client.MainActivity;
import com.example.gb_android_client.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeFragment extends Fragment {
    //логику отсюда перенести в презентер


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        textView.setText("This is home fragment");


        final Button button = root.findViewById(R.id.button_start_calculator);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculatorFragment calculatorFragment = new CalculatorFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, calculatorFragment);
                fragmentTransaction.addToBackStack("");
                fragmentTransaction.commit();

                ((MainActivity)getActivity()).hideBottomNavigation();

            }
        });

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        ((MainActivity)getActivity()).showBottomNavigation();
    }
}
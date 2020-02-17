package com.example.gb_android_client.Calculator;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gb_android_client.R;
import com.example.gb_android_client.myMVP.MyPresenter;
import com.example.gb_android_client.myMVP.MyView;

/**
 * A simple {@link Fragment} subclass.
 */
public class CalculatorFragment extends Fragment implements MyView {
    CalculatorPresenter presenter;
    TextView textViewResult;


    public CalculatorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_calculator, container, false);
        Button calcButton = root.findViewById(R.id.button_calc);
        final EditText editHeight = root.findViewById(R.id.calc_edit_text_height);
        final EditText editLenght = root.findViewById(R.id.calc_edit_text_lenght);
        textViewResult = root.findViewById(R.id.calc_text_view_result);

        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                presenter.calculatorStart(editHeight.getText().toString(),
                        editLenght.getText().toString());


            }
        });

        presenter = new CalculatorPresenter();
        presenter.attachView(this);
        return root;
    }

    public void showResult(int stairsFrameCount, int passFrameCount, int diagonalConnectionCount,
                           int horizontalConnectionCount, int crossbarCount, int deckCount,
                           int supportsCount, double costPerDay) {
        textViewResult.setText(String.format("Рама с лестницей = %s, Рама проходная = %s, Связь диагональная = %s, " +
                        "Связь горизонтальная = %s, Ригель настила = %s, Настил деревянный = %s, Опоры (пятки) = %s, стоимость в день %s",
                stairsFrameCount, passFrameCount, diagonalConnectionCount,
                horizontalConnectionCount, crossbarCount, deckCount,
                supportsCount, costPerDay));
        textViewResult.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}

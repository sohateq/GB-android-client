package com.example.gb_android_client.Calculator;

import com.example.gb_android_client.myMVP.MyPresenter;
import com.example.gb_android_client.myMVP.MyView;

public class CalculatorPresenter implements MyPresenter {
    MyView view;

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void attachView(MyView view) {
        this.view = view;
    }


}

package com.example.gb_android_client.myMVP;

public interface MyPresenter {
    void detachView();

    void attachView(MyView view);
}

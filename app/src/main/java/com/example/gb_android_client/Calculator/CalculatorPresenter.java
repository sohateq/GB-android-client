package com.example.gb_android_client.Calculator;

import com.example.gb_android_client.myMVP.MyPresenter;
import com.example.gb_android_client.myMVP.MyView;

public class CalculatorPresenter implements MyPresenter {

    CalculatorFragment view;

    double squareMeterCost = 0;

    /*Переменные:
    Высота - H;
    Длина - L;
    Количество ярусов - F = H/2;
    Количество секция - S = L/3;
    Количество подъемов - R (1 подъем на 30 м длины);
    Количество ярусов с настилами - D = F - 1;*/


    private int stairsFrameCount;   //Рама с лестницей = (F - 1) * R;
    private int passFrameCount;     //Рама проходная = F * ((S + 1) - D) + D;
    private int diagonalConnectionCount;    // Связь диагональная = (H/3 * L/2)/2;
    private int horizontalConnectionCount;  //Связь горизонтальная = Связь диагональная * 3;
    private int crossbarCount;  //Ригель настила = (D * S) * 2;
    private int deckCount;  //Настил деревянный = (S * D) * 3;
    private int supportsCount;  //Опоры (пятки) = ((L/3) + 1) * 2;
    private double costPerDay;  //стоимость в день


    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void attachView(MyView view) {
        this.view = (CalculatorFragment)view;
    }



    public void calculatorStart(int height, int length){
        calculate(height,length);
        view.showResult(stairsFrameCount, passFrameCount, diagonalConnectionCount,
        horizontalConnectionCount, crossbarCount, deckCount,
        supportsCount, costPerDay);
    }

    private void calculate (int height, int length) {

        if (height%2 == 1) height++;
        if (length%3 == 2) length++;
        if (length%3 == 1) length--;
        int levelCount = height/2;
        int sectionCount = length/3;
        int liftCount = 1 + (length/30);
        int deckLevelCount = 1;
        if (levelCount - 1 > 0) deckLevelCount = levelCount - 1;

        stairsFrameCount = (levelCount-1) * liftCount;
        passFrameCount = levelCount * ((sectionCount + 1) - deckLevelCount) + deckLevelCount;
        diagonalConnectionCount = ((height/3) * (length/2))/2;
        horizontalConnectionCount = diagonalConnectionCount * 3;
        crossbarCount = deckLevelCount * sectionCount * 2;
        deckCount = sectionCount * deckLevelCount * 3;
        supportsCount = (sectionCount + 1) * 2;
        costPerDay = height * length * squareMeterCost;
    }


}

package com.example.bmiapplication.Model;

import android.graphics.Color;

import java.math.BigDecimal;

public class BmiCalculator {

    /**
     * Round to certain number of decimals
     *
     * @param d
     * @param decimalPlace
     * @return
     */
    private float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

    /**
     *
     * @param height wysokosc w [cm]
     * @param weight waga w kg
     * @return obliczone bmi
     */
    public String CalculateToString(float height, float weight){
        height/=100;
        //double bmi = Math.round(weight/(height*height)*100)/100;
        float bmi=weight/(height*height);
        String wynik = Float.toString(round(bmi,1));
        return wynik;
    }

}

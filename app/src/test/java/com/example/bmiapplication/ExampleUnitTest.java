package com.example.bmiapplication;

import com.example.bmiapplication.Model.BmiCalculator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void bmiCalculatorTest(){
        BmiCalculator bmiCalculator = new BmiCalculator();
        String wynik = bmiCalculator.CalculateToString(175,75);
        Assert.assertEquals("24.5",wynik);
    }

}

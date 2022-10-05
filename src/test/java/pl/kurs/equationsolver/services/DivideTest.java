package pl.kurs.equationsolver.services;

import org.junit.Assert;
import org.junit.Test;

public class DivideTest {

    Divide divide = new Divide();

    @Test
    public void getResult() {

        int a = 50;
        int b = 10;

        int expectedResult = 5;

        int result = divide.getResult(a, b);


        Assert.assertEquals(expectedResult, result);

    }





}
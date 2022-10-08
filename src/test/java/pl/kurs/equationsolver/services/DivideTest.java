package pl.kurs.equationsolver.services;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class DivideTest {

    Divide divide = new Divide();

    @Test
    public void getResult() {

        BigDecimal a = BigDecimal.valueOf(50);
        BigDecimal b = BigDecimal.valueOf(10);

        BigDecimal expectedResult = BigDecimal.valueOf(5);

        BigDecimal result = divide.getResult(a, b);


        Assert.assertEquals(expectedResult, result);

    }





}
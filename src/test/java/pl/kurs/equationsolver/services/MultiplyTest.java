package pl.kurs.equationsolver.services;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class MultiplyTest {

    Multiply multiply = new Multiply();

    @Test
    public void getResult() {

        BigDecimal a = BigDecimal.valueOf(50);
        BigDecimal b = BigDecimal.valueOf(10);

        BigDecimal expectedResult = BigDecimal.valueOf(500);

        BigDecimal result = multiply.getResult(a, b);


        Assert.assertEquals(expectedResult, result);

    }

}
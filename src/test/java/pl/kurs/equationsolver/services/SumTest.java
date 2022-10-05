package pl.kurs.equationsolver.services;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SumTest {

    Sum sum = new Sum();

    @Test
    public void getResult() {

        int a = 50;
        int b = 10;

        int expectedResult = 60;

        int result = sum.getResult(a, b);


        Assert.assertEquals(expectedResult, result);

    }

}
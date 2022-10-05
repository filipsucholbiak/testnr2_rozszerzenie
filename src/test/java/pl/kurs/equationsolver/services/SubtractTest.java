package pl.kurs.equationsolver.services;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SubtractTest {

    Subtract subtract = new Subtract();

    @Test
    public void getResult() {

        int a = 50;
        int b = 10;

        int expectedResult = 40;

        int result = subtract.getResult(a, b);


        Assert.assertEquals(expectedResult, result);

    }

}
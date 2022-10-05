package pl.kurs.equationsolver.services;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MultiplyTest {

    Multiply multiply = new Multiply();

    @Test
    public void getResult() {

        int a = 50;
        int b = 10;

        int expectedResult = 500;

        int result = multiply.getResult(a, b);


        Assert.assertEquals(expectedResult, result);

    }

}
package pl.kurs.equationsolver.services;

import java.math.BigDecimal;

public class Sum implements ISolving {

    @Override
    public Integer getResult(int a, int b) {
        return a + b;
    }
}

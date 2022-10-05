package pl.kurs.equationsolver.services;

import java.math.BigDecimal;

public class Multiply implements ISolving {

    @Override
    public Integer getResult(int a, int b) {
        return a * b;
    }
}

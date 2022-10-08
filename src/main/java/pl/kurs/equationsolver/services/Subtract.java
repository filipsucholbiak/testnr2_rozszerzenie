package pl.kurs.equationsolver.services;

import java.math.BigDecimal;

public class Subtract implements ISolving {

    @Override
    public BigDecimal getResult(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }
}

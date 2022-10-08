package pl.kurs.equationsolver.services;

import java.math.BigDecimal;

public class Sum implements ISolving {

    @Override
    public BigDecimal getResult(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }
}

package pl.kurs.equationsolver.services;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Multiply implements IOperator {

    @Override
    public BigDecimal getResult(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }
}

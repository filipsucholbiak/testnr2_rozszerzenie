package pl.kurs.equationsolver.services;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Subtract implements IOperator {

    @Override
    public BigDecimal getResult(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }
}

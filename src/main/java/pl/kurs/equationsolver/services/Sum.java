package pl.kurs.equationsolver.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Sum implements IOperator {

    @Override
    public BigDecimal getResult(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }
}

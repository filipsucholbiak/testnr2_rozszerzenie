package pl.kurs.equationsolver.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public interface IOperator {

   BigDecimal getResult(BigDecimal a, BigDecimal b);
}

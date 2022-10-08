package pl.kurs.equationsolver.services;

import pl.kurs.equationsolver.exceptions.InvalidEquationFormatException;
import pl.kurs.equationsolver.exceptions.UnknownOperatorException;

import java.math.BigDecimal;

public interface ISolvingService {

    BigDecimal evaluateExpression(String expression) throws InvalidEquationFormatException, UnknownOperatorException;
}

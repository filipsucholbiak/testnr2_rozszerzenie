package pl.kurs.equationsolver.services;

import pl.kurs.equationsolver.exceptions.InvalidEquationFormatException;
import pl.kurs.equationsolver.exceptions.UnknownOperatorException;

public interface ISolvingService {

    Integer evaluateExpression(String expression) throws InvalidEquationFormatException, UnknownOperatorException;
}

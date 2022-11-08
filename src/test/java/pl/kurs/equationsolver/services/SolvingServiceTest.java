package pl.kurs.equationsolver.services;

import org.junit.Assert;
import org.junit.Test;
import pl.kurs.equationsolver.dao.SolvingEventDao;
import pl.kurs.equationsolver.exceptions.InvalidEquationFormatException;
import pl.kurs.equationsolver.exceptions.UnknownOperatorException;

import java.math.BigDecimal;


public class SolvingServiceTest {


    @Test
    public void evaluateExpressionTest() throws InvalidEquationFormatException, UnknownOperatorException {


        SolvingService solvingService = new SolvingService(new SolvingEventService(new SolvingEventDao()));
        BigDecimal evaluateExpression = solvingService.evaluateExpression("2 + 2 * 2");

        Assert.assertEquals(evaluateExpression.doubleValue(), 6.0, 0);

    }
}
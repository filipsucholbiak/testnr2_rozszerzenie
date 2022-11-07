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

        BigDecimal result = BigDecimal.valueOf(2 + 2 * 2);

        SolvingService solvingService = new SolvingService(new SolvingEventService(new SolvingEventDao()));
        BigDecimal evaluateExpression = solvingService.evaluateExpression("2 + 2 * 2");

        Assert.assertEquals(result, evaluateExpression);

    }
}
package pl.kurs.equationsolver.services;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pl.kurs.equationsolver.app.Main;
import pl.kurs.equationsolver.dao.SolvingEventDao;
import pl.kurs.equationsolver.exceptions.InvalidEquationFormatException;
import pl.kurs.equationsolver.exceptions.UnknownOperatorException;
import pl.kurs.equationsolver.model.SolvingEvent;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class SolvingServiceTest {


    @Test
    public void evaluateExpressionTest() throws InvalidEquationFormatException, UnknownOperatorException {

        BigDecimal result = BigDecimal.valueOf(2 + 2 * 2);

        ISolvingService solvingService = new SolvingService(new SolvingEventService(new SolvingEventDao()));
        BigDecimal evaluateExpression = solvingService.evaluateExpression("2 + 2 * 2");

        Assert.assertEquals(result, evaluateExpression);

    }
}
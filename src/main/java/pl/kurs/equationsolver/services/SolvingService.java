package pl.kurs.equationsolver.services;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import pl.kurs.equationsolver.app.Main;
import pl.kurs.equationsolver.exceptions.InvalidEquationFormatException;
import pl.kurs.equationsolver.exceptions.UnknownOperatorException;
import pl.kurs.equationsolver.model.SolvingEvent;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Stack;

@ComponentScan(basePackages = "pl.kurs")
@Service
public class SolvingService implements ISolvingService {


    private ISolvingEventService solvingEventService;

    public SolvingService(ISolvingEventService solvingEventService) {
        this.solvingEventService = solvingEventService;
    }

    @Override
    public BigDecimal evaluateExpression(String expression) throws InvalidEquationFormatException, UnknownOperatorException {


        char[] tokens = expression.toCharArray();
        SolvingEvent solvingEvent = new SolvingEvent(Timestamp.from(Instant.now()), expression);

        Stack<BigDecimal> values = new Stack<>();

        Stack<Character> ops = new
                Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {

            if (tokens[i] == ' ')
                continue;

            if (tokens[i] >= '0' &&
                    tokens[i] <= '9') {
                StringBuffer sbuf = new
                        StringBuffer();

                while (i < tokens.length &&
                        tokens[i] >= '0' &&
                        tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                values.push(BigDecimal.valueOf(Integer.parseInt(sbuf.
                        toString())));

                i--;
            } else if (tokens[i] == '(')
                ops.push(tokens[i]);

            else if (tokens[i] == ')') {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(),
                            values.pop(),
                            values.pop()));
                ops.pop();
            } else if (tokens[i] == '+' ||
                    tokens[i] == '-' ||
                    tokens[i] == '*' ||
                    tokens[i] == '/') {

                while (!ops.empty() &&
                        hasPrecedence(tokens[i],
                                ops.peek()))
                    values.push(applyOp(ops.pop(),
                            values.pop(),
                            values.pop()));

                ops.push(tokens[i]);
            }
        }

        while (!ops.empty())
            values.push(applyOp(ops.pop(),
                    values.pop(),
                    values.pop()));




        return values.pop();
    }

    public static boolean hasPrecedence(
            char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') &&
                (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }


    public static BigDecimal applyOp(char op,
                                     BigDecimal b, BigDecimal a) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SolvingService.class);

        Sum sum = ctx.getBean(Sum.class);
        Subtract subtract = ctx.getBean(Subtract.class);
        Multiply multiply = ctx.getBean(Multiply.class);
        Divide divide = ctx.getBean(Divide.class);


        BigDecimal current = new BigDecimal(0);

        switch (op) {
            case '+':
                current = sum.getResult(a, b);
                break;
            case '-':
                current = subtract.getResult(a, b);
                break;
            case '*':
                current = multiply.getResult(a, b);
                break;
            case '/':
                if (b.equals(0))
                    throw new
                            UnsupportedOperationException(
                            "nie można dzielić przez 0");
                current = divide.getResult(a, b);
                break;
        }
        return current;
    }
}




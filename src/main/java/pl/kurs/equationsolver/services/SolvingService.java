package pl.kurs.equationsolver.services;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import pl.kurs.equationsolver.exceptions.InvalidEquationFormatException;
import pl.kurs.equationsolver.exceptions.UnknownOperatorException;
import pl.kurs.equationsolver.model.SolvingEvent;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;


@ComponentScan(basePackages = "pl.kurs")
@Service
public class SolvingService implements ISolvingService {

    private ISolvingEventService solvingEventService;


    public SolvingService(ISolvingEventService solvingEventService) {
        this.solvingEventService = solvingEventService;
    }

    static final Map<Character, IOperator> I_OPERATOR_MAP = new HashMap<>();

    static {
        I_OPERATOR_MAP.put('+', new Sum());
        I_OPERATOR_MAP.put('-', new Subtract());
        I_OPERATOR_MAP.put('*', new Multiply());
        I_OPERATOR_MAP.put('/', new Divide());

    }


    @Override
    public BigDecimal evaluateExpression(String expression) throws InvalidEquationFormatException, UnknownOperatorException {


        char[] tokens = expression.toCharArray();


        Stack<BigDecimal> values = new Stack<>();

        Stack<Character> ops = new Stack<Character>();

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
                values.push(BigDecimal.valueOf(Double.parseDouble(sbuf.
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

        SolvingEvent solvingEvent = new SolvingEvent(Timestamp.from(Instant.now()), expression);


        new SolvingEventSaverRunnable(solvingEventService, solvingEvent);


        return values.pop();
    }

    public static boolean hasPrecedence(
            char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        return (op1 != '*' && op1 != '/') ||
                (op2 != '+' && op2 != '-');
    }


    public static BigDecimal applyOp(char op, BigDecimal b, BigDecimal a) {

        BigDecimal current = new BigDecimal(0);

        switch (op) {
            case '+':
                current = I_OPERATOR_MAP.get('+').getResult(a, b);
                break;
            case '-':
                current = I_OPERATOR_MAP.get('-').getResult(a, b);
                break;
            case '*':
                current = I_OPERATOR_MAP.get('*').getResult(a, b);
                break;
            case '/':
                if (b.equals(0))
                    throw new
                            UnsupportedOperationException(
                            "nie można dzielić przez 0");
                current = I_OPERATOR_MAP.get('/').getResult(a, b);
                break;
        }
        return current;

    }

}







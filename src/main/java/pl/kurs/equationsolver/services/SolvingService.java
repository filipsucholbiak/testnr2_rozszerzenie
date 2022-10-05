package pl.kurs.equationsolver.services;


import pl.kurs.equationsolver.exceptions.InvalidEquationFormatException;
import pl.kurs.equationsolver.exceptions.UnknownOperatorException;
import pl.kurs.equationsolver.model.SolvingEvent;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Stack;

@Service
public class SolvingService implements ISolvingService{

    private ISolvingEventService solvingEventService;
    private SolvingEventSaveExecutorService solvingEventSaveExecutorService;

    public SolvingService(ISolvingEventService solvingEventService, SolvingEventSaveExecutorService solvingEventSaveExecutorService) {
        this.solvingEventService = solvingEventService;
        this.solvingEventSaveExecutorService = solvingEventSaveExecutorService;
    }

    @Override
    public Integer evaluateExpression(String expression) throws InvalidEquationFormatException, UnknownOperatorException {

            char[] tokens = expression.toCharArray();

            Stack<Integer> values = new
                    Stack<Integer>();

            Stack<Character> ops = new
                    Stack<Character>();

            for (int i = 0; i < tokens.length; i++)
            {

                if (tokens[i] == ' ')
                    continue;

                if (tokens[i] >= '0' &&
                        tokens[i] <= '9')
                {
                    StringBuffer sbuf = new
                            StringBuffer();

                    while (i < tokens.length &&
                            tokens[i] >= '0' &&
                            tokens[i] <= '9')
                        sbuf.append(tokens[i++]);
                    values.push(Integer.parseInt(sbuf.
                            toString()));

                    i--;
                }

                else if (tokens[i] == '(')
                    ops.push(tokens[i]);

                else if (tokens[i] == ')')
                {
                    while (ops.peek() != '(')
                        values.push(applyOp(ops.pop(),
                                values.pop(),
                                values.pop()));
                    ops.pop();
                }

                else if (tokens[i] == '+' ||
                        tokens[i] == '-' ||
                        tokens[i] == '*' ||
                        tokens[i] == '/')
                {

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

        solvingEventSaveExecutorService.submitAndExecute(
                new SolvingEventSaverRunnable(solvingEventService ,solvingEvent)
        );

            return values.pop();
        }

        public static boolean hasPrecedence(
        char op1, char op2)
        {
            if (op2 == '(' || op2 == ')')
                return false;
            if ((op1 == '*' || op1 == '/') &&
                    (op2 == '+' || op2 == '-'))
                return false;
            else
                return true;
        }

        public static int applyOp(char op,
        int b, int a)
        {
            switch (op)
            {
                case '+':
                    return a + b;
                case '-':
                    return a - b;
                case '*':
                    return a * b;
                case '/':
                    if (b == 0)
                        throw new
                                UnsupportedOperationException(
                                "nie można dzielić przez 0");
                    return a / b;
            }
            return 0;
        }
    }




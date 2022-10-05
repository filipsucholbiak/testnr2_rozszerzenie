package pl.kurs.equationsolver.trash;

import pl.kurs.equationsolver.services.Divide;
import pl.kurs.equationsolver.services.Multiply;
import pl.kurs.equationsolver.services.Subtract;
import pl.kurs.equationsolver.services.Sum;

import java.math.BigDecimal;

public class Calculator {
    private static Calculator calculator;
    private BigDecimal current = new BigDecimal( 0 );

    private Calculator()
    {

    }

    public static Calculator getInstance()
    {
        if ( calculator == null )
        {
            calculator = new Calculator();
        }
        return calculator;
    }

    public void operation( char operator, BigDecimal number1, BigDecimal number2 )
    {

        switch ( operator )
        {
            case '+':
                current = new BigDecimal(String.valueOf(new Sum()));
                break;
            case '-':
                current = new BigDecimal(String.valueOf(new Subtract()));
                break;
            case '/':
                current = new BigDecimal(String.valueOf(new Divide()));;
                break;
            case '*':
                current = new BigDecimal(String.valueOf(new Multiply()));;
                break;
            default:
                break;
        }
    }

    public BigDecimal getCurrent() {
        return current;
    }

    public void setCurrent(BigDecimal current) {
        this.current = current;
    }
}

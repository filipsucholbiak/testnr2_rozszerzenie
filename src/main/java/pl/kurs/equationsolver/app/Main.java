package pl.kurs.equationsolver.app;

import pl.kurs.equationsolver.exceptions.InvalidEquationFormatException;
import pl.kurs.equationsolver.exceptions.UnknownOperatorException;
import pl.kurs.equationsolver.services.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.math.BigDecimal;
import java.util.Scanner;

@ComponentScan(basePackages = "pl.kurs")
public class Main {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);

        ISolvingService solvingService = ctx.getBean(ISolvingService.class);


        try {

            BigDecimal evaluateExpression = solvingService.evaluateExpression(args[0]);
            System.out.println("wynik:" + evaluateExpression);
        } catch (InvalidEquationFormatException | UnknownOperatorException e) {
            e.printStackTrace();
        }


    }


}


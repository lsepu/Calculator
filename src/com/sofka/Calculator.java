package com.sofka;

import java.util.stream.IntStream;

public class Calculator {

    private static final ISum sum = (x,y) -> x+y;

    private static final ISubtract subtract = (x, y) -> x-y;

    private static final IMultiply multiply = (x,y) -> IntStream.range(0, y).reduce(0,(a,b) -> sum.calculate(x,a));

    /**
     * using recursion to count the iterations.
     * @return -1 if 0 is the divisor
     * @return 0 if 0 is the dividend
     * @return the result of the division if it has the appropriate values
     */
    private static final IDivide division = (x,y) ->
            y == 0 ? -1 :
                    x == 0 ? 0 :
                            subtract.calculate(x,y) == 0 ? 1 : Calculator.division.calculate(subtract.calculate(x,y), y) + 1;

    public static void main(String[] args) {

        System.out.println("Sum example: " + sum.calculate(10,2));
        System.out.println("Subtraction example: " + subtract.calculate(10,2));
        System.out.println("Multiplication example: " + multiply.calculate(10,2));

        Integer divisionByZero = division.calculate(2,0);

        System.out.println("Division example: " + division.calculate(24,2));
        System.out.println("Division example with 0 as dividend: " + division.calculate(0,2));
        System.out.println("Division example with 0 as divisor: " + (divisionByZero == -1 ? "Error" : divisionByZero));

    }


}

package com.sofka;

import java.util.stream.IntStream;

public class Calculator {

    private static final ISum sum = (x,y) -> x+y;

    private static final ISubtract substract = (x, y) -> x-y;

    private static final IMultiply multiply = (x,y) -> IntStream.range(0, y).reduce(0,(a,b) -> sum.calculate(x,a));

    //using recursion to count the iterations. the number 1 is used as base case
    private static final IDivide division = (x,y) -> substract.calculate(x,y) == 0 ? 1 : Calculator.division.calculate(substract.calculate(x,y), y) + 1;

    public static void main(String[] args) {

        System.out.println("Sum example: " + sum.calculate(10,2));
        System.out.println("Subtraction example: " + substract.calculate(10,2));
        System.out.println("Multiplication example: " + multiply.calculate(10,2));
        System.out.println("Division example: " + division.calculate(24,2));

    }
}

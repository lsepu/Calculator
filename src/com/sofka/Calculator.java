package com.sofka;

import java.util.stream.IntStream;

public class Calculator {

    private static final ISum sum = (x,y) -> x+y;

    private static final ISubtract subtract = (x, y) -> x-y;

    private static final IMultiply multiply = (x,y) -> IntStream.range(0, y).reduce(0,(a,b) -> sum.calculate(x,a));

    //using recursion to count the iterations.
    private static final IDivide division = (x,y) -> subtract.calculate(x,y) == 0 ? 1 : Calculator.division.calculate(subtract.calculate(x,y), y) + 1;

    public static void main(String[] args) {

        System.out.println("Sum example: " + sum.calculate(10,2));
        System.out.println("Subtraction example: " + subtract.calculate(10,2));
        System.out.println("Multiplication example: " + multiply.calculate(10,2));
        System.out.println("Division example: " + division.calculate(24,2));

    }
}

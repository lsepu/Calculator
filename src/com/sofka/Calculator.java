package com.sofka;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Calculator {

    public static void main(String[] args) {
        ISum sum = (x,y) -> x+y;
        ISubstract substract = (x,y) -> x-y;
        IMultiply multiply = (x,y) -> IntStream.range(0, y).reduce(0,(a,b) -> x+a);


        System.out.println("Sum example: " + sum.calculate(3,2));
        System.out.println("Substraction example: " + substract.calculate(3,2));
        System.out.println("Multiplication example: " + multiply.calculate(3,2));

    }
}

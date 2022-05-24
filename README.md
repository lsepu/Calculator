# Calculator
Simple calculator that only uses sums and subtractions to operate numbers. The funcional interfaces were used in order to solve this problem

## Functional interfaces

```java
    private static final ISum sum = (x,y) -> x+y;

    private static final ISubtract subtract = (x, y) -> x-y;

    private static final IMultiply multiply = (x,y) -> IntStream.range(0, y).reduce(0,(a,b) -> sum.calculate(x,a));

    //using recursion to sum the iterations
    private static final IDivide division = (x,y) -> subtract.calculate(x,y) == 0 ? 1 : Calculator.division.calculate(subtract.calculate(x,y), y) + 1;
```

## Print screenshots

![code](https://i.imgur.com/UTlzArH.png)

![result](https://i.imgur.com/RAnTpIP.png)

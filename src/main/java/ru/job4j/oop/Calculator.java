package ru.job4j.oop;

public class Calculator {

    private static final int X = 5;

    public static int sum(int y) {
        return X + y;
    }

    public int multiply(int a) {
        return X * a;
    }

    public static int minus(int a) {
        return a - X;
    }

    public int divide(int a) {
        return a / X;
    }

    public int sumAllOperation(int a) {
        return sum(a) + multiply(a) + minus(a) + divide(a);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.multiply(5);
        System.out.println(result);
        result = Calculator.minus(5);
        System.out.println(result);
        result = calculator.divide(20);
        System.out.println(result);
        result = calculator.sumAllOperation(50);
        System.out.println(result);
    }
}

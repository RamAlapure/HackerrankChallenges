package com.pluralsight.dp.strategy;

public class Calculate {

    private final Operation operation;

    public Calculate(Operation operation) {
        this.operation = operation;
    }

    public void execute(int... args) {
        this.operation.execute(args);
    }

    public static void main(String[] args) {
        Calculate calculate = new Calculate(new Addition());
        calculate.execute(1, 2, 3);

        calculate = new Calculate(new Subtraction());
        calculate.execute(3, 2, 1);
    }
}

package com.pluralsight.dp.strategy;

import java.util.Arrays;

public interface Operation {

    void execute(int... args);
}

class Addition implements Operation {

    @Override
    public void execute(int... args) {
        int sum = Arrays.stream(args).sum();
        System.out.println("Addition: " + sum);
    }
}

class Subtraction implements Operation {

    @Override
    public void execute(int... args) {
        int result = args[0];
        for (int i = 1; i < args.length; i++) {
            result = result - args[i];
        }
        System.out.println("Subtraction: " + result);
    }
}
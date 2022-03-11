package com.hackerrank.challenges;

public class Fibonacci {

    public static void main(String[] args) {
        int n = 10;
        int fib = fibonacci(n, new int[n + 1]);
        System.out.println(fib);
    }

    private static int fibonacci(int n, int[] fib) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (fib[n] != 0) return fib[n];
        fib[n] = fibonacci(n - 1, fib) + fibonacci(n - 2, fib);
        return fib[n];
    }
}

package com.hackerrank.ip.day1;

import java.util.List;

public class PlusMinus {

    public static void main(String[] args) {
        int n = 3;
        int d = 5;
        double v = (double) n / d;
        System.out.println(String.format("%.6f", v));
    }

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        int[] ints = new int[3];
        for (int n : arr) {
            if (n > 0) ints[0]++;
            else if (n < 0) ints[1]++;
            else ints[2]++;
        }

        for (int n : ints) System.out.printf("%.6f%n", (double) n / arr.size());

    }
}

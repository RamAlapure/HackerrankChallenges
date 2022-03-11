package com.hackerrank.challenges;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class RadixSort {

    public static void main(String[] args) {
        int[] input = new int[]{5, 12, 234, 7, 9875, 62};

        IntSummaryStatistics statistics = Arrays.stream(input, 0, input.length).summaryStatistics();
        int max = statistics.getMax();
        int exp = 1;
        while (exp <= max) {
            countSort(input, exp);
            exp = exp * 10;
        }
        System.out.println(Arrays.toString(input));
    }

    private static void countSort(int[] input, int exp) {
        int[] farr = new int[10];
        IntStream.range(0, input.length).forEach(i -> farr[input[i] / exp % 10]++); // frequency
        IntStream.range(1, farr.length).forEach(i -> farr[i] += farr[i - 1]); // indexing
        int[] output = new int[input.length];
        for (int i = input.length - 1; i >= 0; i--) {
            int val = input[i];
            output[--farr[input[i] / exp % 10]] = val;
        }
        for (int i = 0; i < input.length; i++) {
            input[i] = output[i];
        }
    }
}

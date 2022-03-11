package com.hackerrank.challenges;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class CountSort {

    public static void main(String[] args) {

        int[] input = new int[]{7, 9, 5, 8, 3, 6, 2, 1, 8, 5, 6, 7, 8, 9};

        IntSummaryStatistics statistics = Arrays.stream(input, 0, input.length).summaryStatistics();
        int min = statistics.getMin();
        int max = statistics.getMax();
        System.out.println("min = " + min);
        System.out.println("max = " + max);
        int[] output = countSort(input, min, max);
        System.out.println(Arrays.toString(output));
    }

    private static int[] countSort(int[] input, int min, int max) {
        int[] farr = new int[max - min + 1];
        IntStream.range(0, input.length).forEach(i -> farr[input[i] - min]++); // frequency
        System.out.println(Arrays.toString(farr));
        IntStream.range(1, farr.length).forEach(i -> farr[i] = farr[i - 1] + farr[i]); // indexing
        System.out.println(Arrays.toString(farr));
        int[] output = new int[input.length];
        for (int i = input.length - 1; i >= 0; i--) {
            int val = input[i];
            output[--farr[val - min]] = val;
        }
        return output;
    }
}

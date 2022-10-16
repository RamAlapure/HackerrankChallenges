package com.hackerrank.Algorithm.Implementation;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class PickingNumbers {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 1, 2, 2, 4, 4, 5, 5, 5); // Arrays.asList(4, 6, 5, 3, 3, 1); //
        System.out.println(pickingNumbers(a));
    }

    public static int pickingNumbers(List<Integer> a) {
        IntSummaryStatistics statistics = a.stream().mapToInt(n -> n).summaryStatistics();
        int max = statistics.getMax();
        int frequency[] = new int[max + 1];
        int result = Integer.MIN_VALUE;

        a.forEach(index -> frequency[index]++);

        for (int i = 0; i < max; i++) {
            result = Math.max(result, frequency[i] + frequency[i + 1]);
        }
        return result;
    }

}

package com.hackerrank.Algorithm.Implementation;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class HurdleRace {

    public static void main(String[] args) {

        System.out.println(hurdleRace(7, Arrays.asList(2, 5, 4, 5, 2)));
    }

    public static int hurdleRace(int k, List<Integer> height) {
        IntSummaryStatistics statistics = height.stream().mapToInt(n -> n).summaryStatistics();
        int max = statistics.getMax();
        return max > k ? max - k : 0;
    }
}

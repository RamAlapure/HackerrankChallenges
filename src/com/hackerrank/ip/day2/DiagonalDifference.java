package com.hackerrank.ip.day2;

import java.util.List;

public class DiagonalDifference {

    public static int diagonalDifference(List<List<Integer>> arr) {
        int n = arr.size();
        int d1 = 0, d2 = 0;
        int j = n - 1;
        for (int i = 0; i < n; i++) {
            d1 += arr.get(i).get(i);
            d2 += arr.get(i).get(j);
            j--;
        }

        return Math.abs(d1 - d2);
    }
}

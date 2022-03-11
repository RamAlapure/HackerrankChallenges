package com.hackerrank.DataStructures;

import java.util.List;

public class ArrayManipulation {

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        long[] arr = new long[n];
        queries.forEach(query -> {
            int a = query.get(0);
            int b = query.get(1);
            int k = query.get(2);
            arr[a - 1] += k;
            if (arr.length > b) arr[b] -= k;
        });
        long max = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i] = arr[i] + arr[i - 1];
            max = Math.max(arr[i], max);
        }
        return max;
    }

    // brute force approach
    public static long arrayManipulation1(int n, List<List<Integer>> queries) {
        long[] max = new long[]{Long.MIN_VALUE};
        long[] arr = new long[n];

        queries.forEach(query -> {
            int a = query.get(0);
            int b = query.get(1);
            int k = query.get(2);
            for (int i = a - 1; i < b; i++) {
                arr[i] += k;
                max[0] = Math.max(max[0], arr[i]);
            }
        });

        return max[0];
    }

}
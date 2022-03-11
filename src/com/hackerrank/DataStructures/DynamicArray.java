package com.hackerrank.DataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class DynamicArray {

    static int lastAnswer = 0;
    static List<List<Integer>> arr = new ArrayList<>();
    static List<Integer> ans = new ArrayList<>();

    public static void initialize(int n) {
        IntStream.range(0, n).forEach(i -> arr.add(i, new ArrayList<>()));
    }

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        initialize(n);
        queries.forEach(query -> {
            int x = query.get(1);
            int y = query.get(2);
            if (query.get(0) == 1) query1(x, y, n);
            else query2(x, y, n);
        });

        return ans;
    }

    public static void query1(int x, int y, int n) {
        int idx = (x ^ lastAnswer) % n;
        arr.get(idx).add(y);
    }

    public static void query2(int x, int y, int n) {
        int idx = (x ^ lastAnswer) % n;
        lastAnswer = arr.get(idx).get(y % arr.get(idx).size());
        ans.add(lastAnswer);
    }

}

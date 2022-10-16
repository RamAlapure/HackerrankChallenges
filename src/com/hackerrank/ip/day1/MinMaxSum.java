package com.hackerrank.ip.day1;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

public class MinMaxSum {

    public static void miniMaxSum(List<Integer> arr) {
        Collections.sort(arr);
        BigInteger min = new BigInteger(arr.get(0).toString());
        BigInteger max = new BigInteger(arr.get(arr.size() - 1).toString());
        BigInteger total = new BigInteger("0");
        for (int i = 1; i < 4; i++) total = sum(total, new BigInteger(arr.get(i).toString()));

        min = sum(min, total);
        max = sum(max, total);

        System.out.println(min + " " + max);

    }

    private static BigInteger sum(BigInteger a, BigInteger b) {
        return a.add(b);
    }
}

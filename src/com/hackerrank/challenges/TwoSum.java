package com.hackerrank.challenges;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    private TwoSum() {
    }

    private static int[] twoSum(int[] a, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int val = a[i];
            int delta = target - val;
            if (map.containsKey(delta)) {
                return new int[]{map.get(delta), i};
            }
            map.put(val, i);
        }
        throw new IllegalStateException("No match found");
    }
}

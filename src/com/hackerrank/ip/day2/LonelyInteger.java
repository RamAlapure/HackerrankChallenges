package com.hackerrank.ip.day2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LonelyInteger {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 3, 2, 1);
        int lonelyInteger = lonelyInteger(a);
        System.out.println(lonelyInteger);
    }

    public static int lonelyInteger(List<Integer> a) {
        Map<Integer, Integer> map = new HashMap<>();

        a.forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));

        return map.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().get().getKey();

    }

    public static int lonelyInt(List<Integer> a) {
        return a.stream().mapToInt(n -> n).reduce(0, (a1, b) -> a1 ^ b);
    }
}

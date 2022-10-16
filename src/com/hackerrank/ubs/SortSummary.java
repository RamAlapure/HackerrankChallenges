package com.hackerrank.ubs;

import java.util.*;

public class SortSummary {

    public static List<List<Integer>> groupSort(List<Integer> arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        arr.forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByKey());
        list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        list.forEach(entry -> {
            List<Integer> l = new ArrayList<>();
            l.add(entry.getKey());
            l.add(entry.getValue());
            ans.add(l);
        });

        return ans;
    }
}

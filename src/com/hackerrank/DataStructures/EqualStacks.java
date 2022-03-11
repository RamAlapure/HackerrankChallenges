package com.hackerrank.DataStructures;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EqualStacks {

    public static void main(String[] args) {
        int[] a1 = {3, 2, 1, 1, 1};
        int[] a2 = {4, 3, 2};
        int[] a3 = {1, 1, 4, 1};

        int h = equalStacks(getList(a1), getList(a2), getList(a3));
        System.out.println(h);
    }

    private static List<Integer> getList(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        int hs1 = sum(h1), hs2 = sum(h2), hs3 = sum(h3);
        int min = Math.min(hs3, Math.min(hs1, hs2));
        while (hs1 != hs2 || hs2 != hs3) {
            hs1 = pop(hs1, min, h1);
            hs2 = pop(hs2, min, h2);
            hs3 = pop(hs3, min, h3);
            min = Math.min(hs3, Math.min(hs1, hs2));
        }
        return hs1;
    }

    private static int sum(List<Integer> list) {
        return list.stream().mapToInt(n -> n).sum();
    }

    private static int pop(int h, int min, List<Integer> list) {
        if (h > min) {
            Integer n = list.remove(0);
            h -= n;
        }
        return h;
    }

}

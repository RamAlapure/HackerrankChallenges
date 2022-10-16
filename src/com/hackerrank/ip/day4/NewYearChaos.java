package com.hackerrank.ip.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewYearChaos {

    public static void main(String[] args) {
        minimumBribes(new ArrayList<>(Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4)));
    }

    public static void minimumBribes(List<Integer> q) {
        int swapCount = 0;
        for (int i = q.size() - 1; i >= 0; i--) {
            if (q.get(i) != i + 1) {
                if (i - 1 >= 0 && q.get(i - 1) == i + 1) {
                    swap(i, i - 1, q);
                    swapCount++;
                } else if (i - 2 >= 0 && q.get(i - 2) == i + 1) {
                    swap(i - 2, i - 1, q);
                    swap(i - 1, i, q);
                    swapCount += 2;
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(swapCount);
    }

    private static void swap(int i, int j, List<Integer> q) {
        int temp = q.get(i);
        q.set(i, q.get(j));
        q.set(j, temp);
    }
}

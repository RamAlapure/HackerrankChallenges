package com.hackerrank.challenges;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 8, 7, 6, 2, 1};
        int[] ints = insertionSort(arr);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] insertionSort(int[] arr) {
        int n = 0;
        while (n < arr.length) {
            int min = n;
            for (int i = n + 1; i < arr.length; i++) {
                boolean smaller = isSmaller(arr, min, i);
                if (!smaller) min = i;
            }
            swap(arr, n, min);
            n++;
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static boolean isSmaller(int[] arr, int i, int j) {
        return arr[i] < arr[j];
    }
}

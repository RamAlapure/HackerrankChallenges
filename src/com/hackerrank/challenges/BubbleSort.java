package com.hackerrank.challenges;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 8, 7, 6, 2, 1};
        int[] ints = bubbleSort(arr);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] bubbleSort(int[] arr) {
        int n = arr.length - 1;
        while (n != 0) {
            for (int i = 0; i < n; i++) {
                int j = i + 1;
                boolean smaller = isSmaller(arr, i, j);
                if (!smaller) swap(arr, i, j);
            }
            n--;
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

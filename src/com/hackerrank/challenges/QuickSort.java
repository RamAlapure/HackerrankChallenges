package com.hackerrank.challenges;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 9, 4, 8, 3, 6, 2, 1};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr, int low, int high) {
        if (low >= high) return;
        int pi = partition(arr, arr[high], low, high);
        sort(arr, low, pi - 1);
        sort(arr, pi + 1, high);
    }

    private static int partition(int[] arr, int p, int low, int high) {
        int i = low;
        int j = low;
        while (i <= high) {
            if (arr[i] <= p) {
                swap(arr, i, j);
                j++;
            }
            i++;
        }
        return j - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

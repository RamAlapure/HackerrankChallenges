package com.hackerrank.challenges;

import java.util.Arrays;

public class PartitionByPivot {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 9, 4, 8, 3, 6, 2, 1};
        int[] partition = partition(arr, 5);
        System.out.println(Arrays.toString(partition));
    }

    private static int[] partition(int[] arr, int p) {
        int i = 0;
        int j = 0;
        while (i < arr.length) {
            if (arr[i] < p) {
                swap(arr, i, j);
                j++;
            }
            i++;
        }
        return arr;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}

package com.hackerrank.challenges;

public class QuickSelect {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 9, 5, 8, 3, 6, 2, 1};
        int k = 4;
        int select = quickSelect(arr, 0, arr.length - 1, k - 1);
        System.out.println(select);
    }

    private static int quickSelect(int[] arr, int low, int high, int k) {
        if (low >= high) return low;
        int pi = partition(arr, arr[high], low, high);
        if (k > pi) {
            return quickSelect(arr, pi + 1, high, k);
        } else if (k < pi) {
            return quickSelect(arr, low, pi - 1, k);
        } else {
            return arr[pi];
        }
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

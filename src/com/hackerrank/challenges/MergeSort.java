package com.hackerrank.challenges;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {

        int[] a = new int[]{2, 7, 11, 13, 3, 5, 9, 12, 17, 18, 1, 8, 15};
        int[] merge = merge(a, 0, a.length - 1);
        System.out.println(Arrays.toString(merge));
    }

    private static int[] merge(int[] a, int start, int end) {
        if (start == end) {
            int[] b = new int[1];
            b[0] = a[start];
            return b;
        }
        int center = (start + end) / 2;
        int[] lhs = merge(a, start, center);
        int[] rhs = merge(a, center + 1, end);
        int[] fa = merge2SortedArrays(lhs, rhs);
        return fa;
    }

    private static int[] merge2SortedArrays(int[] a, int[] b) {
        int[] f = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                f[k] = a[i];
                i++;
            } else {
                f[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < a.length) {
            f[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length) {
            f[k] = b[j];
            j++;
            k++;
        }
        return f;
    }
}

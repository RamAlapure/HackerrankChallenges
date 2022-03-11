package com.hackerrank.DataStructures;

import java.util.*;

public class Java2DArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int maxSum = Integer.MIN_VALUE;
        int a[][] = new int[6][6];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                a[i][j] = in.nextInt();
                if (i > 1 && j > 1) {
                    int sum = a[i][j] + a[i][j - 1] + a[i][j - 2]
                            + a[i - 1][j - 1]
                            + a[i - 2][j] + a[i - 2][j - 1] + a[i - 2][j - 2];
                    if (sum > maxSum) {
                        maxSum = sum;
                    }
                }
            }
        }
        System.out.println(maxSum);
    }

    public static int hourglassSum(List<List<Integer>> arr) {
        int rows = arr.size();
        int columns = arr.get(0).size();
        int mhs = Integer.MIN_VALUE;
        for (int i = 0; i < rows - 2; i++) {
            for (int j = 0; j < columns - 2; j++) {
                int chs = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2) + arr.get(i + 1).get(j + 1) + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);
                mhs = Math.max(mhs, chs);
            }
        }
        return mhs;
    }
}

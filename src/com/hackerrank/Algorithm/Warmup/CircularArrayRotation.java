package com.hackerrank.Algorithm.Warmup;

//more optimised

import java.util.Scanner;

public class CircularArrayRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }
        if (a == null || k < 0) {
            throw new IllegalArgumentException("Illegal argument!");
        }
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[(i + k) % n] = a[i];
        }
        for (int a0 = 0; a0 < q; a0++) {
            int m = in.nextInt();
            System.out.println(r[m]);
        }
    }
}

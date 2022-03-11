package com.hackerrank.Algorithm.Warmup;

import java.util.*;

public class DiagonalDifference {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n*n];
        int d1 = 0;
        int d2 = 0;
        for(int i=0; i<n*n; i++){
            a[i] = scan.nextInt();
        }
        for(int i=0; i<n; i++){
           d1 += a[i+i*n];
           d2 += a[(n-1)*(i+1)];
        }
        
        int d = Math.abs(d1-d2);
        System.out.println(d);
        
    }
}

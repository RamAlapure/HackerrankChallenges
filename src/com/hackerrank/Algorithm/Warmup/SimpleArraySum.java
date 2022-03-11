package com.hackerrank.Algorithm.Warmup;

import java.util.*;

public class SimpleArraySum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        int ans = 0;
        for(int i=0; i < n; i++){
            arr[i] = in.nextInt();
            ans = ans + arr[i];
        }
        System.out.println(ans);
        in.close();
    }
}

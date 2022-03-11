package com.hackerrank.Algorithm.Warmup;

import java.util.*;

public class MaximumPerimeterTriangle {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        scanner.close();
        Arrays.sort(a);
        int x, y, z;
        for(x=n-3, y=n-2, z=n-1; a[x]+a[y]<=a[z]; x--, y--, z--){
            if(x==0) {
                System.out.print(-1);
                return;
            }
        }
        System.out.printf("%d %d %d", a[x], a[y], a[z]);
    }
}

package com.hackerrank.Algorithm.Warmup;

import java.util.Scanner;

public class Staircase {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n + 1; i++) {
            for (int j = i; j < n; j++) {
                if (j == 0) {
                    j = n - 1;
                } else {
                    System.out.print(" ");
                }
            }
            for (int k = 0; k < i; k++) {
                System.out.print("#");
            }
            if (i > 0) {
                System.out.println();
            }
        }
    }
}

package com.hackerrank.challenges;

public class Staircase {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(pathsMemoization(n, new int[n + 1]));
        System.out.println(pathsTabulation(n));
    }

    private static int pathsMemoization(int n, int[] mem) {
        if (n == 0) return 1;
        if (n < 0) return 0;
        if (mem[n] != 0) return mem[n];
        int paths = pathsMemoization(n - 1, mem) + pathsMemoization(n - 2, mem) + pathsMemoization(n - 3, mem);
        mem[n] = paths;
        return mem[n];
    }

    private static int pathsTabulation(int n) {
        int[] mem = new int[n + 1];
        mem[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) mem[i] = mem[i - 1];
            else if (i == 2) mem[i] = mem[i - 1] + mem[i - 2];
            else mem[i] = mem[i - 1] + mem[i - 2] + mem[i - 3];
        }
        return mem[n];
    }
}

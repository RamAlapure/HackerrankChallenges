package com.hackerrank.Algorithm.Implementation;

public class ElectronicsShop {

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int max = -1;
        for (int k : keyboards) {
            if (k > b) continue;
            for (int d : drives) {
                if (d > b) continue;
                int sum = k + d;
                if (sum > max && sum <= b) max = sum;
            }
        }
        return max;
    }
}

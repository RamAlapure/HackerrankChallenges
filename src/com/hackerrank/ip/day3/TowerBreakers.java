package com.hackerrank.ip.day3;

public class TowerBreakers {

    public static int towerBreakers(int n, int m) {
        if (m == 1) return 2;
        else {
            if (n % 2 == 0) return 2;
            return 1;
        }
    }
}

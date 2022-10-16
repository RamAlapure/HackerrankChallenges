package com.hackerrank.Algorithm.Implementation;

public class DrawingBook {

    public static void main(String[] args) {
        System.out.println(pageCount(6, 5));
    }

    public static int pageCount(int n, int p) {
        return p - 1 < n - p ? extracted(p, 1, (p - 1) / 2 + 1) : extracted(n, p, n % 2 == 0 ? (n - p) / 2 + 1 : (n - p) / 2);
    }

    private static int extracted(int n, int p, int n1) {
        if ((n - p) % 2 == 0) return (n - p) / 2;
        else return n1;
    }
}

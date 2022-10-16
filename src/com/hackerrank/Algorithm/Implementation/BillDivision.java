package com.hackerrank.Algorithm.Implementation;

import java.util.Arrays;
import java.util.List;

public class BillDivision {

    public static void main(String[] args) {
        List<Integer> bill = Arrays.asList(3, 10, 2, 9);
        bonAppetit(bill, 1, 12);
    }

    public static void bonAppetit(List<Integer> bill, int k, int b) {
        int total = bill.stream().mapToInt(num -> num).sum();
        int bn = (total - bill.get(k)) / 2;
        System.out.println(b == bn ? "Bon Appetit" : b - bn);
    }
}

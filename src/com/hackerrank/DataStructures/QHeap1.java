package com.hackerrank.DataStructures;

import java.util.Scanner;
import java.util.TreeSet;

public class QHeap1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < len; i++) {
            int q = in.nextInt();
            if (q == 1) set.add(in.nextInt());
            else if (q == 2) set.remove(in.nextInt());
            else if (q == 3) System.out.println(set.first());
        }
        in.close();
    }
}

package com.hackerrank.DataStructures;

import java.util.*;
import java.util.stream.IntStream;

public class JavaList {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int l = scan.nextInt();
        //List<Integer> a = new ArrayList<Integer>();
        List<Integer> a = new LinkedList<Integer>();

        for (int i = 0; i < l; i++) {
            a.add(scan.nextInt());
        }

        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scan.next();
            if (s.equals("Insert")) a.add(scan.nextInt(), scan.nextInt());
            if (s.equals("Delete")) a.remove(scan.nextInt());
        }

        for (int i : a) System.out.print(i + " ");
    }
}

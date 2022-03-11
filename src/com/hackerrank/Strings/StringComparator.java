package com.hackerrank.Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StringComparator {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        String S = scan.next();
        int n = scan.nextInt();
        List<String> list = new ArrayList<String>();
        for (int i = 0; i <= S.length() - n; i++) {
            String s = S.substring(i, i + n);
            list.add(s);
        }
        Collections.sort(list);
        System.out.println(list.get(0));
        System.out.println(list.get((list.size()) - 1));
    }
}

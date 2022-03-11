package com.hackerrank.challenges;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

public class SpecialString {

    private SpecialString() {
    }

     public static long substrCount(int n, String s) {
        Deque<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) queue.addLast(c);
        while (!queue.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Character c : queue) {
                sb.append(c);
                int length = sb.length();
                if (length >= 2) {
                    int center = length / 2;
                    String start = sb.substring(0, center);
                    char[] charArray = start.toCharArray();
                    char ch = charArray[0];
                    int size = 1;
                    if (IntStream.range(1, charArray.length).anyMatch(i -> ch != charArray[i])) size++;
                    if (size == 1) {
                        boolean b = length % 2 == 0;
                        String end = sb.substring(b ? center : center + 1, length);
                        if (start.equals(end)) n++;
                    } else break;
                }
            }
            queue.removeFirst();
        }
        return n;
    }

}

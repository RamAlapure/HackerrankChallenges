package com.hackerrank.challenges;

public class RepeatedString {

    private RepeatedString() {
    }

    public static long repeatedString(String s, long n) {
        char[] c = s.toCharArray();
        long total = 0;
        long count = 0;
        if (s.equals("a")) total = n;
        else if (!s.contains("a")) return 0;
        else {
            long subCount = 0;
            long end = n % c.length;
            int i = 0;
            while (i < c.length) {
                if (end == i) subCount = count;
                if (c[i] == 'a') count++;
                i++;
            }
            if (count > 0) {
                if (n > c.length) total = count * (n / c.length) + subCount;
                else total += subCount;
            }
        }
        return total;
    }

    static long count(String s, long n) {
        long numOfS = n / s.length();
        long rest = n % s.length();

        if (!s.contains("a")) return 0;
        return s.length() > n ? aCounter(s, rest)
                : numOfS * aCounter(s, s.length()) + aCounter(s, rest);
    }

    private static long aCounter(String s, long end) {
        int a = 0;
        for (int i = 0; i < end; i++) {
            if (s.charAt(i) == 'a') a++;
        }
        return a;
    }
}

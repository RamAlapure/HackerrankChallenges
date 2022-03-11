package com.hackerrank.challenges;

public class ReverseInteger {

    private ReverseInteger() {
    }

    private static int reverse(int num) {
        long reverse = 0;
        while (num != 0) {
            reverse = reverse * 10 + num % 10;
            num /= 10;
            if (reverse < Integer.MIN_VALUE || reverse > Integer.MAX_VALUE) return 0;
        }
        return (int) reverse;
    }
}

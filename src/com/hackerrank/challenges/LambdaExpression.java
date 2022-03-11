package com.hackerrank.challenges;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.logging.Logger;

interface PerformOperation {
    boolean check(int a);
}

class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }

    public PerformOperation isPalindrome() {
        return this::checkPalindrome;
    }

    public boolean checkPalindrome(int num) {
        String string = Integer.toString(num);
        char[] chars = string.toCharArray();
        int size = chars.length;
        StringBuilder sb = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return string.equals(sb.toString());
    }

    public PerformOperation isPrime() {
        return this::checkPrime;
    }

    public boolean checkPrime(int num) {
        if (num == 0 || num == 1) return false;
        int count = 1;
        int condition = num / 2 > 2 ? num / 2 : num;
        for (int i = 1; i < condition; i++) {
            if (num % i == 0) count++;
            if (count > 2) break;
        }
        return count == 2;
    }

    public PerformOperation isOdd() {
        return this::checkOdd;
    }

    private boolean checkOdd(int num) {
        return num % 2 != 0;
    }

    public static PerformOperation isPrimeWithBigInt() {
        return (int a) -> BigInteger.valueOf(a).isProbablePrime(1);
    }

    public static PerformOperation isPalindromeWithSB() {
        return (int a) -> Integer.toString(a).equals(new StringBuilder(Integer.toString(a)).reverse().toString());
    }

}

public class LambdaExpression {

    public static final Logger log = Logger.getLogger(LambdaExpression.class.getName());

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            log.info(ans);
        }
    }
}

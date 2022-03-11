package com.hackerrank.challenges;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class VowelSubstring {

    public static void main(String[] args) {
        String str = findSubstring("caberqiitefg", 5);
        System.out.println(str);
    }

    public static String findSubstring(String s, int k) {
        // Write your code here
        int esf = k - 1;
        int overallMax = 0;
        int end = k - 1;
        while (end != s.length()) {
            int currentMax = 0;
            for (int index = end + 1 - k; index <= end; index++) {
                if (isVowel(s.charAt(index))) currentMax++;
            }
            if (currentMax > overallMax) {
                overallMax = currentMax;
                esf = end;
            }
            if (k == overallMax) break;
            end++;
        }
        return s.substring(esf + 1 - k, esf + 1);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    static int maxVowelsInSubstring(String s, int k) {
        int n = s.length();
        int maxVowels = 0;
        // we iterate till n-k th position of the string
        for (int i = 0; i < n - k; i++) {
            // We generate the substring of length k using substring().
            String sub_s = s.substring(i, i + k);
            //then count the vowels in the substring
            int vowels = countVowelsInSubstring(sub_s);
            // update maxVowels if current vowels is greater.
            maxVowels = Math.max(maxVowels, vowels);
        }
        return maxVowels;
    }

    static int countVowelsInSubstring(String s) {
        int countVowels = 0;
        for (int i = 0; i < s.length(); i++) {
            //get current char
            char ch = s.charAt(i);
            // check if it is a vowel and increment count.
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                countVowels++;
        }
        return countVowels;
    }
}

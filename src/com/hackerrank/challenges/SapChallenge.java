package com.hackerrank.challenges;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SapChallenge {

    public static void main(String[] args) {
        String[] names = {"sa", "ds", "ww", "ff"};
        String str = IntStream.range(0, names.length).mapToObj(index -> names[index] + (index + 1)).collect(Collectors.joining());
        System.out.println(str);

        // sum
        // currentmax
        // a e i o u i a
        // 1 1 1 1 1 1 1
        // k == sum


    }

    public static String findSubstring(String s, int k) {
        // Write your code here
        Character[] chars = new Character[]{'a', 'e', 'i', 'o', 'u'};
        List<Character> characters = Arrays.asList(chars);

        Integer[] ints = new Integer[s.length()];
        int bound = s.length();
        IntStream.range(0, bound).forEach(i -> ints[i] = characters.contains(s.charAt(i)) ? 1 : 0);

        int esf = k - 1;
        int overallMax = 0;
        int end = k - 1;
        while (end != bound) {
            int currentMax = 0;
            for (int index = 0; index < ints.length; index++) {
                if (ints[index] == 1) currentMax++;
            }
            if (currentMax > overallMax) {
                overallMax = currentMax;
                esf = end;
            }
            if (k == overallMax) break;
            end++;
        }
        return s.substring(esf-k, esf);
    }
}

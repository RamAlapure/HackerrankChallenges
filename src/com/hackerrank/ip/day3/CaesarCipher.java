package com.hackerrank.ip.day3;

import java.util.Arrays;
import java.util.List;

public class CaesarCipher {

    public static String caesarCipher(String s, int k) {
        List<Character> chars = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                int index = chars.indexOf(Character.toLowerCase(c));
                if (index + (k % chars.size()) >= chars.size()) index = index + (k % chars.size()) - chars.size();
                else index = index + (k % chars.size());
                if (Character.isUpperCase(c)) {
                    sb.append(Character.toUpperCase(chars.get(index)));
                } else sb.append(chars.get(index));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

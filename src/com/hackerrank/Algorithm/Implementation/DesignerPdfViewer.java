package com.hackerrank.Algorithm.Implementation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DesignerPdfViewer {

    public static void main(String[] args) {
        List<Integer> h = Arrays.asList(1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7);
        System.out.println(designerPdfViewer(h, "zaba"));
    }

    public static int designerPdfViewer(List<Integer> h, String word) {
        List<Character> chars = "abcdefghijklmnopqrstuvwxyz".chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        int max = Integer.MIN_VALUE;

        for (char c : word.chars().mapToObj(c -> (char) c).distinct().collect(Collectors.toList())) {
            int index = chars.indexOf(c);
            max = Math.max(max, h.get(index));
        }

        return max * word.length();
    }
}

package com.hackerrank.ip.day4;

import java.util.Arrays;
import java.util.List;

public class GridChallenge {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("mpxz", "abcd", "wlmf");
        System.out.println(gridChallenge(list));
    }

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        char[][] chars = new char[grid.size()][grid.get(0).length()];
        int i = 0;
        for (String str : grid) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            int j = 0;
            for (char c : temp) {
                chars[i][j] = c;
                j++;
            }
            i++;
        }
        return checkGrid(chars) ? "YES" : "NO";
    }

    private static boolean checkGrid(char[][] chars) {
        int j = 0;
        while (j < chars[0].length) {
            int i = 0;
            while (i < chars.length - 1) {
                if (chars[i][j] > chars[i + 1][j]) return false;
                i++;
            }
            j++;
        }
        return true;
    }
}

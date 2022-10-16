package com.hackerrank.ip.day7;

import java.util.*;
import java.util.function.Predicate;

public class NoPrefixSet {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("aab", "aac", "aacghgh", "aabghgh");
        noPrefix(list);
    }

    public static void noPrefix(List<String> words) {
        TreeSet<String> treeSet = new TreeSet<>();
        for (String word : words) {
            String next = treeSet.ceiling(word);
            String prev = treeSet.floor(word);
            if ((next != null && next.startsWith(word)) || (prev != null && word.startsWith(prev))) {
                System.out.println("BAD SET");
                System.out.println(word);
                return;
            }
            treeSet.add(word);
        }
        System.out.println("GOOD SET");
    }

    public static void noPrefix1(List<String> words) {
        Set<String> set = new HashSet<>();
        String match = null;
        for (String word : words) {
            Optional<String> optional = set.stream()
                    .filter(wordPredicate(word))
                    .findFirst();
            if (optional.isPresent()) {
                match = word;
                break;
            }
            set.add(word);
        }
        if (match != null) System.out.println("BAD SET\n" + match);
        else System.out.println("GOOD SET");
    }

    private static Predicate<String> wordPredicate(String word) {
        return str -> Objects.equals(word.charAt(0), str.charAt(0)) && (word.startsWith(str) || str.startsWith(word));
    }
}

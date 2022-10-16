package com.hackerrank.DataStructures;

import java.util.*;

public class Contacts {

    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("add", "abc"));
        list.add(Arrays.asList("add", "hack"));
        list.add(Arrays.asList("add", "hackerrank"));
        list.add(Arrays.asList("add", "xyz"));
        list.add(Arrays.asList("find", "hac"));
        list.add(Arrays.asList("find", "hak"));
        contacts(list);
    }

    public static List<Integer> contacts(List<List<String>> queries) {
        TreeSet<String> set = new TreeSet<>();
        List<Integer> result = new ArrayList<>();
        queries.forEach(query -> {
            String fun = query.get(0);
            String val = query.get(1);
            if (fun.equals("add")) set.add(val);
            if (fun.equals("find")) {
                SortedSet<String> strings = set.tailSet(val);
                int count = 0;
                for (String str : strings) {
                    if (Objects.equals(val.charAt(0), str.charAt(0))) {
                        if (str.startsWith(val)) count++;
                    } else break;
                }
                result.add(count);
            }
        });
        return result;
    }
}

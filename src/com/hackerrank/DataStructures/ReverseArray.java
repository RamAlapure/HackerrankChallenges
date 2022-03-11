package com.hackerrank.DataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ReverseArray {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(4);
        list.add(3);
        //list.add(2);

        List<Integer> integers = reverseArray(list);
        System.out.println(integers);

    }

    public static List<Integer> reverseArray(List<Integer> a) {

        IntStream.range(0, a.size() / 2).forEach(i -> {
            int temp = a.get(i);
            a.set(i, a.get(a.size() - 1 - i));
            a.set(a.size() - 1 - i, temp);
        });

        return a;
    }
}

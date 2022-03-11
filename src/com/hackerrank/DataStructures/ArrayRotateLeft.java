package com.hackerrank.DataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayRotateLeft {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);
        System.out.println(rotateLeft(2, list));

    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        IntStream.range(0, d).forEach(i -> arr.add(arr.remove(0)));
        return arr;
    }
}

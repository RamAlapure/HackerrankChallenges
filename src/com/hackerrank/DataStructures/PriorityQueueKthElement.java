package com.hackerrank.DataStructures;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class PriorityQueueKthElement {
    public static void main(String[] args) {
        int[] ints = new int[]{10, 4, 5, 8, 9, 15, 12};

        kthLargest(ints, 3);

        find(ints, 3);
    }

    private static Integer kthLargest(int[] ints, int k) {
        Integer[] integers = Arrays.stream(ints).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, Collections.reverseOrder());
        System.out.println(Arrays.toString(integers));
        System.out.println(integers[k-1]);
        return integers[k-1];
    }

    private static Integer find(int[] ints, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            queue.add(ints[i]);
        }
        IntStream.range(k, ints.length).forEach(i -> {
            Integer peek = queue.peek();
            if (peek < ints[i]) {
                queue.poll();
                queue.add(ints[i]);
            }
        });
        System.out.println(queue);
        System.out.println(queue.peek());
        return queue.peek();
    }
}

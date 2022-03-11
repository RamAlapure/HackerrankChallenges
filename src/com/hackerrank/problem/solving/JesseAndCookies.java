package com.hackerrank.problem.solving;

import java.util.*;
import java.util.stream.Collectors;

public class JesseAndCookies {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 9, 10, 12};
        int i = cookies(7, Arrays.stream(arr).boxed().collect(Collectors.toList()));
        System.out.println(i);
    }

    public static int cookies(int k, List<Integer> A) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(A);
        int i = 0;
        while (queue.size() >= 2 && queue.peek() < k) {
            queue.add(queue.poll() + 2 * queue.poll());
            i++;
        }
        return queue.peek() >= k ? i : -1;
    }
}

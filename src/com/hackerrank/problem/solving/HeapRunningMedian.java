package com.hackerrank.problem.solving;

import java.util.*;
import java.util.stream.Collectors;

public class HeapRunningMedian {

    public static void main(String[] args) {
        int[] a = {12, 4, 5, 3, 8, 7};
        List<Double> list = runningMedian(Arrays.stream(a).boxed().collect(Collectors.toList()));
        System.out.println(list);
    }

    static PriorityQueue<Double> lq = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Double> rq = new PriorityQueue<>();

    public static List<Double> runningMedian(List<Integer> a) {
        List<Double> medians = new ArrayList<>();
        for (int e : a) {
            add(lq, rq, e);
            if (lq.size() > rq.size()) medians.add(lq.peek());
            else if (lq.size() < rq.size()) medians.add(rq.peek());
            else medians.add(((lq.peek() + rq.peek()) / 2));
        }
        return medians;
    }

    private static void add(PriorityQueue<Double> lq, PriorityQueue<Double> rq, int e) {
        if (!rq.isEmpty() && rq.peek() < e) rq.add((double) e);
        else lq.add((double) e);
        if (lq.size() - rq.size() == 2) rq.add(lq.remove());
        else if (rq.size() - lq.size() == 2) lq.add(rq.remove());
    }
}

package com.hackerrank.ubs;

import java.util.ArrayList;
import java.util.List;

public class StartGraphSum {

    static class Edge {
        int src;
        int nbr;
        int val;

        public Edge(int src, int nbr, int val) {
            this.src = src;
            this.nbr = nbr;
            this.val = val;
        }
    }

    public static int bestSumKStar(int gNodes, List<Integer> gFrom, List<Integer> gTo, List<Integer> values, int k) {
        int bestSum = Integer.MIN_VALUE;
        ArrayList<Edge>[] graph = new ArrayList[gNodes];
        for (int i = 0; i < gNodes; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < gNodes; i++) {
            Edge edge = new Edge(gFrom.get(i), gTo.get(i), values.get(i));
            graph[gFrom.get(i)].add(edge);
        }

        for (int i = 0; i < gNodes; i++) {
            int sum = graph[i].stream().mapToInt(edge -> edge.val).sum();
            bestSum = Math.max(bestSum, sum);
        }

        return bestSum;
    }

}

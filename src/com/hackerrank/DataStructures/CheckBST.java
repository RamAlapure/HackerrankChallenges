package com.hackerrank.DataStructures;

public class CheckBST {

    class Node {
        int data;
        Node left;
        Node right;
    }

    class Pair {
        int min;
        int max;
        boolean isBST;

        public Pair(int min, int max, boolean isBST) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    Pair isBST(Node node) {
        if (node == null) return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, true);

        Pair lp = isBST(node.left);
        Pair rp = isBST(node.right);

        boolean isBST = lp.isBST && rp.isBST && (node.data > lp.max && node.data < rp.min);
        int min = Math.min(node.data, Math.min(lp.min, rp.min));
        int max = Math.max(node.data, Math.max(lp.max, rp.max));

        return new Pair(min, max, isBST);
    }

    boolean checkBST(Node root) {
        return isBST(root).isBST;
    }
}

package com.hackerrank.problem.solving;

public class HuffmanDecoding {

    static class Node {
        public int frequency; // the frequency of this tree
        public char data;
        public Node left, right;
    }

    void decode(String s, Node root) {
        Node temp = root;
        for (char c : s.toCharArray()) {
            if (c == '0') temp = temp.left;
            else temp = temp.right;
            if (temp != null && temp.left == null && temp.right == null) {
                System.out.print(temp.data);
                temp = root;
            }
        }
    }
}

package com.hackerrank.DataStructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeSwapNodesAlgo {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
        List<List<Integer>> ans = new ArrayList<>();
        Node root = create(indexes);

        for (int k : queries) {
            List<Integer> list = new ArrayList<>();
            swap(root, k, 1, list);
            ans.add(list);
        }
        return ans;
    }

    private static void swap(Node root, int k, int level, List<Integer> list) {
        if (root != null) {
            if (level % k == 0) {
                Node temp = root.left;
                root.left = root.right;
                root.right = temp;
            }
            swap(root.left, k, level + 1, list);
            list.add(root.data);
            swap(root.right, k, level + 1, list);
        }
    }

    private static Node create(List<List<Integer>> indexes) {
        Queue<Node> queue = new ArrayDeque<>();
        Node root = new Node(1);
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < indexes.size(); i++) {
                Node node = queue.remove();
                Integer x = indexes.get(i).get(0);
                Integer y = indexes.get(i).get(1);
                if (x != -1) {
                    node.left = new Node(x);
                    queue.add(node.left);
                }
                if (y != -1) {
                    node.right = new Node(y);
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}

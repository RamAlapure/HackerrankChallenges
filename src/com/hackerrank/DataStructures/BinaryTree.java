package com.hackerrank.DataStructures;

import java.util.*;

public class BinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static class Pair {
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void main(String[] args) {

        Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Node root = new Node(arr[0], null, null);
        Pair pair = new Pair(root, 1);
        Stack<Pair> stack = new Stack<>();
        stack.push(pair);

        int i = 0;
        while (!stack.isEmpty()) {
            Pair top = stack.peek();
            if (top.state == 1) {
                i++;
                if (arr[i] != null) {
                    top.node.left = new Node(arr[i], null, null); // assign left
                    Pair lp = new Pair(top.node.left, 1);
                    stack.push(lp);
                }
                top.state++;
            } else if (top.state == 2) {
                i++;
                if (arr[i] != null) {
                    top.node.right = new Node(arr[i], null, null); // assign right
                    Pair rp = new Pair(top.node.right, 1);
                    stack.push(rp);
                }
                top.state++;
            } else stack.pop();
        }

        display(root);
    }

    public static void display(Node node) {
        if (node == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append(node.left != null ? node.left.data : ".")
                .append(" <- ").append(node.data).append(" -> ")
                .append(node.right != null ? node.right.data : ".");
        System.out.println(sb);
        display(node.left);
        display(node.right);
    }

    public static int size(Node node) {
        if (node == null) return 0;
        int ls = size(node.left);
        int rs = size(node.right);
        return ls + rs + 1;
    }

    public static int sum(Node node) {
        if (node == null) return 0;
        int ls = sum(node.left);
        int rs = sum(node.right);
        return ls + rs + node.data;
    }

    public static int max(Node node) {
        if (node == null) return Integer.MIN_VALUE;
        int lm = max(node.left);
        int rm = max(node.right);
        int max = Math.max(lm, rm);
        return Math.max(max, node.data);
    }

    public static int height(Node node) {
        if (node == null) return -1;
        int lh = height(node.left);
        int rh = height(node.right);
        return Math.max(lh, rh) + 1;
    }

    public static int width(Node node) {
        int ans[] = new int[2];
        width(node, 0, ans);
        return ans[1] - ans[0] + 1;
    }

    private static void width(Node node, int hl, int[] ans) {
        if (node == null) return;
        ans[0] = Math.min(ans[0], hl);
        ans[1] = Math.max(ans[1], hl);
        width(node.left, hl - 1, ans);
        width(node.right, hl + 1, ans);
    }

    public static void topView(Node root) {
        int ans[] = new int[2];
        width(root, 0, ans);
        int len = ans[1] - ans[0] + 1;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) list.add(null);
        if (root == null) return;

        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root, Math.abs(ans[0])));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (list.get(pair.state) == null) list.set(pair.state, pair.node.data);
            if (pair.node.left != null) queue.add(new Pair(pair.node.left, pair.state - 1));
            if (pair.node.right != null) queue.add(new Pair(pair.node.right, pair.state + 1));
        }

        list.forEach(value -> System.out.print(value + " "));
    }

    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void inOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        System.out.print(root.data + " ");
        postOrder(root.right);
    }

    public static void levelOrder(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll(); // remove
            System.out.print(node.data + " "); // print
            if (node.left != null) queue.add(node.left); // add
            if (node.right != null) queue.add(node.right); //add
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) return new Node(data);
        else {
            if (data <= root.data) root.left = insert(root.left, data);
            else root.right = insert(root.right, data);
        }
        return root;
    }

    public static Node lca(Node root, int v1, int v2) {
        List<Node> l1 = nodeToRoot(root, v1);
        List<Node> l2 = nodeToRoot(root, v2);
        int i = l1.size() - 1;
        int j = l2.size() - 1;
        while (i >= 0 && j >= 0 && l1.get(i).data == l2.get(j).data) {
            i--;
            j--;
        }
        return l1.get(++i);
    }

    private static List<Node> nodeToRoot(Node tree, int i) {
        List<Node> nodes = new ArrayList<>();
        if (tree.data == i) {
            nodes.add(tree);
            return nodes;
        }
        if(tree.left != null) {
            List<Node> list = nodeToRoot(tree.left, i);
            if(!list.isEmpty()) {
                list.add(tree);
                return list;
            }
        }
        if(tree.right != null) {
            List<Node> list = nodeToRoot(tree.right, i);
            if(!list.isEmpty()) {
                list.add(tree);
                return list;
            }
        }
        return nodes;
    }

}

package com.hackerrank.DataStructures;

import java.util.*;
import java.util.stream.Collectors;

public class GenericTree {

    public static void main(String[] args) {
        int[] ints = new int[]{10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node tree = createGenericTree(ints);
        //display(tree);
        /*
        int size = size(tree);
        int max = max(tree);
        int min = min(tree);
        int height = height(tree);
        traversal(tree);
        System.out.println("Pre Traversal:");
        preTraversal(tree);
        System.out.println("Post Traversal:");
        postTraversal(tree);*/
        //levelOrderTraversal(tree);
        //levelOrderLineWise(tree);
        //levelOrderZigZag(tree);
        //levelOrderLineWiseWithMarker(tree);
        //levelOrderLineWiseWithCount(tree);
        //levelOrderLineWiseWithPair(tree);
        //removeLeaves(tree);
        //linearize(tree);
        //linearize1(tree);
        //display(tree);
        //boolean node = find(tree, 110);
        //System.out.println(node);
        //List<Integer> list = nodeToRoot(tree, 110);
        //list.stream().forEach(System.out::println);
        //int n = lowestCommonAncestor(tree, 70, 110);
        //System.out.println(n);
        //int n = distanceBetweenTwoNodes(tree, 70, 110);
        //System.out.println(n);
        boolean areSimilar = areSimilar(tree, tree);
        System.out.println(areSimilar);
    }

    private static boolean areTreesMirror(Node tree, Node tree1) {
        if (tree.children.size() != tree1.children.size())
            return false;
        else {
            for (int i = 0; i < tree.children.size(); i++) {
                boolean similar = areTreesMirror(tree.children.get(i), tree1.children.get(tree1.children.size() - 1 - i));
                if (!similar) return false;
            }
        }
        return true;
    }

    private static boolean areSimilar(Node tree, Node tree1) {
        if (tree.children.size() != tree1.children.size())
            return false;
        else {
            for (int i = 0; i < tree.children.size(); i++) {
                boolean similar = areSimilar(tree.children.get(i), tree1.children.get(i));
                if (!similar) return false;
            }
        }
        return true;
    }

    private static int distanceBetweenTwoNodes(Node tree, int d1, int d2) {
        List<Integer> l1 = nodeToRoot(tree, d1);
        List<Integer> l2 = nodeToRoot(tree, d2);
        int i = l1.size() - 1;
        int j = l2.size() - 1;
        while (i >= 0 && j >= 0 && l1.get(i) == l2.get(j)) {
            i--;
            j--;
        }
        i++;
        j++;
        return i + j;
    }

    private static int lowestCommonAncestor(Node tree, int d1, int d2) {
        List<Integer> l1 = nodeToRoot(tree, d1);
        List<Integer> l2 = nodeToRoot(tree, d2);
        int i = l1.size() - 1;
        int j = l2.size() - 1;
        while (i >= 0 && j >= 0 && l1.get(i) == l2.get(j)) {
            i--;
            j--;
        }
        return l1.get(++i);
    }

    private static List<Integer> nodeToRoot(Node tree, int i) {
        if (tree.data == i) {
            List<Integer> nodes = new ArrayList<>();
            nodes.add(tree.data);
            return nodes;
        }
        for (Node node : tree.children) {
            List<Integer> list = nodeToRoot(node, i);
            if (!list.isEmpty()) {
                list.add(tree.data);
                return list;
            }
        }
        return new ArrayList<>();
    }

    private static boolean find(Node tree, int i) {
        if (tree.data == i) return true;
        for (Node node : tree.children) {
            boolean b = find(node, i);
            if (b) return true;
        }
        return false;
    }

    private static Node linearize1(Node tree) {
        if (tree.children.isEmpty()) return tree;
        Node tail = linearize1(tree.children.get(tree.children.size() - 1));
        while (tree.children.size() > 1) {
            Node lastChild = tree.children.remove(tree.children.size() - 1);
            Node secLastChild = tree.children.get(tree.children.size() - 1);
            Node secLastTail = linearize1(secLastChild);
            secLastTail.children.add(lastChild);
        }
        return tail;
    }

    private static void linearize(Node tree) {
        tree.children.forEach(GenericTree::linearize);
        while (tree.children.size() > 1) {
            Node lastChild = tree.children.remove(tree.children.size() - 1);
            Node secLastChild = tree.children.get(tree.children.size() - 1);
            Node tail = getTail(secLastChild);
            tail.children.add(lastChild);
        }
    }

    private static Node getTail(Node node) {
        while (node.children.size() == 1) {
            node = node.children.get(0);
        }
        return node;
    }

    private static void removeLeaves(Node tree) {
        for (int i = 0; i < tree.children.size(); i++) {
            Node child = tree.children.get(i);
            if (child.children.isEmpty()) {
                tree.children.remove(child);
                i--;
            } else removeLeaves(child);
        }
    }

    private static void levelOrderZigZag(Node tree) {
        Stack<Node> stack = new Stack<>();
        Stack<Node> childStack = new Stack<>();
        stack.add(tree); // add root
        boolean isLeft = true;
        while (!stack.isEmpty()) {
            // remove
            Node node = stack.pop();
            // print
            System.out.print(node.data + " ");
            // add
            if (isLeft) childStack.addAll(node.children);
            else {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    childStack.add(node.children.get(i));
                }
            }
            if (stack.isEmpty()) {
                System.out.println();
                stack = childStack;
                childStack = new Stack<>();
                isLeft = !isLeft;
            }
        }
    }

    private static void levelOrderLineWiseWithPair(Node tree) {
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(tree, 1)); // add root
        int level = queue.size();
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (level != pair.level) {
                System.out.println();
                level++;
            }
            System.out.print(pair.node.data + " ");
            for (Node node : pair.node.children) {
                queue.add(new Pair(node, level + 1));
            }
        }
    }

    private static void levelOrderLineWiseWithCount(Node tree) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(tree); // add root
        while (!queue.isEmpty()) {
            int count = queue.size();
            while (count > 0) {
                Node node = queue.poll();
                System.out.print(node.data + " ");
                queue.addAll(node.children);
                count--;
            }
            if (!queue.isEmpty()) System.out.println();
        }
    }

    private static void levelOrderLineWiseWithMarker(Node tree) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(tree); // add root
        queue.add(null);
        while (!queue.isEmpty()) {
            // remove
            Node node = queue.poll();
            if (node == null) {
                if (!queue.isEmpty()) {
                    System.out.println();
                    queue.add(null);
                }
            } else {
                System.out.print(node.data + " ");
                queue.addAll(node.children);
            }
        }
    }

    private static void levelOrderLineWise(Node tree) {
        Queue<Node> queue = new ArrayDeque<>();
        Queue<Node> childQueue = new ArrayDeque<>();
        queue.add(tree); // add root
        while (!queue.isEmpty()) {
            // remove
            Node node = queue.remove();
            // print
            System.out.print(node.data + " ");
            // add
            childQueue.addAll(node.children);
            if (queue.isEmpty()) {
                System.out.println();
                queue = childQueue;
                childQueue = new ArrayDeque<>();
            }
        }
    }

    private static void levelOrderTraversal(Node tree) {
        Queue<Node> queue = new ArrayDeque();
        queue.add(tree); // add root
        while (!queue.isEmpty()) {
            // remove
            Node node = queue.remove();
            // print
            System.out.print(node.data + " ");
            // add
            queue.addAll(node.children);
        }
    }

    private static void preTraversal(Node tree) {
        System.out.println(tree.data);
        tree.children.forEach(GenericTree::preTraversal);
    }

    private static void postTraversal(Node tree) {
        tree.children.forEach(GenericTree::postTraversal);
        System.out.println(tree.data);
    }

    private static void traversal(Node tree) {
        System.out.println("Pre Node " + tree.data);
        tree.children.forEach(child -> {
            System.out.println("Edge Pre " + tree.data + " -- " + child.data);
            traversal(child);
            System.out.println("Edge Post " + tree.data + " -- " + child.data);
        });
        System.out.println("Post Node " + tree.data);
    }

    private static int height(Node tree) {
        int height = 0;
        if (tree.children.isEmpty()) return height;
        else height++;
        int maxChildHeight = 0;
        for (Node child : tree.children) {
            int childHeight = height(child);
            maxChildHeight = Math.max(childHeight, maxChildHeight);
        }
        return height + maxChildHeight;
    }

    private static int min(Node tree) {
        int min = tree.data;
        for (Node child : tree.children) {
            int childMin = min(child);
            if (childMin < min) min = childMin;
        }
        return min;
    }

    private static int max(Node tree) {
        int max = tree.data;
        for (Node child : tree.children) {
            int childMax = max(child);
            if (childMax > max) max = childMax;
        }
        return max;
    }

    private static int size(Node tree) {
        return tree.children.stream().mapToInt(GenericTree::size).sum() + 1;
    }

    private static void display(Node tree) {
        String children = tree.children.stream()
                .map(child -> String.valueOf(child.data))
                .collect(Collectors.joining(","));
        System.out.println(tree.data + " -> " + children);
        tree.children.forEach(GenericTree::display);
    }

    private static Node createGenericTree(int[] ints) {
        Node root = null;
        Stack<Node> stack = new Stack();
        for (int n : ints) {
            if (n == -1) stack.pop();
            else {
                Node node = new Node(n, new ArrayList<>());
                if (stack.isEmpty()) root = node;
                else {
                    Node parent = stack.peek();
                    parent.children.add(node);
                }
                stack.push(node);
            }
        }
        return root;
    }
}

class Pair {
    Node node;
    int level;

    public Pair(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}

class Node {
    int data;
    List<Node> children;

    public Node(int data, List<Node> children) {
        this.data = data;
        this.children = children;
    }
}
package com.hackerrank.DataStructures.tree;

import java.util.Scanner;

public class BalancedTree {

    public static void main(String[] args) {
        BalancedTree tree = new BalancedTree();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of integers: ");
        int n = scanner.nextInt();

        System.out.print("Enter the integers: ");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            tree.insert(data);
        }
        System.out.println("Add new number");
        int num = scanner.nextInt();
        tree.insert(num);
        printBalanceFactors(tree.root);
        System.out.println();
        Node balancedTree = balanceTree(tree.root);
        printBalanceFactors(balancedTree);
        scanner.close();
    }

    // Method to print the balance factors of all nodes in the AVL tree
    private static void printBalanceFactors(Node node) {
        if (node == null) {
            return;
        }
        printBalanceFactors(node.left);
        System.out.printf(node.data + "(BF=" + getBalanceFactor(node) + ") ");
        printBalanceFactors(node.right);
    }

    private static Node balanceTree(Node node) {
        if (node == null) {
            return null;
        }

        // Check the balance factor of the node
        int balanceFactor = getBalanceFactor(node);

        // Left Subtree is heavier
        if (balanceFactor > 1) {
            // Left Right Case
            if (getBalanceFactor(node.left) < 0) {
                node.left = rotateLeft(node.left);
            }
            // Left Left Case
            node = rotateRight(node);
        }
        // Right Subtree is heavier
        else if (balanceFactor < -1) {
            // Right Left Case
            if (getBalanceFactor(node.right) > 0) {
                node.right = rotateRight(node.right);
            }
            // Right Right Case
            node = rotateLeft(node);
        }

        // Recursively balance the left and right subtrees
        node.left = balanceTree(node.left);
        node.right = balanceTree(node.right);

        return node;
    }

    private Node root;

    private class Node {
        int data;
        int height;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.height = 1;
            this.left = null;
            this.right = null;
        }
    }

    // Method to get the height of a node
    private static int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    // Method to get the balance factor of a node
    private static int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    // Method to update the height of a node
    private static void updateHeight(Node node) {
        if (node == null) {
            return;
        }
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    // Method to perform a right rotation
    private static Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        updateHeight(y);
        updateHeight(x);

        // Return the new root
        return x;
    }

    // Method to perform a left rotation
    private static Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        updateHeight(x);
        updateHeight(y);

        // Return the new root
        return y;
    }

    // Method to insert a node into the AVL tree
    public void insert(int data) {
        root = insertNode(root, data);
    }

    private Node insertNode(Node node, int data) {
        // Perform the normal BST insertion
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insertNode(node.left, data);
        } else if (data > node.data) {
            node.right = insertNode(node.right, data);
        } else {
            // Duplicate keys are not allowed in AVL tree
            return node;
        }

        // Update the height of the current node
        updateHeight(node);

        // Return the unchanged node
        return node;
    }
}
package com.hackerrank.basics;

import java.util.*;

class JavaNode {
	int data;
	JavaNode next;
	JavaNode(int d) {
        data = d;
        next = null;
    }
}

class JavaLinkedList {
    public static JavaNode insert(JavaNode head, int data) {
        //Complete this method
        if (head == null)
        return new JavaNode(data);
        head.next = insert(head.next, data);
        return head;
    }
	public static void display(JavaNode head) {
        JavaNode start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        JavaNode head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}

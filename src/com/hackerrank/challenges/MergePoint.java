package com.hackerrank.challenges;

import java.io.BufferedWriter;
import java.io.IOException;

public class MergePoint {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }

    // Complete the findMergeNode function below.
    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode currentA = head1;
        SinglyLinkedListNode currentB = head2;

        //Do till the two nodes are the same
        while (currentA != currentB) {
            //If you reached the end of one list start at the beginning of the other one
            //currentA
            if (currentA.next == null) currentA = head2;
            else currentA = currentA.next;
            //currentB
            if (currentB.next == null) currentB = head1;
            else currentB = currentB.next;
        }
        return currentB.data;

    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedList list = new SinglyLinkedList();
        SinglyLinkedListNode iHead = head1;
        SinglyLinkedListNode jHead = head2;
        while (iHead != null && jHead != null) {
            if (iHead.data <= jHead.data) {
                list.insertNode(iHead.data);
                iHead = iHead.next;
            } else {
                list.insertNode(jHead.data);
                jHead = jHead.next;
            }
        }
        while (iHead != null) {
            list.insertNode(iHead.data);
            iHead = iHead.next;
        }
        while (jHead != null) {
            list.insertNode(jHead.data);
            jHead = jHead.next;
        }
        return list.head;
    }

}
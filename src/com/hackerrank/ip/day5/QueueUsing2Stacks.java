package com.hackerrank.ip.day5;

import java.util.Scanner;
import java.util.Stack;

public class QueueUsing2Stacks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        CustomQueue queue = new CustomQueue();

        while (q > 0) {
            int type = sc.nextInt();
            if (type == 1) queue.enqueue(sc.nextInt());
            if (type == 2) queue.dequeue();
            if (type == 3) queue.print();
            q--;
        }
    }

    static class CustomQueue {

        Stack<Integer> inputStack = new Stack<>();
        Stack<Integer> outputStack = new Stack<>();

        void enqueue(int data) {
            inputStack.push(data);
        }

        int dequeue() {
            if (outputStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }
            return outputStack.pop();
        }

        void print() {
            if (outputStack.isEmpty()) {
                while (!inputStack.isEmpty()) {
                    outputStack.push(inputStack.pop());
                }
            }
            System.out.println(outputStack.peek());
        }

    }

}

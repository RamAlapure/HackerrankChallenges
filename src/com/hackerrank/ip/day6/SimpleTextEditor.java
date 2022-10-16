package com.hackerrank.ip.day6;

import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        while (q > 0) {
            int op = sc.nextInt();
            if (op == 1) {
                String str = sc.next();
                stack.push(stack.isEmpty() ? str : stack.peek() + str);
            } else if (op == 2) {
                int k = sc.nextInt();
                String last = stack.peek();
                stack.push(last.substring(0, last.length() - k));
            } else if (op == 3) {
                int k = sc.nextInt();
                String last = stack.peek();
                sb.append(last.charAt(k - 1)).append("\n");
            } else if (op == 4) {
                stack.pop();
            }
            q--;
        }
        System.out.println(sb);
        sc.close();
    }

}

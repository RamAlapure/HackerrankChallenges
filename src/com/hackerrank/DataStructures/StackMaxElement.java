package com.hackerrank.DataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackMaxElement {

    public static List<Integer> getMax(List<String> operations) {
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> max = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        operations.stream().map(op -> op.split(" ")).forEach(str -> {
            int q = Integer.parseInt(str[0]);
            if (q == 1) {
                int e = Integer.parseInt(str[1]);
                stack.add(e);
                if (max.isEmpty() || max.peek() < e) max.add(e);
                else max.add(max.peek());
            } else if (q == 2) {
                stack.pop();
                max.pop();
            } else if (q == 3) ans.add(max.peek());
        });
        return ans;
    }
}

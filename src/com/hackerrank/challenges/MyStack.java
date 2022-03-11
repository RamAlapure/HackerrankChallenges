package com.hackerrank.challenges;

public class MyStack {

    String[] arr;
    int capacity;
    int top;

    public MyStack(int capacity) {
        this.arr = new String[capacity];
        this.top = -1;
    }

    public synchronized void push(String e) throws Exception {
        if (top == capacity-1) throw new Exception("Stack full");
        top++;
        arr[top] = e;
    }

    public synchronized String pop() throws Exception {
        if (top == -1) throw new Exception("Stack empty");
        String e = arr[top];
        top--;
        return e;
    }

    public String peek() throws Exception {
        if (top == -1) throw new Exception("Stack empty");
        return arr[top];
    }

}

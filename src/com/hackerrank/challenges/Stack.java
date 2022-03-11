package com.hackerrank.challenges;

import java.io.Serializable;

public class Stack<E> implements Serializable {

    private final int capacity;
    private int top;
    private final E[] array;

    public Stack() {
        this.capacity = 16;
        this.top = -1;
        array = (E[]) new Object[capacity];
    }

    public Stack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        array = (E[]) new Object[capacity];
    }

    //add elements to stack
    public synchronized void push(E e) {
        if (top == capacity - 1) throw new IllegalStateException("Stack is full");
        array[++top] = e;
    }

    // remove and get elements from stack
    public synchronized E pop() {
        if (top == -1) throw new IllegalStateException("Stack is empty");
        E obj = array[top];
        array[top] = null; // eligible for garbage collection
        top--;
        return obj;
    }

    // get elements from stack
    public synchronized E peek() {
        return array[top];
    }
}

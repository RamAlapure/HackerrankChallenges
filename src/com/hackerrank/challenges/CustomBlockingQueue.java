package com.hackerrank.challenges;

import java.util.LinkedList;
import java.util.Queue;

public class CustomBlockingQueue<E> {

    private Queue<E> queue;
    private int capacity;

    public CustomBlockingQueue(int capacity) {
        this.queue = new LinkedList<>();
        this.capacity = capacity;
    }

    public synchronized void add(E e) throws InterruptedException {
        if (queue.size() == capacity) {
            this.wait();
        }
        queue.add(e);
        this.notifyAll();
    }

    public synchronized E take() throws InterruptedException {
        if (queue.isEmpty()) {
            this.wait();
        }
        E e = queue.remove();
        this.notifyAll();
        return e;
    }
}

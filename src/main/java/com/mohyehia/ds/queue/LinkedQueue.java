package com.mohyehia.ds.queue;

import java.util.LinkedList;

public class LinkedQueue implements Queue{
    private LinkedList<Integer> list;

    public LinkedQueue() {
        list = new LinkedList<>();
    }

    @Override
    public void enqueue(int val) {
        list.addLast(val);
    }

    @Override
    public int dequeue() {
        return list.removeFirst();
    }

    @Override
    public int peek() {
        return list.getFirst();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}

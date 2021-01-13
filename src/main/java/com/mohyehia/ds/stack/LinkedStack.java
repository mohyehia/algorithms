package com.mohyehia.ds.stack;

import java.util.LinkedList;

public class LinkedStack implements Stack{
    private final LinkedList<Integer> list;

    public LinkedStack() {
        this.list = new LinkedList<>();
    }

    @Override
    public void push(int val) {
        list.addFirst(val);
    }

    @Override
    public int pop() {
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

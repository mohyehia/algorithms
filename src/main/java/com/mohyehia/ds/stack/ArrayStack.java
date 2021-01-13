package com.mohyehia.ds.stack;

import java.util.Arrays;

public class ArrayStack implements Stack{
    private int[] data;
    private int top;
    private int capacity;

    public ArrayStack(int capacity) {
        data = new int[capacity];
        this.capacity = capacity;
        top = -1;
    }

    @Override
    public void push(int val) {
        ensureExtraCapacity();
        data[++top] = val;
    }

    @Override
    public int pop() {
        if(isEmpty()) throw new IllegalStateException("Stack is empty!");
        int val = data[top];
        top--;
        return val;
    }

    @Override
    public int peek() {
        if(isEmpty()) throw new IllegalStateException("Stack is empty!");
        return data[top];
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    private void ensureExtraCapacity() {
        if(capacity == data.length){
            capacity *= 2;
            data = Arrays.copyOf(data, capacity);
        }
    }
}

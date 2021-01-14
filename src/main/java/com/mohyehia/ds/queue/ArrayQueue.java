package com.mohyehia.ds.queue;

import java.util.Arrays;

public class ArrayQueue implements Queue{
    private int capacity;
    private int[] data;
    private int front, size;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        size = 0;
    }

    @Override
    public void enqueue(int val) {
        ensureExtraCapacity();
        int index = (front + size) % data.length;
        data[index] = val;
        size++;
    }

    @Override
    public int dequeue() {
        if(isEmpty()) throw new IllegalStateException("Queue is empty!");
        int val = data[front];
        front = (front + 1) % data.length;
        size--;
        return val;
    }

    @Override
    public int peek() {
        if(isEmpty()) throw new IllegalStateException("Queue is empty!");
        return data[front];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureExtraCapacity() {
        if(data.length == capacity){
            capacity *= 2;
            data = Arrays.copyOf(data, capacity);
        }
    }
}

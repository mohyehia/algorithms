package com.mohyehia.ds.queue;

public interface Queue {
    void enqueue(int val);
    int dequeue();
    int peek();
    int size();
    boolean isEmpty();
}

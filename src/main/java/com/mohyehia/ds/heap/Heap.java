package com.mohyehia.ds.heap;

/**
 * Created by Mohamed.Yehia
 * Date: 1/23/2021
 * Time: 11:27 AM
 */
public interface Heap {
    int size();
    boolean isEmpty();
    // time complexity = O(log(N))
    void push(int val);
    // time complexity = O(log(N))
    int poll();
    // time complexity = O(1)
    int peek();
    void printAll();
}

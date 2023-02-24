package com.mohyehia.ds.stack;

import java.util.LinkedList;

public class StackUsingLinkedList {
    LinkedList<Integer> list;
    int size;

    public StackUsingLinkedList() {
        list = new LinkedList<>();
        size = 0;
    }

    /**
     * @return the size of stack
     * @TimeComplexity: O(1)
     */
    int size() {
        return size;
    }

    /**
     * @return whether the stack is empty or not
     * @TimeComplexity: O(1)
     */
    boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adding new element to the stack
     *
     * @TimeComplexity: O(1)
     */
    void push(int val) {
        list.addFirst(val);
    }

    /**
     * Removing & returning the last inserted element of the stack
     *
     * @return the last inserted element of the stack
     * @TimeComplexity: O(1)
     */
    int pop() {
        return list.removeFirst();
    }

    /**
     * Returning the last inserted element of the stack
     * @return the last inserted element of the stack
     * @TimeComplexity: O(1)
     */
    int peek() {
        return list.getFirst();
    }
}

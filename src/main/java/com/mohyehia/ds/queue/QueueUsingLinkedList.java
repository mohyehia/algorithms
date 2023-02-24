package com.mohyehia.ds.queue;

import java.util.LinkedList;

public class QueueUsingLinkedList {
    LinkedList<Integer> list;
    int size;

    public QueueUsingLinkedList(){
        list = new LinkedList<>();
        size = 0;
    }

    /**
     * @return the size of queue
     * @TimeComplexity: O(1)
     */
    int size() {
        return size;
    }

    /**
     * @return whether the queue is empty or not
     * @TimeComplexity: O(1)
     */
    boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adding new element to the queue
     * @param val the value to be inserted
     */
    void add(int val){
        list.addLast(val);
    }

    /**
     * Remove the first element that was inserted to the queue
     * @return the removed element
     */
    int remove(){
        return list.removeFirst();
    }

    /**
     * Return the first element that was inserted to the queue
     * @return the first element at the queue
     */
    int peek(){
        return list.getFirst();
    }
}

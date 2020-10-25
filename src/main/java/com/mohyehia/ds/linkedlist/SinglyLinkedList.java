package com.mohyehia.ds.linkedlist;

/**
 * Created by Mohamed.Yehia
 * Date: 10/25/2020
 * Time: 8:23 PM
 */
public interface SinglyLinkedList {
    int size();
    boolean isEmpty();
    int first();
    int last();
    void addFirst(int val);
    void addLast(int val);
    int removeFirst();
    void print();
}

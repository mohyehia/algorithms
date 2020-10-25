package com.mohyehia.ds.linkedlist;

/**
 * Created by Mohamed.Yehia
 * Date: 10/25/2020
 * Time: 7:53 PM
 */
public class SinglyLinkedListImpl implements SinglyLinkedList {
    Node head, tail;
    int size;

    public SinglyLinkedListImpl() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int first() {
        return isEmpty() ? -1 : head.val;
    }

    @Override
    public int last() {
        return isEmpty() ? -1 : tail.val;
    }

    @Override
    public void addFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(size == 0) tail = head;
        size++;
    }

    @Override
    public void addLast(int val) {
        Node node = new Node(val);
        if(size == 0) head = node;
        else tail.next = node;
        node.next = null;
        tail = node;
        size++;
    }

    @Override
    public int removeFirst() {
        if(isEmpty()) return -1;
        int val = head.val;
        head = head.next;
        size--;
        if(isEmpty()) tail = null;
        return val;
    }

    @Override
    public void print() {
        if(isEmpty()) return;
        Node curr = head;
        while(curr != null){
            System.out.print(curr.val + ", ");
            curr = curr.next;
        }
    }
}

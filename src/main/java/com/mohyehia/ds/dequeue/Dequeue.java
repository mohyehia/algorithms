package com.mohyehia.ds.dequeue;

import java.util.LinkedList;
import java.util.List;

public class Dequeue {
    private LinkedList<Integer> list;
    public Dequeue() {
        list = new LinkedList<>();
    }

    int size(){
        return list.size();
    }

    boolean isEmpty(){
        return list.isEmpty();
    }

    void enqueueFirst(int val){
        list.addFirst(val);
    }

    void enqueueLast(int val){
        list.addLast(val);
    }

    int popFirst(){
        return list.removeFirst();
    }

    int popLast(){
        return list.removeLast();
    }

    int peekFirst(){
        return list.getFirst();
    }

    int peekLast(){
        return list.getLast();
    }

}

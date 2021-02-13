package com.mohyehia.ds.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q1, q2;

    public StackUsingQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int val) {
        if (q1.isEmpty()) {
            q1.add(val);
        } else {
            // remove elements from q1 & add them to q2
            while (!q1.isEmpty()) q2.add(q1.remove());
            // add the val to be the first element
            q1.add(val);
            // add elements from q2 back to q1
            while (!q2.isEmpty()) q1.add(q2.remove());
        }
    }

    public int pop() {
        if (q1.isEmpty()) throw new IllegalStateException("Stack is empty!");
        return q1.remove();
    }

    public int peek() {
        if (q1.isEmpty()) throw new IllegalStateException("Stack is empty!");
        return q1.peek();
    }

    public static void main(String[] args) {
        StackUsingQueue stackUsingQueue = new StackUsingQueue();
        stackUsingQueue.push(1);
        stackUsingQueue.push(2);
        stackUsingQueue.push(3);
        stackUsingQueue.push(4);
        stackUsingQueue.push(5);
        System.out.println(stackUsingQueue.peek());
        System.out.println("removing element =>" + stackUsingQueue.pop());
        System.out.println(stackUsingQueue.peek());
    }
}

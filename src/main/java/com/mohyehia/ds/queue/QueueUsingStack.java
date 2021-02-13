package com.mohyehia.ds.queue;

import java.util.Stack;

public class QueueUsingStack {
    Stack<Integer> s1, s2;

    public QueueUsingStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    void enqueue(int val){
        if(s1.isEmpty()) s1.push(val);
        else{
            // remove elements from s1 & add them to s2
            while(!s1.isEmpty()) s2.add(s1.pop());
            // add val to s1
            s1.add(val);
            // add elements from s2 back to s1 & remove them from s2
            while(!s2.isEmpty()) s1.add(s2.pop());
        }
    }

    int dequeue(){
        if(s1.isEmpty()) throw new IllegalStateException("Queue is empty!");
        return s1.pop();
    }

    int peek(){
        if(s1.isEmpty()) throw new IllegalStateException("Queue is empty!");
        return s1.peek();
    }

    public static void main(String[] args) {
        QueueUsingStack queueUsingStack = new QueueUsingStack();
        queueUsingStack.enqueue(1);
        queueUsingStack.enqueue(2);
        queueUsingStack.enqueue(3);
        queueUsingStack.enqueue(4);
        queueUsingStack.enqueue(5);
        System.out.println(queueUsingStack.peek());
        System.out.println("removing element =>" + queueUsingStack.dequeue());
        System.out.println(queueUsingStack.peek());
    }
}

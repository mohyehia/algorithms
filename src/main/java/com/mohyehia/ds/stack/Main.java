package com.mohyehia.ds.stack;

public class Main {
    public static void main(String[] args) {
        Stack stack = new LinkedStack();
        System.out.println(stack.isEmpty());
        stack.push(5);
        stack.push(6);
        stack.push(7);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}

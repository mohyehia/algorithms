package com.mohyehia.ds.linkedlist;

public class LinkedList {
    static class Node{
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    int size;
    Node head, tail;

    public LinkedList() {
        head = tail = null;
        size = 0;
    }

    boolean isEmpty(){
        return size == 0;
    }

    int first() {
        if(head == null){
            throw new IllegalStateException("LinkedList is empty!");
        }
        return head.val;
    }

    int last() {
        if(tail == null){
            throw new IllegalStateException("LinkedList is empty!");
        }
        return tail.val;
    }

    void addFirst(int val){
        head = new Node(val, head);
        if(size == 0) tail = head;
        size++;
    }

    void addLast(int val){
        if(size == 0){
            head = new Node(val, null);
            tail = head;
        }else{
            Node node = new Node(val, null);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    int removeFirst(){
        if(size == 0) throw new IllegalStateException("LinkedList is empty!");
        int val = head.val;
        head = head.next;
        size--;
        if(size == 0) tail = null;
        return val;
    }

    int removeLast(){
        if(size == 0) throw new IllegalStateException("LinkedList is empty!");
        int val = tail.val;
        if(size == 1) head = tail = null;
        else{
            Node prev = head;
            while(prev.next != null && prev.next.next != null) prev = prev.next;
            tail = prev;
            tail.next = null;
        }
        size--;
        return val;
    }

    void print(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.val + ", ");
            curr = curr.next;
        }
        System.out.println();
        System.out.println("_____________________________");
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addLast(5);
        linkedList.addLast(6);
        linkedList.print();
        System.out.println(linkedList.first());
        System.out.println(linkedList.last());
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeLast());
        linkedList.print();
        System.out.println(linkedList.isEmpty());
        System.out.println(linkedList.size);
    }
}

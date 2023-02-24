package com.mohyehia.ds.linkedList;

public class SinglyLinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head;

    public SinglyLinkedList() {
        this.head = null;
    }

    /**
     *
     * @param val the value of the node
     * @return val
     * @TimeComplexity: O(1)
     */
    int insertAtStart(int val) {
        if (head == null) {
            head = new Node(val);
            return val;
        }
        Node node = new Node(val);
        node.next = head;
        head = node;
        return val;
    }

    /**
     *
     * @param val to be inserted
     * @param target which the val will be inserted after
     * @return Node of the newly inserted val
     * @TimeComplexity: O(n)
     */
    Node insertAfterTargetNode(int val, int target) {
        Node node = new Node(val);
        Node curr = head;
        while (curr.data != target) {
            curr = curr.next;
        }
        node.next = curr.next;
        curr.next = node;
        return node;
    }

    /**
     *
     * @param val to be inserted
     * @return Node of the newly inserted val
     * @TimeComplexity: O(n)
     */
    Node insertAtEnd(int val) {
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        Node node = new Node(val);
        curr.next = node;
        node.next = null;
        return node;
    }

    /**
     *
     * @return the new head after removing the first element
     * @TimeComplexity: O(1)
     */
    Node deleteAtStart(){
        head = head.next;
        return head;
    }

    /**
     *
     * @param target the value of the node which the next node will be removed
     * @return the head of the linkedList
     * @TimeComplexity: O(n)
     */
    Node deleteAfterNode(int target){
        Node curr = head;
        while(curr.data != target){
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }

    /**
     *
     * @return the head of the linkedList
     * @TimeComplexity: O(n)
     */
    Node deleteAtEnd(){
        Node curr = head;
        while(curr.next.next != null){
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }

    /**
     * display the elements of the linkedList
     * @TimeComplexity: O(n)
     */
    void display(){
        Node curr = head;
        while (curr != null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    /**
     * Search for an element inside the linkedList
     * @param val the value to search for
     * @return the Node of the found value
     * @TimeComplexity: O(n)
     */
    Node search(int val){
        Node curr = head;
        while (curr != null && curr.data != val){
            curr = curr.next;
        }
        return curr;
    }
}

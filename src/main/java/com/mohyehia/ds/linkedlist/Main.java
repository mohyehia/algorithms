package com.mohyehia.ds.linkedlist;

/**
 * Created by Mohamed.Yehia
 * Date: 10/25/2020
 * Time: 9:26 PM
 */
public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedListImpl();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addLast(5);
        list.print();
    }
}

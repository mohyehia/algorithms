package com.mohyehia.ds.heap;

/**
 * Created by Mohamed.Yehia
 * Date: 1/23/2021
 * Time: 11:51 AM
 */
public class Main {
    public static void main(String[] args) {
        Heap heap = new MaxHeap();
        heap.push(1);
        heap.push(2);
        heap.push(3);
        heap.push(4);
        heap.push(5);
        heap.printAll();
        System.out.println(heap.peek());
        System.out.println(heap.poll());
        System.out.println(heap.peek());
        System.out.println(heap.poll());
        System.out.println(heap.peek());
        System.out.println(heap.poll());
        heap.printAll();
    }
}

package com.mohyehia.algo.sort;

import java.util.PriorityQueue;

public class HeapSort {
    public static void main(String[] args) {
        int[] a = {7, 10, 5, 3, 8, 4, 2, 9, 6};
        heapSort(a);
        for(int i : a) System.out.print(i + " ");
    }

    private static void heapSort(int[] a) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : a) pq.add(i);
        int index = 0;
        while(!pq.isEmpty()) a[index++] = pq.poll();
    }
}

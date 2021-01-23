package com.mohyehia.ds.heap;

import java.util.Arrays;

/**
 * Created by Mohamed.Yehia
 * Date: 1/23/2021
 * Time: 11:23 AM
 */
public class MinHeap implements Heap {
    private int capacity = 8;
    private int size;
    private int[] data;

    public MinHeap() {
        data = new int[capacity];
        this.size = 0;
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
    public void push(int val) {
        ensureExtraCapacity();
        data[size] = val;
        size++;
        heapifyUp();
    }

    @Override
    public int poll() {
        if(size == 0) throw new IllegalStateException("Heap is already empty!");
        int val = data[0];
        data[0] = data[size - 1];
        size--;
        heapifyDown();
        return val;
    }

    @Override
    public int peek() {
        if(size == 0) throw new IllegalStateException("Heap is already empty!");
        return data[0];
    }

    @Override
    public void printAll() {
        for(int i = 0; i < size; i++) System.out.print(data[i] + " ");
    }

    private void heapifyUp() {
        int index = size - 1;
        while(hasParent(index) && getParent(index) > data[index]){
            swap(data, index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)){
            int smallerChildIndex = getLeftChildIndex(index);
            if(hasRightChild(index) && getRightChild(index) < getLeftChild(index))
                smallerChildIndex = getRightChildIndex(index);
            if(data[index] < data[smallerChildIndex]) break;
            swap(data, index, smallerChildIndex);
            index = smallerChildIndex;
        }
    }

    private int getParentIndex(int index){
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index){
        return index * 2 + 1;
    }

    private int getRightChildIndex(int index){
        return index * 2 + 2;
    }

    private int getParent(int index){
        return data[getParentIndex(index)];
    }

    private int getLeftChild(int index){
        return data[getLeftChildIndex(index)];
    }

    private int getRightChild(int index){
        return data[getRightChildIndex(index)];
    }

    private boolean hasParent(int index){
        return (index - 1) / 2 >= 0;
    }

    private boolean hasLeftChild(int index){
        return index * 2 + 1 < size;
    }

    private boolean hasRightChild(int index){
        return index * 2 + 2 < size;
    }

    private void ensureExtraCapacity(){
        if(size == capacity){
            capacity *= 2;
            data = Arrays.copyOf(data, capacity);
        }
    }

    private void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

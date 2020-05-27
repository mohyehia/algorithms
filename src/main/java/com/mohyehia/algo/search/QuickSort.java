package com.mohyehia.algo.search;

/**
 * Created by mohammed
 * Date: 5/27/20
 * Time: 11:06 AM
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {10, 9, 6, 8, 5, 7, 1, 2, 4, 3};
        quickSort(a);
        for(int i : a) System.out.print(i + ", ");
    }
    static void quickSort(int[] a){
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int left, int right) {
        if(left >= right) return;
        int pivot = a[(left + right) / 2];
        int pivotIndex = partition(a, left, right, pivot);
        quickSort(a, left, pivotIndex - 1);
        quickSort(a, pivotIndex, right);
    }

    private static int partition(int[] a, int left, int right, int pivot) {
        while(left <= right){
            while(a[left] < pivot) left++;
            while(a[right] > pivot) right--;
            if(left <= right) swap(a, left++, right--);
        }
        return left;
    }

    private static void swap(int[] a, int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
}

package com.mohyehia.algo.search;

/**
 * Created by mohammed
 * Date: 5/27/20
 * Time: 11:06 AM
 */
public class QuickSelect {
    public static void main(String[] args) {
        int[] a = {10, 9, 6, 8, 5, 7, 1, 2, 4, 3};
        int k = 1;
        System.out.println(quickSelect(a, k));
    }
    /*
    find the k-th smallest element in the array
     */
    static int quickSelect(int[] a, int k){
        // for finding k-th smallest element in the array
        return quickSelect(a, 0, a.length - 1, k);
        // for finding k-th largest element in the array
//        return quickSelect(a, 0, a.length - 1, a.length - k);
    }

    private static int quickSelect(int[] a, int left, int right, int k) {
        if(left == right) return a[left];
        int pivot = a[(left + right) / 2];
        int pivotIndex = partition(a, left, right, pivot);
        if(k == pivotIndex) return a[k];
        if(k < pivotIndex) return quickSelect(a, left, pivotIndex - 1, k);
        return quickSelect(a, pivotIndex + 1, right, k);
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

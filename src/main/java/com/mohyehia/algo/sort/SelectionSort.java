package com.mohyehia.algo.sort;

//Best Case => O(n^2)
//Worst Case => O(n^2)

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {7, 10, 5, 3, 8, 4, 2, 9, 6};
        selectionSort(arr);
        for(int i : arr) System.out.print(i + ", ");
    }

    private static void selectionSort(int[] arr) {
        int min, len = arr.length;
        // find the minimum element in the unsorted sub-array[i..n-1]
        // and swap it with arr[i]
        for(int i = 0; i < len - 1; i++){
            min = i;
            for(int j = i; j < len; j++)
                if(arr[min] > arr[j]) min = j;
            swap(arr, i, min);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

package com.mohyehia.algo.sort;

//Best Case => O(n)
//Worst Case => O(n^2) when the elements in reverse order => [3, 2, 1]

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {7, 10, 5, 3, 8, 4, 2, 9, 6};
        insertionSort(arr);
        for(int i : arr) System.out.print(i + ", ");
    }

    private static void insertionSort(int[] arr) {
        int len = arr.length;
        // start from second index (consider index at element 0 is already sorted)
        for(int i = 1; i < len; i++){
            for(int j = i; j > 0; j--){
                if(arr[j - 1] > arr[j]) swap(arr, j, j - 1);
                else break;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

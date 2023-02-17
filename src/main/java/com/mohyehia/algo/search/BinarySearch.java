package com.mohyehia.algo.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 8, 10, 15, 20};
        System.out.println(iterativeBinarySearch(a, 20));
        System.out.println(iterativeBinarySearch(a, 9));
    }
    static int iterativeBinarySearch(int[] a, int target) {
        int low = 0, high = a.length - 1, mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (target == a[mid]) return mid;
            else if (target > a[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}

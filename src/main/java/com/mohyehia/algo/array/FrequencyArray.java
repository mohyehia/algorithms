package com.mohyehia.algo.array;

import java.util.Arrays;

/**
 * Created by Mohamed.Yehia
 * Date: 4/24/2020
 * Time: 4:42 PM
 */
public class FrequencyArray {
    // to count the frequency of each number in an array
    public static void main(String[] args) {
        int[] a = {3, 4, 7, 8};
        int[] b = {1, 2, 2, 5};

        System.out.println(refactor(a, b));
    }

    /*
    Can we swap elements from a with elements from b such that the sum of the elements
    in the two arrays will be equal??
     */

    static boolean refactor(int[] a, int[] b){
        int n = 50; // this should be the constrain of the question
        int[] freq = new int[n];
        int sumA = Arrays.stream(a).sum();
        int sumB = Arrays.stream(b).sum();
        int diff = Math.abs(sumA - sumB) / 2;
        for(int i : a)
            freq[i]++;
        for(int i : b) {
            if (freq[i + diff] > 0) return true;
        }
        return false;
    }
}

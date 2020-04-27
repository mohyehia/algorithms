package com.mohyehia.algo.array;

/**
 * Created by Mohamed.Yehia
 * Date: 4/21/2020
 * Time: 6:52 PM
 */
public class PrefixSum {
    /*
    It takes O(n) time to calculate prefix sum array of n size array.
    It takes O(1) time to perform range sum query on n size array.
    formula to calculate range(i, j)
    a[i, j] = a[j] - a[i - 1]
    time complexity => O(1)
     */
    public static void main(String[] args) {
        int[] a = {6, 3, -2, 4, -1, 0, -5};
        prefixSum(a);
        for(int i : a) System.out.print(i + ", ");
        // prefix sum arr => [6, 9, 7, 11, 10, 10, 5]
        /*
         calculate range of (0, 6) => return a[6] => 5
         calculate range of (0, 4) => return a[4] => 10
         calculate range of (2, 6) => return a[6] - a[1] => 5 - 9 = -4
         calculate range of (3, 5) => return a[5] - a[2] => 10 - 7 = 3
         */
    }
    /*
    calculate prefix sum array of size n
    time complexity => O(N)
     */
    static void prefixSum(int[] a){
        for(int i= 1; i < a.length; i++)
            a[i] += a[i - 1];
    }
}

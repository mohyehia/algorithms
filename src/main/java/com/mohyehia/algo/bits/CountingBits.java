package com.mohyehia.algo.bits;

import java.util.Arrays;

public class CountingBits {
    /*
    Given a non negative integer number num.
     For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
     */
    public static void main(String[] args) {
        int num = 16;
        int[] a = countBits(num);
        System.out.println(Arrays.toString(a));
    }

    /*
    dp[i] = dp[i / 1] + (i % 1), which means，
    for number i， the number of 1's in it equals the number of 1's in i / 1，and plus 1 if the lowest bit of i is 1。
    (plus one if the number is odd)
     */
    private static int[] countBits(int num) {
        int[] dp = new int[num + 1];
        for(int i = 1; i <= num; i++){
            if((i & 1) == 0) dp[i] = dp[i / 2];
            else dp[i] = dp[i / 2] + 1;
        }
        return dp;
    }
}

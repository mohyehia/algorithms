package com.mohyehia.algo.db;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] a = {4, 2, 3, 7, 5, 1, 6, 5, 8, 2};
//        int[] a = {-1, 3, 4, 5, 2, 2, 2, 2};
        /*
        here lis for a = 5 => {2, 3, 5, 6, 8}
         */
        System.out.println(lis(a));
        System.out.println(longestNonDecreasingSubSequence(a));
        System.out.println(longestDecreasingSubSequence(a));
    }
    /*
    Time complexity => O(N^2)
    Space complexity => O(N)
     */
    static int lis(int [] a){
        int max = 1, len = a.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                if(a[j] < a[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    /*
    Here we find the non-decreasing subsequence that 2 elements can be equal
    Time Complexity => O(N^2)
    Space Complexity => O(N)
     */
    static int longestNonDecreasingSubSequence(int[] a){
        if(a.length == 0) return 0;
        int max = 1, len = a.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                if(a[i] >= a[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    /*
    Here we find the decreasing subsequence (reverse of the increasing subsequence)
    Time Complexity => O(N^2)
    Space Complexity => O(N)
     */
    static int longestDecreasingSubSequence(int[] a){
        if(a.length == 0) return 0;
        int max = 0, len = a.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for(int i = 1; i < len; i++){
            for(int j = 0; j < i; j++){
                if(a[j] > a[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }
}

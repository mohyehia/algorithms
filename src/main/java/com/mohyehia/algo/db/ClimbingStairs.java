package com.mohyehia.algo.db;

import java.util.Arrays;

/**
 * Created by Mohamed.Yehia
 * Date: 4/14/2020
 * Time: 9:44 PM
 */
public class ClimbingStairs {
    /*
    Problem url => https://leetcode.com/problems/climbing-stairs/
     */
    static int[] a = new int[40];
    public static void main(String[] args) {
        Arrays.fill(a, -1);
        a[0] = a[1] = 1;
        System.out.println(climbStairsRecursive(3));
        System.out.println(climbStairs(3));
    }
    private static int climbStairs(int n){
        if(n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for(int i= 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    static int climbStairsRecursive(int n){
        if(n < 2) return 1;
        if(a[n] != -1) return a[n];
        a[n] =  climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
        return a[n];
    }
}

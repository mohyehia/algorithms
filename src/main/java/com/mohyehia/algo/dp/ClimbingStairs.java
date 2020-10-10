package com.mohyehia.algo.dp;

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
        int n = 4;
        System.out.println(climbStairsRecursive(n));
        System.out.println(climbStairs(n));
        System.out.println(climbingStairsOptimized(n));
    }
    private static int climbStairs(int n){
        if(n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for(int i= 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }

    static int climbingStairsOptimized(int n){
        if(n == 1) return 1;
        int a = 1,b = 1, c = 0;
        for(int i = 2; i <= n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    static int climbStairsRecursive(int n){
        if(n < 2) return 1;
        if(a[n] != -1) return a[n];
        return a[n] =  climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
    }
}

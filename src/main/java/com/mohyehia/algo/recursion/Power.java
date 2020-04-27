package com.mohyehia.algo.recursion;

import java.util.Arrays;

/**
 * Created by Mohamed.Yehia
 * Date: 4/17/2020
 * Time: 4:31 PM
 */
public class Power {
    static int dp[] = new int[40];
    public static void main(String[] args) {
        Arrays.fill(dp, -1);
//        System.out.println(pow(3, 4));
        System.out.println(powWithMemoization(4, 4));
    }
    static int pow(int x, int n){
        if(n == 0) return 1;
        int sum = 1;
        while(n-- > 0) sum *= x;
        return sum;
    }

    static int recursivePow(int x, int n){
        if(n == 0) return  1;
        if(n == 1) return  x;
        if(n % 2 == 0){
            int ans = recursivePow(x, n / 2);
            return ans * ans;
        }
        return x * recursivePow(x, n - 1);
    }

    static int powWithMemoization(int x, int n){
        if(n == 0) return 1;
        if(n == 1) return x;
        dp[0] = 1;
        dp[1] = x;
        if(dp[n] != -1) return dp[n];
        dp[n] = x * powWithMemoization(x, n - 1);
        return dp[n];
    }
}

package com.mohyehia.algo.recursion;

/**
 * Created by Mohamed.Yehia
 * Date: 4/7/2020
 * Time: 1:56 PM
 */
public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorial(5));
        System.out.println(fact(5));
    }

    static int fact(int n){
        if(n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++)
            dp[i] = i * dp[i - 1];
        return dp[n];
    }

    static int factorial(int n){
        System.out.println("Iam calculating factorial(" + n + ")");
        if(n == 0) return 1;
        int fact =  n * factorial(n - 1);
        System.out.println("Done factorial(" + n + ") = " + fact);
        return fact;
    }
}

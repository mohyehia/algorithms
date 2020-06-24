package com.mohyehia.algo.db;

import java.util.Arrays;

/**
 * Created by mohammed
 * Date: 6/24/20
 * Time: 11:52 PM
 */
public class CatalanNumbers {
    /*
    formula for finding the nth catalan number is
    T(n) = T(i) * T(n - i - 1) for 0 <= i < n
     */
    static int[] mem;
    public static void main(String[] args) {
        int n = 5;
        mem = new int[n + 1];
        Arrays.fill(mem, -1);
        mem[0] = mem[1] = 1;
        mem[2] = 2;
        System.out.println(catalan(n));
        System.out.println(memCatalan(n));
        System.out.println(dpCatalan(n));
    }
    /*
    Recursive function
     */
    static int catalan(int n){
        int ans = 0;
        if(n == 0 || n == 1) return 1;
        if(n == 2) return 2;
        for(int i = 0; i < n; i++)
            ans += catalan(i) * catalan(n - i - 1);
        return ans;
    }

    /*
    Function with memoization
     */
    static int memCatalan(int n){
        if(mem[n] != -1) return mem[n];
        int ans = 0;
        for(int i = 0; i < n; i++)
            ans += memCatalan(i) * memCatalan(n - i - 1);
        return mem[n] = ans;
    }

    /*
    Function with dynamic programming
     */
    static int dpCatalan(int n){
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}

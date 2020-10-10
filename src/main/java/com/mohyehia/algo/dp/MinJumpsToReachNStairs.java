package com.mohyehia.algo.dp;

import java.util.Arrays;

/**
 * Created by mohammed
 * Date: 6/18/20
 * Time: 11:15 PM
 */
public class MinJumpsToReachNStairs {
    static int[] mem;
    public static void main(String[] args) {
        int n = 7;
        mem = new int[n + 1];
        Arrays.fill(mem, -1);
        mem[1] = mem[2] = 1;
        System.out.println(minJumps(n));
        System.out.println(minJump2(n));
        System.out.println(minJumpDp(n));
        System.out.println(minJumpDpOptimized(n));
    }
    /*
    u r only allowed to jump 1 or 2 steps per jump
     */
    static int minJumps(int n){
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        return 1 + Math.min(minJumps(n - 1), minJumps(n - 2));
    }
    /*
    same recursive solution but with memoization
     */
    static int minJump2(int n){
        if(n == 0) return 0;
        if(mem[n] != -1) return mem[n];
        return mem[n] = 1 + Math.min(minJump2(n - 1), minJump2(n - 2));
    }

    static int minJumpDp(int n){
        int[] dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        for(int i = 3; i <= n; i++)
            dp[i] = 1 + Math.min(dp[i - 1], dp[i - 2]);
        return dp[n];
    }

    static int minJumpDpOptimized(int n){
        if(n == 0) return 0;
        int a = 1, b = 1, c;
        for(int i = 3; i <= n; i++){
            c = 1 + Math.min(a, b);
            a = b;
            b = c;
        }
        return b;
    }
}

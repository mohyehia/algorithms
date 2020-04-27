package com.mohyehia.algo.db;

/**
 * Created by Mohamed.Yehia
 * Date: 4/15/2020
 * Time: 8:41 AM
 */
public class MinCostClimbingStairs {
    static int minCostClimbingStairs(int[] cost) {
        int len = cost.length, temp;
        int[] dp = new int[len + 1];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i <= len; i++){
            temp = i == len? 0 : cost[i];
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + temp;
        }
        for(int i : dp) System.out.print(i + ", ");
        return dp[len];
    }

    static int minCostOptimized(int[] cost){
        int dp = 0, dp1 = cost[0], dp2= cost[1], len = cost.length;
        for(int i = 2; i <= len; i++){
            int temp = i == len ? 0 : cost[i];
            dp = Math.min(dp1, dp2) + temp;
            dp1 = dp2;
            dp2 = dp;
        }
        return dp;
    }
}

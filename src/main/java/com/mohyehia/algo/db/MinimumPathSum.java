package com.mohyehia.algo.db;

/**
 * Created by Mohamed.Yehia
 * Date: 4/20/2020
 * Time: 11:45 AM
 */
public class MinimumPathSum {

    static int minimumPathSum(int[][] grid){
        int r = grid.length, c = grid[0].length;
        int[][] dp = new int[r][c];

        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(i == 0 && j == 0)
                    dp[0][0] = grid[0][0];
                else
                    dp[i][j] = Math.min(i == 0 ? Integer.MAX_VALUE : dp[i - 1][j], j == 0 ? Integer.MAX_VALUE : dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[r - 1][c - 1];
    }

    static int minPathSumOptimized(int[][] grid){
        int r = grid.length, c = grid[0].length;
        for(int i = 1; i < c; i++)
            grid[0][i] += grid[0][i - 1];

        for(int i = 1; i < r; i++){
            grid[i][0] += grid[i - 1][0];
            for(int j = 1; j < c; j++)
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
        }
        return grid[r - 1][c - 1];
    }
}

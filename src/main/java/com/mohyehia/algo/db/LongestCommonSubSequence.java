package com.mohyehia.algo.db;

import java.util.Arrays;

/**
 * Created by Mohamed.Yehia
 * Date: 4/25/2020
 * Time: 3:01 PM
 */
public class LongestCommonSubSequence {
    /*
    Time Complexity:
        => n*m unique subP-problems
        => each gets computed in O(1) time
        => since each sub-problem is solved only once,
        then total complexity = time to solve one sub-problem * total sub-problems
        => time complexity: O(n*m) = O(n^2)
    Space Complexity:
        => O(n*m) = O(n^2)
     */
    static int[][]dp = new int[50][50];
    public static void main(String[] args) {
        for(int[] arr : dp)
            Arrays.fill(arr, -1);
        System.out.println(retrieveLongestCommonSubstring("agcat", "gac"));
        System.out.println(lcsDP("agcat".toCharArray(), "gac".toCharArray()));
        System.out.println(anotherLcsDP("agcat".toCharArray(), "gac".toCharArray()));
    }
    static int retrieveLongestCommonSubstring(String a, String b){
        return lcs(0, 0, a.toCharArray(), b.toCharArray());
//        return lcsWithMemoization(0, 0, a.toCharArray(), b.toCharArray());
    }

    private static int lcsWithMemoization(int i, int j, char[] a, char[] b) {
    // base cases
        if(i == a.length || j == b.length) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(a[i] == b[j]) return dp[i][j] = 1 + lcsWithMemoization(i + 1, j + 1, a, b);
        return dp[i][j] = Math.max(lcsWithMemoization(i + 1, j, a, b), lcsWithMemoization(i, j + 1, a, b));
    }

    private static int lcs(int i, int j, char[] a, char[] b) {
        // base cases
        if(i == a.length || j == b.length) return 0;
        if(a[i] == b[j]) return 1 + lcs(i + 1, j + 1, a, b);
        return Math.max(lcs(i + 1, j, a, b), lcs(i, j + 1, a, b));
    }

    // DP[i][j] = DP[i - 1][j - 1] + 1 , if text1[i] == text2[j]
    // DP[i][j] = max(DP[i - 1][j], DP[i][j - 1]) , otherwise

    static int lcsDP(char[] a, char[] b){
        int[][] dp = new int[a.length + 1][b.length + 1];
        int n = a.length, m = b.length;

        for(int i = n - 1; i >= 0; i--){
            for(int j = m - 1; j >= 0; j--){
                if(a[i] == b[j]) dp[i][j] = 1 + dp[i + 1][j + 1];
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }

    static int anotherLcsDP(char[] a, char[] b){
        int[][] dp = new int[a.length + 1][b.length + 1];
        int n = a.length, m = b.length;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(a[i - 1] == b[j - 1]) dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[n][m];
    }
}

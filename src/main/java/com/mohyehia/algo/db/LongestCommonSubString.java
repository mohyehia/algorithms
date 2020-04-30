package com.mohyehia.algo.db;

public class LongestCommonSubString {
    public static void main(String[] args) {
        String a = "JAVAVID", b = "JAVAID";
        System.out.println(lcs(a.length() - 1, b.length() - 1, a.toCharArray(), b.toCharArray(), 0));
        System.out.println(lcs("LCLC".length() - 1, "CLCL".length() - 1, "LCLC".toCharArray(), "CLCL".toCharArray(), 0));
        System.out.println(lcs2(0, 0, a.toCharArray(), b.toCharArray(), 0));
        System.out.println(lcs2(0, 0, "LCLC".toCharArray(), "CLCL".toCharArray(), 0));

        System.out.println(lcsDP(a.toCharArray(), b.toCharArray()));
        System.out.println(lcsDP("LCLC".toCharArray(), "CLCL".toCharArray()));
    }
    static int lcs(int i, int j, char[] a, char[] b, int count){
        if(i == -1 || j == -1) return count;
        if(a[i] == b[j]) count = lcs(i - 1, j - 1, a, b, count + 1);
        return Math.max(count, Math.max(
                lcs(i - 1, j, a, b, 0),
                lcs(i, j - 1, a, b, 0)));
    }

    static int lcs2(int i, int j, char[] a, char[] b, int count){
        if(i >= a.length || j >= b.length) return count;
        if(a[i] == b[j]) count = lcs2(i+ 1, j + 1, a, b, count + 1);
        return Math.max(count, Math.max(
           lcs2(i + 1, j, a, b, 0),
           lcs2(i, j + 1, a, b, 0)
        ));
    }

    static int lcsDP(char[] a, char[] b){
        int n = a.length, m = b.length, max = 0;
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(a[i - 1] == b[j - 1]){
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}

/*
    Table method for DP solution
        0   1   2   3   4   5   6   7
            J   A   V   A   V   I   D
        0   0   0   0   0   0   0   0
0   J   0   1   0   0   0   0   0   0
1   A   0   0   2   0   1   0   0   0
2   V   0   0   0   3   0   2   0   0
3   A   0   0   1   0   4   0   0   0
4   I   0   0   0   0   0   0   1   0
5   D   0   0   0   0   0   0   0   2

 */
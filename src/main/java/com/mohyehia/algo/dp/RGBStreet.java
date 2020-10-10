package com.mohyehia.algo.dp;

import java.util.Arrays;

public class RGBStreet {
    static int[] r, g, b;
    static int[][] mem;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) {
        String[] a = {"30 19 5", "64 77 64", "15 19 97", "4 71 57", "90 86 84", "93 32 91"};
        System.out.println(minCost(a));
    }
    static int minCost(String[] a){
        int len = a.length;
        r = new int[len];
        g = new int[len];
        b = new int[len];

        mem = new int[len][4];
        for(int[] arr : mem) Arrays.fill(arr, Integer.MAX_VALUE);

        for(int i = 0; i < len; i++){
            String[] temp = a[i].split(" ");
            r[i] = Integer.parseInt(temp[0]);
            g[i] = Integer.parseInt(temp[1]);
            b[i] = Integer.parseInt(temp[2]);
        }
        return minWithMem(0, 3, len);
//        return min(0, 3, len);
    }
    static int min(int i, int lastColor, int len){
        if(i == len) return 0;  // base case
        if(lastColor != 0)
            ans = Math.min(ans, r[i] + min(i + 1, 0, len));
        if(lastColor != 1)
            ans = Math.min(ans, g[i] + min(i + 1, 1, len));
        if(lastColor != 2)
            ans = Math.min(ans, b[i] + min(i + 1, 2, len));
        return ans;
    }

    static int minWithMem(int i, int lastColor, int len){
        if(i == len) return 0;  // base case
        if(mem[i][lastColor] != Integer.MAX_VALUE) return mem[i][lastColor];
        if(lastColor != 0)
            mem[i][lastColor] = Math.min(mem[i][lastColor], r[i] + minWithMem(i + 1, 0, len));
        if(lastColor != 1)
            mem[i][lastColor] = Math.min(mem[i][lastColor], g[i] + minWithMem(i + 1, 1, len));
        if(lastColor != 2)
            mem[i][lastColor] = Math.min(mem[i][lastColor], b[i] + minWithMem(i + 1, 2, len));
        return mem[i][lastColor];
    }
}

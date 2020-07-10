package com.mohyehia.algo.backtracking;

/**
 * Created by mohammed
 * Date: 7/8/20
 * Time: 6:20 PM
 */
public class PrintBinaryNumbersWithKBitsSet {
    public static void main(String[] args) {
        int n = 4, k = 2;
        printBinaryWithKBitSet("", n, k);
    }

    private static void printBinaryWithKBitSet(String s, int n, int k) {
        if(s.length() == n){
            if(count(s) == k) System.out.println(s);
            return;
        }
        printBinaryWithKBitSet(s + "0", n, k);
        printBinaryWithKBitSet(s + "1", n, k);
    }

    private static int count(String s) {
        int count = 0;
        for(char c : s.toCharArray())
            if(c == '1') count++;
        return count;
    }
}

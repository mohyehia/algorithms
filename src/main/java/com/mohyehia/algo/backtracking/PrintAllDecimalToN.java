package com.mohyehia.algo.backtracking;

/**
 * Created by mohammed
 * Date: 7/8/20
 * Time: 6:35 PM
 */
public class PrintAllDecimalToN {
    public static void main(String[] args) {
        int n = 2;
        printDecimal("", n);
    }

    private static void printDecimal(String s, int n) {
        if(s.length() == n){
            System.out.println(s);
            return;
        }
        for(int i = 0; i < 10; i++)
            printDecimal(s + i, n);
    }
}

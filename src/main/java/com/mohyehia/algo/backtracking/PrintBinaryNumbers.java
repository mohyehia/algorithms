package com.mohyehia.algo.backtracking;

/**
 * Created by mohammed
 * Date: 7/8/20
 * Time: 6:15 PM
 */
public class PrintBinaryNumbers {
    public static void main(String[] args) {
        int n = 4;
        printBinary("", n);
    }

    private static void printBinary(String s, int n) {
        if(s.length() == n){
            System.out.println(s);
            return;
        }
        printBinary(s + "0", n);
        printBinary(s + "1", n);
    }
}

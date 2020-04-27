package com.mohyehia.algo.recursion;

/**
 * Created by Mohamed.Yehia
 * Date: 4/18/2020
 * Time: 9:41 AM
 */
public class ModularExponentiation {
    /*
    general rule =>
    (a * b) % m = ((a % m) * (b % m)) % m
    ex: (5 * 7) % 3 = 35 % 7 = 2
    (5 * 7) % 3 = ((5 % 3) * (7 % 3)) % 3 = (2 * 1) % 3 = 2 % 3 = 2
     */
    public static void main(String[] args) {
        System.out.println(calculateMod(5, 7, 3));
    }

    static int calculateMod(int a, int b, int m){
//        return (a * b) % m;
        return ((a % m) * (b % m)) % m;
    }
}

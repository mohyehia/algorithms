package com.mohyehia.algo.bits;

/**
 * Created by Mohamed.Yehia
 * Date: 4/11/2020
 * Time: 10:28 AM
 */
public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwoUsingModule(8));
        System.out.println(isPowerOfTwoUsingModule(16));
        System.out.println(isPowerOfTwo(64));
        System.out.println(isPowerOfTwo(128));
    }
    /*
    the known function to check if number is power of two
    Time complexity => O(Log(N))
     */
    static boolean isPowerOfTwoUsingModule(int n){
        if(n <= 0) return false;
        while(n % 2 == 0) n /= 2;
        return n == 1;
    }
    /*
    Solution using bit manipulation
    if n is power of two then it has only one bitSet in its binary representation
    ex: n = 8 => 1000
    ex: n = 4 => 100
    if we check for (n - 1) it will have the same as n bits but reversed
    ex n - 1 = 7 => 0111
    ex n - 1 = 3 => 011
    so if n is Power of two then:
    n & (n - 1) = 0
    Time complexity => O(1)
     */
    static boolean isPowerOfTwo(int n){
        return (n > 0) &&
                ((n & (n - 1)) == 0);
    }
}

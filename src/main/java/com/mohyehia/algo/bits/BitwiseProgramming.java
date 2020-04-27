package com.mohyehia.algo.bits;

/**
 * Created by Mohamed.Yehia
 * Date: 4/12/2020
 * Time: 8:17 AM
 */
public class BitwiseProgramming {
    // Check if the ith bit is set in the binary form of the given number.
    public static void main(String[] args) {
        System.out.println(isKthBitSet(20, 3));
        int a = 5, b = 7;
        swap(a, b);
    }
    /*
    Steps to check for the ith bit is set or not
    1) Left shift given number 1 by k-1 to create
        a number that has only set bit as k-th bit.
    temp = 1 << (k-1)
    2) If bitwise AND of n and temp is non-zero,
        then result is SET else result is NOT SET.
     */
    static boolean isKthBitSet(int n, int k){
        int temp = 1 << (k - 1);
        return (n & temp) != 0;
    }

    /*
    Setting K-th bit
    For a given number n , to set the K-th, use the following expression: n | 1 << (K-1).
    Example: n = 01001011 And K = 3
     */
    static int setBit(int n, int k){
        return (n | (1 << (k - 1)));
    }

    /*
    Clearing K-th bit
    To clear K-th bit of a given number n, use the following expression: n & ~ (1 << K -1).
    Example: n = 01001011 And K = 4
     */
    static int clearBit(int n, int k){
        return (n & ~(1 << (k - 1)));
    }

    /*
    Toggling K-th bit
    For a given number n, for toggling the K-th bit, use the expression: n ^ (1 << K -1).
    Example: n = 01001011 And K = 3
     */
    static int toggleBit(int n, int k){
        // 1 << (K - 1)    00000100
        return (n ^ (1 << (k -1)));
    }

    /*
    Multiplying number by power of 2
    For a given number n, to multiply the number with 2 raised to power K, use the following expression: n << K.
    Example: n = 25 = 11001  and K = 3 means => n * 2^k = 25 * 2^3 = 25 * 8 = 200
    so, answer is 200 => 11001000
     */
    static int multiplyNumberByPowerOfTwo(int n, int k){
        return n << k; // 11001000
    }

    /*
    Dividing number by power of 2
    For a given number n, to divide the number with 2 raised to power K, use the following expression: n >> k.
    Example: n = 200 = 11001000 And K = 3 means => n / 2^k = 200 / 2^3 = 200 / 8 = 25
    so, answer is 25 => 11001
     */
    static int divideNumberByPowerOfTwo(int n, int k){
        return n >> k; // 11001
    }

    /*
    check if number is even or odd
    if (n & 1) == 0, so the number is even
    else the number is odd
    ex => 4 & 1 => 100 & 001 = 0 => 4 is even
    ex => 5 $ 1 => 101 & 001 = 1 => 5 is odd
     */
    static boolean isNumberEven(int n){
        return (n & 1) == 0;
    }

    /*
    Swap two integers a and b
    using xor operation
     */
    static void swap(int a, int b){
        System.out.println("Before a =" + a + ", b=" + b);
        a ^= b;
        b ^= a;
        a ^= b;
        System.out.println("After a =" + a + ", b=" + b);
    }
}

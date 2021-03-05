package com.mohyehia.algo.bits;

import java.sql.Time;
import java.util.Arrays;

/**
 * Created by Mohamed.Yehia
 * Date: 4/11/2020
 * Time: 4:41 PM
 */
public class NumberOfOnesInBinaryRepresentation {
    public static void main(String[] args) {
//        String s = Integer.toBinaryString(35);
        String s = decimalToBinary(35);
        System.out.println("Binary representation is " + s);
        int count = 0;
        for(char c : s.toCharArray())
            if(c == '1') count++;
        System.out.println(count);
        System.out.println(countBitSet(35));
    }

    static String decimalToBinary(int num){
        int[] binary = new int[40];
        int index = 0;
        while(num > 0){
            binary[index++] = num % 2;
            num /= 2;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = index - 1; i >= 0; i--)
            sb.append(binary[i]);
        return sb.toString();
    }

    /*
     Time complexity = O(K),
     where K is the number of ones present in the binary form of the given number.
     ex: n = 23 = 10111 & n - 1 = 22 = 10110 & count = 0. in each round in loop:
     n = 22 = 10110 & n - 1 = 21 = 10101 & count = 1
     n = 20 = 10100 & n - 1 = 19 = 10011 & count = 2
     n = 16 = 10000 & n - 1 = 15 = 01111 & count = 3
     n = 0 & count = 4 & loop terminated
     this solution works only for positive numbers
     */
    static int countBitSet(int num){
        int cnt = 0;
        while(num > 0){
            num = num & (num - 1);
            cnt++;
        }
        return cnt;
    }

    /*
    if n is 32 bit signed integer, it's represented by 2's complement
    so the leftmost bit (sign bit) is 1 and we will subtract it from number
    this solution works only for negative numbers
     */
    static int countUnsignedBitSet(int num){
        int count = 0;
        if(num < 0)
            num = num * -1 - 1; // convert the number to positive & remove the last bit as it is the sign bit
        while(num > 0){
            num = num & (num - 1);
            count++;
        }
        /*
         count is now only the number of 1s in the 2's complement,
         so we subtract it from 32 (size of the unsigned integer)
         */
        return 32 - count;
    }
    /*
    Hamming Distance
    The Hamming distance between two integers is the number of
     positions at which the corresponding bits are different.
     Given two integers x and y, calculate the Hamming distance
     hamming distance between 2 integers is number of ones in their xor
     ex (1 ^ 4) = 5 and number of ones in 5 is 2
     */
    static int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0;
        while(n > 0){
            n &= (n - 1);
            count++;
        }
        return count;
    }

    /*
    Another solution for counting the number of 1's in binary representation of number
    Works for positive & negative number
     */
    static int anotherCountBitSet(int n){
        int cnt = 0;
        for(int i = 0; i < 32; i++){
            if((n & 1) != 0) cnt++;
        }
        return cnt;
    }
}

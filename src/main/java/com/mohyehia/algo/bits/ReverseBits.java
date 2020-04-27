package com.mohyehia.algo.bits;

/**
 * Created by Mohamed.Yehia
 * Date: 4/18/2020
 * Time: 1:03 PM
 */
public class ReverseBits {
    public static void main(String[] args) {
        System.out.println(reverseBits(10));
    }
    static int reverseBits(int n) {
        int ans = 0;
        while(n > 0){
            // left shift ans by one
            ans <<= 1;
            // if first bit of n is one then, xor it with ans
            if((n & 1) == 1) ans ^= 1;
            // right shift n by one to get rid of the current bit
            n >>= 1;
        }
        return ans;
    }
}

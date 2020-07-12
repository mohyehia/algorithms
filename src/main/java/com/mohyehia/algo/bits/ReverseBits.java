package com.mohyehia.algo.bits;

/**
 * Created by Mohamed.Yehia
 * Date: 4/18/2020
 * Time: 1:03 PM
 */
public class ReverseBits {
    public static void main(String[] args) {
        int n = 123456;
        System.out.println(Integer.reverse(n));
        System.out.println(reverseBits(n));
    }
    /*
    Time complexity => O(1)
    Space complexity => O(1)
     */
    static int reverseBits(int n) {
        int ans = 0;
        for(int i = 0; i < 32; i++){
            // left shift answer to add the new bit whether it's 1 or 0
            ans <<= 1;
            // add 1 if the MSB is 1, else add 0
            if((n & 1) != 0) ans++;
            // right shift n to get the next bit
            n >>= 1;
        }
        return ans;
    }
}

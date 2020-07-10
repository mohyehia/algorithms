package com.mohyehia.algo.bits;

/**
 * Created by mohammed
 * Date: 7/9/20
 * Time: 4:51 PM
 */
public class SumOf2Integers {
    public static void main(String[] args) {
        System.out.println(getSum(4, 6));
        System.out.println(getSum(-3, -7));
    }
    static int getSum(int a, int b){
        // Iterate till there is no carry
        while(b != 0){
            // carry now contains common set bits of a & b
            int carry = a & b;
            /*
            sum of bits of a & b where at least
            one of the bits is not set
             */
            a = a ^ b;
            /*
            carry is shifted by one so that adding it
            to a gives the required sum
             */
            b = carry << 1;
        }
        return a;
    }
}

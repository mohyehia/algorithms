package com.mohyehia.algo.bits;

public class AndOfNumbersRange {
    /*
    The trick here is that :
     Bitwise-AND of any two numbers will always produce a number
     less than or equal to the smaller number
     n & (n-1) turns off the right most bit.
     */
    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0) return 0;
        while(n > m) n &= (n-1);
        return n;
    }
}

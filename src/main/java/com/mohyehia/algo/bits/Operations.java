package com.mohyehia.algo.bits;

/**
 * Created by Mohamed.Yehia
 * Date: 4/10/2020
 * Time: 9:35 AM
 */
public class Operations {
    public static void main(String[] args) {
        int a = 5, b = 3;
        // not operator or Complement operator => ~
        System.out.println(~a);
        System.out.println(~b);
        // and operator => &
        System.out.println(a & b); // 0101 & 0011 = 0001 = 1
        // or operator => |
        System.out.println(a | b); // 0101 | 0011 = 0111 = 7
        // XOR operator => ^
        System.out.println(a ^ b); // 0101 ^ 0011 = 0110 = 6
        // Left shift operator => <<
        System.out.println(a << 2); // 0000 0101 << 2 = 0001 0100 = 20
        // Right shift operator => >>
        System.out.println(a >> 2); // 0101 >> 2 = 0001 = 1
        /*
        note about the right shift operator:
        =>When an input number is negative, where the leftmost bit is 1,
            then the empty spaces will be filled with 1
        =>When an input number is positive, where the leftmost bit is 0,
            then the empty spaces will be filled with 0
         */

        System.out.println(1 << 4); // 1 << n = 2^n => 2^4 = 16
    }
}

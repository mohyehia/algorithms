package com.mohyehia.algo.bits;

/**
 * Created by Mohamed.Yehia
 * Date: 4/18/2020
 * Time: 10:35 AM
 */
public class AddBinary {
    public static void main(String[] args) {
        String a = "1100011", b = "10";
        int x = Character.getNumericValue('0');
        System.out.println(x);
        System.out.println(addBinary(a, b));
    }

    /*
    WE use Character.getNumericValue(char) to get the number not the character
    of the '0' or '1'
    ASCII code of '0' = 48, 1 => 49 ....
    so we get the numeric value not the character code
    also we can use char - '0' to subtract the ascii code from it

     */
    static String addBinary(String a, String b){
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        int bitA, bitB, sum, carry = 0;
        while(Math.max(i, j) >= 0){
            bitA = i >= 0 ? Character.getNumericValue(a.charAt(i--)) : 0;
            bitB = j >= 0 ? Character.getNumericValue(b.charAt(j--)) : 0;
            sum = bitA ^ bitB ^ carry;
            sb.append(sum);
            carry = (bitA & bitB) | (bitB & carry) | (bitA & carry);
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}

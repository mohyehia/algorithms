package com.mohyehia.algo.bits;

public class PowerOfFour {
    public static void main(String[] args) {
        System.out.println(powerOfFourUsingModule(16));
        System.out.println(powerOfFourUsingBits(16));

        System.out.println(powerOfFourUsingModule(128));
        System.out.println(powerOfFourUsingBits(128));
    }
    /**
     * @param n the number to check if it's power of four
     * @return true or false
     * @TimeComplexity O(log(n))
     */
    static boolean powerOfFourUsingModule(int n) {
        if (n <= 0) return false;
        while (n % 4 == 0) n /= 4;
        return n == 1;
    }

    /**
     * @param n the number to check if it's power of four
     * @return true or false
     * First we check if the number is power of two or not
     * If power of two, then we check if (number - 1) is divisible by 3
     * for ex: 16 => is power of two
     * so, we check if 15 is divisible by 3 which is correct
     * so the number 16 is power of 4
     * @Timecomplexity O(1)
     */
    static boolean powerOfFourUsingBits(int n) {
        if (n <= 0) return false;
        return (n & (n - 1)) == 0 && ((n - 1) % 3) == 0;
    }
}

package com.mohyehia.algo.recursion;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

/**
 * Created by Mohamed.Yehia
 * Date: 4/8/2020
 * Time: 10:26 PM
 */
public class Fibonacci {
    static int[] fib = new int[100];
    public static void main(String[] args) {
        Arrays.fill(fib, -1);
        Instant start, end;
//        start = Instant.now();
//        System.out.println(iterativeFib(45));
//        end = Instant.now();
//        System.out.println("Time for iterativeFib is =>" + Duration.between(start, end).toMillis());
//
//        start = Instant.now();
//        System.out.println(optimizedFib(45));
//        end = Instant.now();
//        System.out.println("Time for optimizedFib is =>" + Duration.between(start, end).toMillis());
//
        start = Instant.now();
        System.out.println(fibonacci(45));
        end = Instant.now();
        System.out.println("Time for recursiveFibonacci is =>" + Duration.between(start, end).toMillis());

        start = Instant.now();
        System.out.println(fibWithMemoization(45));
        end = Instant.now();
        System.out.println("Time for fibWithMemoization is =>" + Duration.between(start, end).toMillis());
    }
    /*
    Time Complexity => O(2^N) exponential
     */
    static int fibonacci(int n){
        if(n < 2)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    /*
    Time Complexity => O(N)
     */
    static int iterativeFib(int n){
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }
    /*
    Time Complexity => O(N)
     */
    static int optimizedFib(int n){
        if(n < 2)
            return n;
        int fib = 0, f1 = 0, f2 = 1;
        for(int i = 2; i <= n; i++){
            fib = f1 + f2;
            f1 = f2;
            f2 = fib;
        }
        return fib;
    }

    /*
    Recursion with Memoization
    memoization is to avoid recalculating the same state over and over again
    simply save the already calculated states in an array for ex and check
    if the state is already calculated then return it else compute it.
    time complexity => O(N)
     */
    static int fibWithMemoization(int n){
        if(n < 2) return n;
        if(fib[n] != -1) return fib[n];
        fib[n] = fibWithMemoization(n - 1) + fibWithMemoization(n - 2);
        return fib[n];
    }
}

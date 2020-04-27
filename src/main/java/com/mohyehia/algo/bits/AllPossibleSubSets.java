package com.mohyehia.algo.bits;

/**
 * Created by Mohamed.Yehia
 * Date: 4/15/2020
 * Time: 7:44 AM
 */
public class AllPossibleSubSets {
    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c'};
        // number of possible subsets =  2^N = 2^3 = 8
        possibleSubsets(a);
    }
    /*
      There are 2^N possible subsets of any given set with N elements.
      What if we represent each element in a subset with a bit. A bit can be either 0 or 1.
      Consider a set A of 3 elements. A = {'a', 'b', 'c'}
      Now, we need 3 bits, one bit for each element. 1 represent that the corresponding element
       is present in the subset, whereas 0 represent the corresponding element is not in the subset.
       possible combination of these 3 bits:
        0 = (000)2 = {} the empty set or the rule set
        1 = (001)2 = {c}
        2 = (010)2 = {b}
        3 = (011)2 = {b, c}
        4 = (100)2 = {a}
        5 = (101)2 = {a, c}
        6 = (110)2 = {a, b}
        7 = (111)2 = {a, b, c}
     */
    static void possibleSubsets(char[] a){
        int len = 1 << a.length; // 2^a.length
        for(int i = 0; i < len; i++){
            for(int j = 0; j < a.length; j++)
                // if jth bit is set in i:
                if((i & (1 << j)) != 0) System.out.print(a[j] + " ");
            System.out.println();
        }
    }
}

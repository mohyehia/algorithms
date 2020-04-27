package com.mohyehia.algo.greedy;

import java.util.Arrays;

/**
 * Created by Mohamed.Yehia
 * Date: 4/24/2020
 * Time: 11:50 PM
 */
public class KnapsackProblem {
    /*
    If u have bag that can carry only K grams,
    what is the maximum value that u can get??
     */
    public static void main(String[] args) {
        int[] w = {6, 10, 3, 5, 7, 3};
        int[] v = {6, 2, 1, 8, 3, 5};
        int[] p = {36, 20, 3, 40, 21, 15};

        /*
        6 => 36
        10 => 20
        3 => 3
        5 => 40
        7 => 21
        3 => 15
         */

        System.out.println(maxValue(w, v, 20));
    }

    /* Greedy Solution
   greedy solution is optimal if u can take a fraction of the item
   for ex: if only we can take only what we want from the weight of the item
     */
    static int maxValue(int[] w, int[] v, int k){
        int len = w.length;
        Item[] items = new Item[len];
        for(int i = 0; i < len; i++)
            items[i] = new Item(w[i], v[i]);
        // sort items based on greater value
        Arrays.sort(items, (item1, item2) -> item2.v - item1.v);

        int ans = 0, temp;
        for(Item item : items){
            if(k == 0) break;
            temp = Math.min(item.w, k);
            ans += temp * item.v;
            k -= temp;
        }
        return ans;
    }

    static class Item{
        int w, v;
        public Item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
}

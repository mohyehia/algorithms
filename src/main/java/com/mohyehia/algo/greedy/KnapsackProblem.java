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
        int[] weight = {6, 10, 3, 5, 7, 3};
        int[] val = {6, 2, 1, 8, 3, 5};
        int[] p = {36, 20, 3, 40, 21, 15};
        int k = 20;

        /*
        6 => 36
        10 => 20
        3 => 3
        5 => 40
        7 => 21
        3 => 15
         */

        System.out.println(maxValue(weight, val, k));
    }

    /* Greedy Solution
   greedy solution is optimal if u can take a fraction of the item
   for ex: if only we can take only what we want from the weight of the item
     */
    static int maxValue(int[] weight, int[] val, int k){
        int len = weight.length;
        Item[] items = new Item[len];
        for(int i = 0; i < len; i++)
            items[i] = new Item(weight[i], val[i]);
        // sort items based on greater value
        Arrays.sort(items, (item1, item2) -> item2.val - item1.val);

        int ans = 0, temp;
        for(Item item : items){
            if(k == 0) break;
            temp = Math.min(item.weight, k);
            ans += temp * item.val;
            k -= temp;
        }
        return ans;
    }

    static class Item{
        int weight, val;
        public Item(int weight, int val) {
            this.weight = weight;
            this.val = val;
        }
    }
}

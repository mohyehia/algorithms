package com.mohyehia.algo.dp;

/**
 * Created by Mohamed.Yehia
 * Date: 4/17/2020
 * Time: 12:36 PM
 */
public class BuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int bestWithoutStock = 0, bestWithStock = Integer.MIN_VALUE;
        for(int price : prices){
            bestWithStock = Math.max(bestWithStock, bestWithoutStock - price);
            bestWithoutStock = Math.max(bestWithoutStock, bestWithStock + price);
        }
        return bestWithoutStock;
    }
}

package com.abhilash.codinginterview.arrays;
/* 
 * Max one trasaction allowed
 */
public class BuyAndSellStocks {

    public static void main(String[] args) {
        int[] prices = new int[]{ 7, 10, 1, 3, 6, 9, 2 };
        System.out.println(getMaximumProfit2(prices));
    }

    /* 
     * Brute force approach
     * Run two loops and get the max profit
     */
    public static int getMaximumProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;

        for (int i = 0; i < n; i ++) {
            for (int j = i + 1; j < n; j ++) maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
        }
        return maxProfit;
    }

    /* 
     * Two pointer approach
     */
    public static int getMaximumProfit2(int[] prices) {
        /* 
         * Basic thought process is:
         * At a particular place, check if sold at that place, what is the maximum profit can be generated
         * Meaning, subtract the minimum cost from the current element/cost
         */
        int minmumpriceindex = 0;
        int maxProfit = 0;
        int n = prices.length;
        for (int i = 1; i < n; i ++) {
            maxProfit = Math.max(maxProfit, prices[i] - prices[minmumpriceindex]);
            if (prices[minmumpriceindex] > prices[i]) minmumpriceindex = i;
        }
        return maxProfit;
    }
}
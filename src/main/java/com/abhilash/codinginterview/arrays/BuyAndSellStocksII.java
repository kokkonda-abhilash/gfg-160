package com.abhilash.codinginterview.arrays;

public class BuyAndSellStocksII {

    public static void main(String[] args) {
        int[] prices = new int[]{ 4, 2, 2, 2, 4 };
        BuyAndSellStocksII buyAndSellStocksII = new BuyAndSellStocksII();
        System.out.println(buyAndSellStocksII.getMaximumProfit(prices));
    }

    /* 
     * 
     */
    public int getMaximumProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) return 0;
        int n = prices.length;
        int cumulativeprofit = 0;
        for (int i = 1; i < n - 1; i ++) {
            if (prices[i] >= prices[i - 1]) cumulativeprofit += (prices[i] - prices[i - 1]);
        }
        if (prices[n -1] > prices[n - 2]) cumulativeprofit += (prices[n - 1]) - prices[n - 2];
        return cumulativeprofit;
    }
}

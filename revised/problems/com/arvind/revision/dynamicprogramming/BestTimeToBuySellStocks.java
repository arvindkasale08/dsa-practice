package com.arvind.revision.dynamicprogramming;

public class BestTimeToBuySellStocks {

    public int maxProfit(int[] prices) {
        int profit = 0;
        int minSoFar = prices[0];
        for (int i=1; i<prices.length; i++) {
            if (prices[i] > minSoFar) {
                profit = Math.max(profit, prices[i] - minSoFar);
            }
            minSoFar = Math.min(minSoFar, prices[i]);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new BestTimeToBuySellStocks().maxProfit(prices));
    }
}

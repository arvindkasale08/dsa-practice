package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return maxProfitMemo(0, 1, prices, dp);
        //return maxProfitRecur(0, -1, prices);
    }

    private int maxProfitMemo(int i, int canBuy, int[] prices, int[][] dp) {
        if (i >= prices.length) return 0;
        if (dp[i][canBuy] != -1) return dp[i][canBuy];
        int buy = 0, sell = 0;
        if (canBuy == 1) {
            buy = -prices[i] + maxProfitMemo(i + 1, 0, prices, dp);
        }
        if (canBuy == 0) {
            sell = prices[i] + maxProfitMemo(i + 1, 1, prices, dp);
        }
        int doNothing = maxProfitMemo(i+1, canBuy, prices, dp);
        dp[i][canBuy] = Math.max(Math.max(buy, sell), doNothing);
        return dp[i][canBuy];
    }

    private int maxProfitRecur(int i, int bought, int[] prices) {
        if (i >= prices.length) return 0;
        int buy = 0, sell = 0;
        if (bought == -1) {
            buy = maxProfitRecur(i + 1, i, prices);
        }
        if (bought != -1) {
            sell = (prices[i] - prices[bought]) + maxProfitRecur(i + 1, -1, prices);
        }
        int doNothing = maxProfitRecur(i+1, bought, prices);
        return Math.max(Math.max(buy, sell), doNothing);
    }

    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        BestTimeToBuyAndSellStockII solution = new BestTimeToBuyAndSellStockII();
        System.out.println(solution.maxProfit(prices));
    }
}

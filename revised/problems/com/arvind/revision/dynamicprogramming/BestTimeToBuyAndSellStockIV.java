package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for (int[][] d : dp) {
            for (int[] x : d) {
                Arrays.fill(x, -1);
            }
        }
        return maxProfitMemo(0, 1, 0, k, prices, dp);
        //return maxProfitRecur(0, 1, 0, 2, prices);
    }

    private int maxProfitMemo(int i, int canBuy, int count, int k, int[] prices, int[][][] dp) {
        if (count >= k) return 0;
        if (i >= prices.length) return 0;
        if (dp[i][canBuy][count] != -1) return dp[i][canBuy][count];
        int buy = 0, sell = 0, nothing;
        if (canBuy == 1) {
            buy = -prices[i] + maxProfitMemo(i+1, 0, count, k, prices, dp);
        }
        if (canBuy == 0) {
            sell = prices[i] + maxProfitMemo(i+1, 1, count+1, k, prices, dp);
        }
        nothing = maxProfitMemo(i+1, canBuy, count, k, prices, dp);

        dp[i][canBuy][count] = Math.max(Math.max(buy, sell), nothing);

        return dp[i][canBuy][count];
    }

    private int maxProfitRecur(int i, int canBuy, int count, int k, int[] prices) {
        if (count == k) return 0;
        if (i >= prices.length) return 0;
        int buy = 0, sell = 0, nothing;
        if (canBuy == 1) {
            buy = -prices[i] + maxProfitRecur(i+1, 0, count, k, prices);
        }
        if (canBuy == 0) {
            sell = prices[i] + maxProfitRecur(i+1, 1, count+1, k, prices);
        }
        nothing = maxProfitRecur(i+1, canBuy, count, k, prices);

        return Math.max(Math.max(buy, sell), nothing);
    }

    public static void main(String[] args) {
        int[] prices2 = {2,1,4,5,2,9,7};
        int[] prices = {3,3,5,0,0,3,1,4};
        int[] prices3 = {3,2,6,5,0,3};
        int k = 2;
        BestTimeToBuyAndSellStockIV solution = new BestTimeToBuyAndSellStockIV();
        System.out.println(solution.maxProfit(k, prices3));
    }
}

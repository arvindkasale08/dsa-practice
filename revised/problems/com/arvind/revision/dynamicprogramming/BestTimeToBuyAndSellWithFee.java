package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class BestTimeToBuyAndSellWithFee {

    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return maxProfitMemo(0, 1, prices, fee, dp);
    }

    private int maxProfitRecur(int i, int canBuy, int[] prices, int fee) {
        if (i >= prices.length) return 0;
        int buy = 0, sell = 0, nothing;
        if (canBuy == 1) {
            buy = -prices[i] + maxProfitRecur(i+1, 0, prices, fee);
        }
        if (canBuy == 0) {
            sell = -fee + prices[i] + maxProfitRecur(i+1, 1, prices, fee);
        }
        nothing = maxProfitRecur(i+1, canBuy, prices, fee);
        return Math.max(Math.max(buy, sell), nothing);
    }

    private int maxProfitMemo(int i, int canBuy, int[] prices, int fee, int[][] dp) {
        if (i >= prices.length) return 0;
        if (dp[i][canBuy] != -1) return dp[i][canBuy];
        int buy = 0, sell = 0, nothing;
        if (canBuy == 1) {
            buy = -prices[i] + maxProfitMemo(i+1, 0, prices, fee, dp);
        }
        if (canBuy == 0) {
            sell = -fee + prices[i] + maxProfitMemo(i+1, 1, prices, fee, dp);
        }
        nothing = maxProfitMemo(i+1, canBuy, prices, fee, dp);
        dp[i][canBuy] = Math.max(Math.max(buy, sell), nothing);
        return dp[i][canBuy];
    }

    public static void main(String[] args) {
        int[] prices = {1,3,2,8,4,9};
        int[] prices2 = {1,3,7,5,10,3};
        int fee = 2;
        int fee2 = 3;
        BestTimeToBuyAndSellWithFee solution = new BestTimeToBuyAndSellWithFee();
        System.out.println(solution.maxProfit(prices2, fee2));
    }
}

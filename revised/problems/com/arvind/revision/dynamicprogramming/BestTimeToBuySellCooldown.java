package com.arvind.revision.dynamicprogramming;

import neetcode.BestTimeToBuySellStockCoolDown;

import java.util.Arrays;

public class BestTimeToBuySellCooldown {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return maxProfitMemo(0, 1, prices, dp);
        //return maxProfitRecur(0, 1, prices);
    }

    private int maxProfitMemo(int i, int canBuy, int[] prices, int[][] dp) {
        if (i >= prices.length) return 0;
        if (dp[i][canBuy] != -1) return dp[i][canBuy];
        int buy = 0, sell = 0, nothing;
        if (canBuy == 1) {
            buy = -prices[i] + maxProfitMemo(i+1, 0, prices, dp);
        }
        if (canBuy == 0) {
            sell = prices[i] + maxProfitMemo(i+2, 1, prices, dp);
        }
        nothing = maxProfitMemo(i+1, canBuy, prices, dp);
        dp[i][canBuy] = Math.max(Math.max(buy, sell), nothing);
        return dp[i][canBuy];
    }

    private int maxProfitRecur(int i, int canBuy, int[] prices) {
        if (i >= prices.length) return 0;
        int buy = 0, sell = 0, nothing;
        if (canBuy == 1) {
            buy = -prices[i] + maxProfitRecur(i+1, 0, prices);
        }
        if (canBuy == 0) {
            sell = prices[i] + maxProfitRecur(i+2, 1, prices);
        }
        nothing = maxProfitRecur(i+1, canBuy, prices);

        return Math.max(Math.max(buy, sell), nothing);
    }

    public static void main(String[] args) {
        int[] prices = new int[] {1,2,3,0,2};
        BestTimeToBuySellCooldown solution = new BestTimeToBuySellCooldown();
        System.out.println(solution.maxProfit(prices));
    }
}

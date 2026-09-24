package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        if (amount == 0) return 0;
        //int noOfCoins = coinChangeRecur(0, amount, coins);
        int noOfCoins = coinChangeMemo(0, amount, coins, dp);
        return noOfCoins == 1_000_000 ? -1 : noOfCoins;
    }

    private int coinChangeMemo(int i, int amount, int[] coins, int[][] dp) {
        if (amount < 0) return 1_000_000;
        if (amount == 0) return 0;
        if (i >= coins.length) return 1_000_000;
        if (dp[i][amount] != -1) return dp[i][amount];

        int pick = 1 + coinChangeMemo(i, amount - coins[i], coins, dp);
        int dontPick = coinChangeMemo(i+1, amount, coins, dp);
        dp[i][amount] = Math.min(pick, dontPick);
        return dp[i][amount];
    }

    private int coinChangeRecur(int i, int amount, int[] coins) {
        if (amount < 0) return 1_000_000;
        if (amount == 0) return 0;
        if (i >= coins.length) return 1_000_000;

        int pick = 1 + coinChangeRecur(i, amount - coins[i], coins);
        int dontPick = coinChangeRecur(i+1, amount, coins);

        return Math.min(pick, dontPick);
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        CoinChange solution = new CoinChange();
        System.out.println(solution.coinChange(coins, amount));
    }
}

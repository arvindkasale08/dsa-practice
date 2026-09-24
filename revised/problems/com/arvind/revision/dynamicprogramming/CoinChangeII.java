package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class CoinChangeII {

    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return changeRecurMemo(0, amount, coins, dp);
        //return changeRecur(0, amount, coins);
    }

    private int changeRecurMemo(int i, int amount, int[] coins, int[][] dp) {
        if (amount == 0) return 1;
        if (amount < 0) return 0;
        if (i >= coins.length) return 0;
        if (dp[i][amount] != -1) return dp[i][amount];

        int move = changeRecurMemo(i+1, amount, coins, dp);
        int dontMove = changeRecurMemo(i, amount - coins[i], coins, dp);
        dp[i][amount] = move + dontMove;
        return dp[i][amount];
    }

    private int changeRecur(int i, int amount, int[] coins) {
        if (amount == 0) return 1;
        if (amount < 0) return 0;
        if (i >= coins.length) return 0;

        int move = changeRecur(i+1, amount, coins);
        int dontMove = changeRecur(i, amount - coins[i], coins);

        return move + dontMove;
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 5;
        CoinChangeII solution = new CoinChangeII();
        System.out.println(solution.change(amount, coins));
    }
}

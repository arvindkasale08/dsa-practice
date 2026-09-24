package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class UnboundedKnapsack {

    public int unboundedKnapsack(int[] wt, int[] val, int W) {
        int[][] dp = new int[wt.length+1][W+1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return unboundedKnapsackMemo(0, wt, val, W, dp);
        //return unboundedKnapsackRecur(0, wt, val, W);
    }

    private int unboundedKnapsackMemo(int i, int[] wt, int[] val, int W, int[][] dp) {
        if (W <= 0) return 0;
        if (i >= wt.length) return 0;
        if (dp[i][W] != -1) return dp[i][W];
        int pick = 0;
        if (wt[i] <= W) {
            pick = val[i] + unboundedKnapsackMemo(i, wt, val, W - wt[i], dp);
        }
        int dontPick = unboundedKnapsackMemo(i+1, wt, val, W, dp);
        dp[i][W] = Math.max(pick, dontPick);
        return dp[i][W];
    }

    private int unboundedKnapsackRecur(int i, int[] wt, int[] val, int W) {
        if (W <= 0) return 0;
        if (i >= wt.length) return 0;
        int pick = 0;
        if (wt[i] <= W) {
            pick = val[i] + unboundedKnapsackRecur(i, wt, val, W - wt[i]);
        }
        int dontPick = unboundedKnapsackRecur(i+1, wt, val, W);
        return Math.max(pick, dontPick);
    }

    public static void main(String[] args) {
        int[] val = {10, 40, 50, 70};
        int[] wt = {1, 3, 4, 5};
        int W = 8;
        UnboundedKnapsack solution = new UnboundedKnapsack();
        System.out.println(solution.unboundedKnapsack(wt, val, W));
    }
}

package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class OIKnapsack {

    public int solveKnapsack(int[] profits, int[] weights, int capacity) {
        int n = profits.length;
        int[][] dp = new int[n][capacity+1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return solveKnapsackMemo(0, profits, weights, capacity, dp);
        //return solveKnapsackRecur(0, profits, weights, capacity);
    }

    private int solveKnapsackMemo(int i, int[] profits, int[] weights, int capacity, int[][] dp) {
        if (i >= profits.length) return 0;
        if (capacity <= 0) return 0;
        if (dp[i][capacity] != -1) return dp[i][capacity];
        int pick = 0;
        if (weights[i] <= capacity) {
            pick = profits[i] + solveKnapsackMemo(i + 1, profits, weights, capacity - weights[i], dp);
        }
        int dontPick = solveKnapsackMemo(i+1, profits, weights, capacity, dp);
        dp[i][capacity] = Math.max(pick, dontPick);
        return dp[i][capacity];
    }

    private int solveKnapsackRecur(int i, int[] profits, int[] weights, int capacity) {
        if (i >= profits.length) return 0;
        if (capacity <= 0) return 0;
        int pick = 0;
        if (weights[i] <= capacity) {
            pick = profits[i] + solveKnapsackRecur(i + 1, profits, weights, capacity - weights[i]);
        }
        int dontPick = solveKnapsackRecur(i+1, profits, weights, capacity);
        return Math.max(pick, dontPick);
    }

    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int capacity = 6;
        OIKnapsack solution = new OIKnapsack();
        System.out.println(solution.solveKnapsack(profits, weights, capacity));
    }
}

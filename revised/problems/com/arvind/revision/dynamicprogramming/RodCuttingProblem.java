package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class RodCuttingProblem {

    public int rodCutting(int price[], int n) {
        int[][] dp = new int[price.length+1][n+1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return rodCuttingRecurMemo(0, 1, price, n, dp);
        //return rodCuttingRecur(0, 1, price, n);
    }

    private int rodCuttingRecurMemo(int i, int length, int[] price, int n, int[][] dp) {
        if (i >= price.length) return 0;
        if (dp[i][length] != -1) return dp[i][length];

        int cutHere = price[length-1] + rodCuttingRecurMemo(i+1, 1, price, n, dp);
        int dontCutHere = rodCuttingRecurMemo(i+1, length+1, price, n, dp);
        dp[i][length] = Math.max(cutHere, dontCutHere);
        return dp[i][length];
    }

    private int rodCuttingRecur(int i, int length, int[] price, int n) {
        if (i >= price.length) return 0;

        int cutHere = price[length-1] + rodCuttingRecur(i+1, 1, price, n);
        int dontCutHere = rodCuttingRecur(i+1, length+1, price, n);

        return Math.max(cutHere, dontCutHere);
    }

    public static void main(String[] args) {
        int[] price = {1, 6, 8, 9, 10, 19, 7, 20};
        int[] price2 = {1, 5, 8, 9};
        int N = 8;
        int N2 = 4;
        RodCuttingProblem solution = new RodCuttingProblem();
        System.out.println(solution.rodCutting(price2, N2));
    }
}

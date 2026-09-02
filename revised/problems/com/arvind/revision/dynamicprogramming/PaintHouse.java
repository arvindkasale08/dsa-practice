package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class PaintHouse {

    public int minCost(int[][] costs) {
        int noOfHouses = costs.length;
        int[][] dp = new int[noOfHouses][4];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        //return minCostRecur(0, noOfHouses, -1, costs);
        return minCostMemo(0, noOfHouses, 3, costs, dp);
    }

    private int minCostMemo(int i, int noOfHouses, int lastColor, int[][] costs, int[][] dp) {
        if (i >= noOfHouses) return 0;
        if (lastColor != -1 && dp[i][lastColor] != -1) return dp[i][lastColor];
        int minCost = 1_000_000;
        for (int col=0; col<3; col++) {
            if (lastColor != col) {
                minCost = Math.min(minCost, costs[i][col] + minCostMemo(i+1, noOfHouses, col, costs, dp));
            }
        }
        dp[i][lastColor] = minCost;
        return dp[i][lastColor];
    }

    private int minCostRecur(int i, int noOfHouses, int lastColor, int[][] costs) {

        if (i >= noOfHouses) return 0;
        int minCost = 1_000_000;
        for (int col=0; col<3; col++) {
            if (lastColor != col) {
                minCost = Math.min(minCost, costs[i][col] + minCostRecur(i+1, noOfHouses, col, costs));
            }
        }
        return minCost;
    }

    public static void main(String[] args) {
        int[][] costs = {
                {17, 2, 17},
                {16, 16, 5},
                {14, 3, 19}
        };
        PaintHouse solution = new PaintHouse();
        System.out.println(solution.minCost(costs));
    }
}

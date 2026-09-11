package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        return solveTab(grid);
        /*int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return solveMemo(0, 0, m, n, grid, dp);*/
        /*return solveRecur(0, 0, 0, m, n, grid);*/
    }

    public int solveTab(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        // fill the first row
        for (int j=1; j<n; j++) {
            dp[0][j] = grid[0][j] + dp[0][j-1];
        }

        // fill the first column
        for (int i=1; i<m; i++) {
            dp[i][0] = grid[i][0] + dp[i-1][0];
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[m-1][n-1];
    }

    public int solveMemo(int i, int j, int m, int n, int[][] grid, int[][] dp) {
        if (i >= m || j >= n) return 1_000_000;
        if (i == m-1 && j == n-1) return grid[i][j];
        if (dp[i][j] != -1) return dp[i][j];
        dp[i][j] = grid[i][j] + Math.min(
                solveMemo(i+1, j, m, n, grid, dp),
                solveMemo(i, j+1, m, n, grid, dp)
        );
        return dp[i][j];
    }

    public int solveRecur(int i, int j, int sum, int m, int n, int[][] grid) {
        if (i >= m || j >= n) return 1_000_000;
        int newSum = sum + grid[i][j];
        if (i == m-1 && j == n-1) return newSum;

        return Math.min(solveRecur(i+1, j, newSum, m, n, grid), solveRecur(i, j+1, newSum, m, n, grid));
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        MinimumPathSum solution = new MinimumPathSum();
        System.out.println(solution.minPathSum(grid));
    }
}

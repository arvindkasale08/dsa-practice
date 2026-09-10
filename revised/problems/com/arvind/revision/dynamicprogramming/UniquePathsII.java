package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] grid) {
        return solveTab(grid);
        /*int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return solveMemo(0, 0, m, n, grid, dp);*/
        //return solveRecur(0, 0, m, n, grid);
    }

    private int solveTab(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // put 0,0 value
        dp[0][0] = grid[0][0] == 0 ? 1 : 0;

        for (int j=1; j<n ;j++) {
            if (grid[0][j] == 1) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = dp[0][j-1];
            }
        }

        for (int i=1; i<m ;i++) {
            if (grid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i-1][0];
            }
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (grid[i][j]==1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
        }

        return dp[m-1][n-1];
    }

    private int solveMemo(int i, int j, int m, int n, int[][] grid, int[][] dp) {
        if (i >= m || j >= n) return 0;
        if (grid[i][j] == 1) return 0;
        if (i == m - 1 && j == n - 1) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        dp[i][j] = solveMemo(i + 1, j, m, n, grid, dp) + solveMemo(i, j + 1, m, n, grid, dp);
        return dp[i][j];
    }

    private int solveRecur(int i, int j, int m, int n, int[][] grid) {
        if (i >= m || j >= n) return 0;
        if (grid[i][j] == 1) return 0;
        if (i == m - 1 && j == n - 1) return 1;
        return solveRecur(i + 1, j, m, n, grid) + solveRecur(i, j + 1, m, n, grid);
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        UniquePathsII solution = new UniquePathsII();
        System.out.println(solution.uniquePathsWithObstacles(grid));
    }
}

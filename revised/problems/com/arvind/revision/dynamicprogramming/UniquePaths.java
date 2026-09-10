package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class UniquePaths {

    public int uniquePaths(int m, int n) {
        return uniquePathTab(m, n);
        /*int[][] dp = new int[m+1][n+1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return uniquePathMemo(1, 1, m, n, dp);*/
        //return uniquePathsRecur(1, 1, m, n);
    }

    private int uniquePathTab(int m, int n) {
        int[][] dp = new int[m][n];
        for (int j=0; j<n; j++) {
            dp[0][j] = 1;
        }
        for (int i=1; i<m; i++) {
            dp[i][0] = 1;
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    private int uniquePathMemo(int i, int j, int m, int n, int[][] dp) {
        if (i == m) return 1;
        if (i > m || j > n) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        dp[i][j] = uniquePathMemo(i+1, j, m, n, dp) + uniquePathMemo(i, j+1, m, n, dp);
        return dp[i][j];
    }

    private int uniquePathsRecur(int i, int j, int m, int n) {
        if (i == m) return 1;
        if (i > m || j > n) return 0;
        return uniquePathsRecur(i+1, j, m, n) + uniquePathsRecur(i, j+1, m, n);
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        UniquePaths solution = new UniquePaths();
        System.out.println(solution.uniquePaths(m, n));
    }
}

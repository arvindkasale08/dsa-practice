package com.arvind.revision.dynamicprogramming;

public class CherryPickUpII {

    private int[] DIR_Y = {-1, 0, 1};

    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer[][][] dp = new Integer[m][n][n];
        //return cherryRecur(0, 0, 0, n-1, m, n, grid);
        return cherryMemo(0, 0, 0, n-1, m, n, grid, dp);
    }

    private int cherryMemo(int i1, int j1, int i2, int j2, int m, int n, int[][] grid, Integer[][][] dp) {
        if (i1 >= m || i2 >= m || j1 >= n || j2 >= n) return -1_000_000;
        if (j1 < 0 || j2 < 0) return -1_000_000;
        if (dp[i1][j1][j2] != null) return dp[i1][j1][j2];
        // current cherries
        int cherries = 0;
        if (i1 == i2 && j1 == j2) {
            cherries += grid[i1][j1];
        } else {
            cherries += grid[i1][j1] + grid[i2][j2];
        }
        if (i1 == m-1) return cherries;
        int maxCherries = Integer.MIN_VALUE;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                maxCherries = Math.max(maxCherries, cherryMemo(i1 + 1, j1 + DIR_Y[i], i2 + 1, j2 + DIR_Y[j], m, n, grid, dp));
            }
        }
        dp[i1][j1][j2] = cherries + maxCherries;
        return dp[i1][j1][j2];
    }

    private int cherryRecur(int i1, int j1, int i2, int j2, int m, int n, int[][] grid) {
        if (i1 >= m || i2 >= m || j1 >= n || j2 >= n) return -1_000_000;
        if (j1 < 0 || j2 < 0) return -1_000_000;
        // current cherries
        int cherries = 0;
        if (i1 == i2 && j1 == j2) {
            cherries += grid[i1][j1];
        } else {
            cherries += grid[i1][j1] + grid[i2][j2];
        }
        if (i1 == m-1) return cherries;
        int maxCherries = Integer.MIN_VALUE;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                maxCherries = Math.max(maxCherries, cherryRecur(i1 + 1, j1 + DIR_Y[i], i2 + 1, j2 + DIR_Y[j], m, n, grid));
            }
        }
        return cherries + maxCherries;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 0, 0, 0, 0, 1},
                {2, 0, 0, 0, 0, 3, 0},
                {2, 0, 9, 0, 0, 0, 0},
                {0, 3, 0, 5, 4, 0, 0},
                {1, 0, 2, 3, 0, 0, 6}
        };
        CherryPickUpII solution = new CherryPickUpII();
        System.out.println(solution.cherryPickup(grid));
    }
}

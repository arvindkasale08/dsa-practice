package arvind;

import java.util.Arrays;

public class MaximumFallingPathSum {

    public int findMaxFallingPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        // make recursive calls...
        int maxValue = Integer.MIN_VALUE;
        for (int j=0; j< n; j++) {
            maxValue = Math.max(maxValue, findMaxFallingPath(grid, dp, 0, j));
            dp[0][j] = maxValue;
        }
        return maxValue;
    }

    private int findMaxFallingPath(int[][] grid, int[][] dp, int i, int j) {
        // base case
        if (i == grid.length - 1 && (j >= 0 && j < grid[0].length )) {
            return grid[i][j];
        }
        // out of bounds check
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return -10000000;
        }

        // memoization
        if (dp[i][j] != -1) return dp[i][j];

        int down = findMaxFallingPath(grid, dp, i+1, j) + grid[i][j];
        int downleft = findMaxFallingPath(grid, dp, i+1, j-1) + grid[i][j];
        int downright = findMaxFallingPath(grid, dp, i+1, j+1) + grid[i][j];

        return dp[i][j] = Math.max(Math.max(downleft, downright), down);
    }

    public int findMaxFallingPathTab(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        // add the base cases
        for (int j=0; j<grid[0].length; j++) {
            dp[m-1][j] = grid[m-1][j];
        }

        for (int i= m-2; i>=0; i--) {
            for (int j=0; j<n; j++) {
                int max = Integer.MIN_VALUE;
                for (int k=-1; k<=1; k++) {
                    if (j-k >= 0 && j-k < n) {
                        max = Math.max(max, dp[i+1][j-k] + grid[i][j]);
                    }
                }
                dp[i][j] = max;
            }
        }

        // find max in first row
        int finalMax = Integer.MIN_VALUE;
        for (int j=0; j<n; j++) {
            finalMax = Math.max(finalMax, dp[0][j]);
        }
        return finalMax;
    }

    public static void main(String[] args) {
        MaximumFallingPathSum solution = new MaximumFallingPathSum();
        int[][] grid = new int[][] {
                {10, 2, 3},
                {3, 7, 2},
                {8, 1, 5}
        };
        int result = solution.findMaxFallingPath(grid);
        int result2 = solution.findMaxFallingPathTab(grid);
        System.out.println(result);
        System.out.println(result2);
    }
}

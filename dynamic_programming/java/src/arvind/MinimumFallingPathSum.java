package arvind;

import java.util.Arrays;

public class MinimumFallingPathSum {

    public int findMinFallingPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        // make recursive calls...
        int min = Integer.MAX_VALUE;
        for (int j=0; j< n; j++) {
            min = Math.min(min, findMinFallingPath(grid, dp, 0, j));
            dp[0][j] = min;
        }
        return min;
    }

    private int findMinFallingPath(int[][] grid, int[][] dp, int i, int j) {
        // base case
        if (i == grid.length - 1 && (j >= 0 && j < grid[0].length )) {
            return grid[i][j];
        }
        // out of bounds check
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 10000000;
        }

        // memoization
        if (dp[i][j] != -1) return dp[i][j];

        int down = findMinFallingPath(grid, dp, i+1, j) + grid[i][j];
        int downleft = findMinFallingPath(grid, dp, i+1, j-1) + grid[i][j];
        int downright = findMinFallingPath(grid, dp, i+1, j+1) + grid[i][j];

        return dp[i][j] = Math.min(Math.min(downleft, downright), down);
    }

    public static void main(String[] args) {
        MinimumFallingPathSum solution = new MinimumFallingPathSum();
        int[][] grid = new int[][] {
                {-19, 57},
                {-40, -5}
        };
        int result = solution.findMinFallingPath(grid);
        System.out.println(result);
    }
}

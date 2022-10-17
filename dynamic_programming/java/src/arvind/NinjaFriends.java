package arvind;

import java.util.Arrays;

public class NinjaFriends {

    public int maxChocolates(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for (int[][] arr2 : dp) {
            for (int[] arr : arr2) {
                Arrays.fill(arr, -1);
            }
        }

        // maxchocolates(grid, i, j1, j2)
        return maxChocolates(grid, 0, 0, n-1, m, n, dp);
    }

    private int maxChocolates(int[][] grid, int i, int j1, int j2, int m, int n, int[][][] dp) {
        if (j1 < 0 || j1 >= n || j2 < 0 || j2 >= n) {
            return -10000000;
        }

        if (i == m-1) {
            // last row
            if (j1 == j2) return grid[i][j1]; // if both j1 and j2 are on same consider it once
            return grid[i][j1] + grid[i][j2]; // else sum both up.
        }

        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        // explore all paths;
        int[] DIR_J = {-1, 0, 1};
        int max = Integer.MIN_VALUE;
        for (int k=0; k<3; k++) {
            for (int l=0; l<3; l++) {
                int newJ1 = j1 + DIR_J[k];
                int newJ2 = j2 + DIR_J[l];
                if (j1 == j2) {
                    max = Math.max(max, maxChocolates(grid, i+1, newJ1, newJ2, m, n, dp) + grid[i][j1]);
                } else {
                    max = Math.max(max, maxChocolates(grid, i+1, newJ1, newJ2, m, n, dp) + grid[i][j1] + grid[i][j2]);
                }
            }
        }
        return dp[i][j1][j2] = max;
    }

    public static void main(String[] args) {
        NinjaFriends solution = new NinjaFriends();
        int[][] grid = new int[][] {
                {2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}
        };
        int result = solution.maxChocolates(grid);
        System.out.println(result);
    }
}

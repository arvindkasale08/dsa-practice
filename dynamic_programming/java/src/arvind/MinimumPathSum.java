package arvind;

import java.util.Arrays;

public class MinimumPathSum {

    public int minPath(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        int dp[][] = new int[m][n];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return minPath(maze, m-1, n-1, dp);
    }

    private int minPath(int[][] maze, int i, int j, int[][] dp) {
        if (i == 0 && j ==0) return maze[i][j];
        if (i < 0 || j < 0) return 10000000;
        if (dp[i][j] != -1) return dp[i][j];

        int left = minPath(maze, i, j-1, dp) + maze[i][j];
        int up = minPath(maze, i-1, j, dp) + maze[i][j];

        return dp[i][j] = Math.min(left, up);
    }

    public int minPathTab(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        int dp[][] = new int[m][n];

        // add the base cases
        dp[0][0] = maze[0][0];
        // populate the first row
        for (int i=1; i<n; i++) {
            dp[0][i] = dp[0][i-1] + maze[0][i];
        }

        // populate the first column
        for (int i=1; i<m; i++) {
            dp[i][0] = dp[i-1][0] + maze[i][0];
        }

        for (int i=1; i< m; i++) {
            for (int j=1; j<n; j++) {
                int left = dp[i][j-1] + maze[i][j];
                int up = dp[i-1][j] + maze[i][j];

                dp[i][j] = Math.min(left, up);
            }
        }

        return dp[dp.length-1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum solution = new MinimumPathSum();
        int[][] maze = new int[][] {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int minSum = solution.minPath(maze);
        int minSum2 = solution.minPathTab(maze);
        System.out.println(minSum);
        System.out.println(minSum2);
    }
}

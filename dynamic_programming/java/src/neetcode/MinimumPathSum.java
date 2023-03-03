package neetcode;

import java.util.Arrays;

public class MinimumPathSum {

    public int minPathSumDP(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dp = new int[m+1][n+1];


        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                if (j == n-1) {
                    dp[i][j] = maze[i][j] + dp[i+1][j];
                    continue;
                }
                if (i == m-1) {
                    dp[i][j] = maze[i][j] + dp[i][j+1];
                    continue;
                }
                int down = maze[i][j] + dp[i+1][j];
                int right = maze[i][j] + dp[i][j+1];
                dp[i][j] = Math.min(down, right);
            }
        }
        return dp[0][0];
    }

    public int minPathSumMemo(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] memo = new int[m][n];
        for (int[] me : memo) {
            Arrays.fill(me, -1);
        }
        return minPathSumMemo(m-1, n-1, m, n, maze, memo);
    }

    private int minPathSumMemo(int i, int j, int m, int n, int[][] maze, int[][] memo) {
        if (i == 0 && j == 0) {
            return maze[i][j];
        }
        if (i < 0 || j < 0) {
            return 10000000;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int up = maze[i][j] + minPathSumMemo(i-1, j, m, n, maze, memo);
        int left = maze[i][j] + minPathSumMemo(i, j-1, m, n, maze, memo);
        return memo[i][j] = Math.min(up, left);
    }

    public static void main(String[] args) {
        MinimumPathSum solution = new MinimumPathSum();
        int[][] maze = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
        int res = solution.minPathSumMemo(maze);
        int res2 = solution.minPathSumDP(maze);
        System.out.println(res);
        System.out.println(res2);
    }
}

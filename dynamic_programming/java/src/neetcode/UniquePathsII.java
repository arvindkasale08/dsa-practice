package neetcode;

import java.util.Arrays;

public class UniquePathsII {

    public int uniquePathsWithObstaclesDP(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = maze[0][0] == 1 ? 0 : 1;
        // populate the first row
        for (int j=1; j<n; j++) {
            dp[0][j] = maze[0][j] == 1 || dp[0][j-1] == 0 ? 0 : 1;
        }
        // populate the first column
        for (int i=1; i<m; i++) {
            dp[i][0] = maze[i][0] == 1 || dp[i-1][0] == 0 ? 0 : 1;
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (maze[i][j] == 1) {
                    // blocked
                    dp[i][j] = 0;
                    continue;
                }

                int left = dp[i][j-1];
                int up = dp[i-1][j];
                dp[i][j] = left + up;
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePathsWithObstaclesMemo(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] memo = new int[m][n];
        if (maze[0][0] == 1) {
            return 0;
        }
        for (int[] me : memo) {
            Arrays.fill(me, -1);
        }
        return uniquePathsWithObstaclesMemo(m-1, n-1, maze, memo);
    }

    private int uniquePathsWithObstaclesMemo(int i, int j, int[][] maze, int[][] memo) {
        if (i== 0 && j== 0) {
            return 1;
        }
        if (i < 0 || j < 0) {
            return 0;
        }
        if (maze[i][j] == 1) {
            // blocked
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int left = uniquePathsWithObstaclesMemo(i, j-1, maze, memo);
        int up = uniquePathsWithObstaclesMemo(i-1, j, maze, memo);
        return memo[i][j] = left + up;
    }

    public static void main(String[] args) {
        UniquePathsII solution = new UniquePathsII();
        int[][] obstacleGrid = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        int res = solution.uniquePathsWithObstaclesMemo(obstacleGrid);
        int res2 = solution.uniquePathsWithObstaclesDP(obstacleGrid);
        System.out.println(res);
        System.out.println(res2);
    }
}

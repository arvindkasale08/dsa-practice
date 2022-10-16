package arvind;

import java.util.Arrays;

public class ObstacleMaze {

    private int countWays(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dp = new int[m][n];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return countWays(maze, m-1, n-1, dp);
    }

    private int countWays(int[][] maze, int i, int j, int[][] dp) {
        if (i ==0 && j ==0 && maze[i][j] == 0) return 1;
        if (i < 0 || j < 0) return 0;
        if (maze[i][j] == -1) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int up = countWays(maze, i-1, j, dp);
        int left = countWays(maze, i, j-1, dp);
        return dp[i][j] = up + left;
    }

    private int countWaysTabulation(int[][] maze) {
        int m = maze.length;
        int n = maze[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = maze[0][0] == -1 ? 0 : 1; // base case
        // populate first row
        for (int i=1; i<n; i++) {
            dp[0][i] = maze[0][i] == -1 || dp[0][i-1] == 0 ? 0 : 1;
        }
        // populate first column
        for (int i=1; i<m; i++) {
            dp[i][0] = maze[i][0] == -1 || dp[i-1][0] == 0 ? 0 : 1;
        }

        for (int i = 1; i<m; i++) {
            for (int j = 1; j<n; j++) {
                if (maze[i][j] == 0) {
                    int up = dp[i - 1][j];
                    int left = dp[i][j - 1];
                    dp[i][j] = up + left;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        ObstacleMaze solution = new ObstacleMaze();
        int[][] maze = new int[][] {
                {0, 1},
                {0, 0}
        };
        int result = solution.countWays(maze);
        int result2 = solution.countWaysTabulation(maze);
        System.out.println(result);
        System.out.println(result2);
    }
}

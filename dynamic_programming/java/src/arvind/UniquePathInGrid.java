package arvind;

import java.util.Arrays;

public class UniquePathInGrid {

    public int countWays(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] arr: dp) {
            Arrays.fill(arr, -1);
        }
        return countWays(m-1, n-1, dp);
    }

    private int countWays(int i, int j, int[][] dp) {
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        int left = countWays(i, j - 1, dp);
        int up = countWays(i-1, j, dp);
        return dp[i][j] = left + up;
    }

    private int tabCountWays(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i<m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j<n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i<m; i++) {
            for (int j = 1; j<n; j++) {
                int left = dp[i][j - 1];
                int up = dp[i-1][j];
                dp[i][j] = left + up;
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        UniquePathInGrid solution = new UniquePathInGrid();
        int m = 3, n = 7;
        int result = solution.countWays(3, 7);
        int result2 = solution.tabCountWays(3, 7);
        System.out.println(result);
        System.out.println(result2);
    }
}

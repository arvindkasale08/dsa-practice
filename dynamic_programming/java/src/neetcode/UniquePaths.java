package neetcode;

import java.util.Arrays;

public class UniquePaths {

    public int uniquePathsDP(int m, int n) {
        int[][] dp = new int[m][n];
        // initialize first row to 1 way
        Arrays.fill(dp[0], 1);
        // initialize first column to 1 way
        for (int i=0; i<m; i++) {
            dp[i][0] = 1;
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                int left = dp[i][j-1];
                int right = dp[i-1][j];
                dp[i][j] = left + right;
            }
        }
        return dp[m-1][n-1];
    }

    public int uniquePathsMemo(int m, int n) {
        int[][] memo = new int[m][n];
        for (int[] me : memo) {
            Arrays.fill(me, -1);
        }
        return uniquePathsInnerMemo(m-1, n-1, memo);
    }

    private int uniquePathsInnerMemo(int i, int j, int[][] memo) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (i< 0 || j < 0) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int left = uniquePathsInnerMemo(i, j-1, memo);
        int right = uniquePathsInnerMemo(i-1, j, memo);
        return memo[i][j] = left + right;
    }

    public static void main(String[] args) {
        UniquePaths solution = new UniquePaths();
        int m = 3;
        int n = 7;
        int res = solution.uniquePathsMemo(m, n);
        int res2 = solution.uniquePathsDP(m, n);
        System.out.println(res);
        System.out.println(res2);
    }
}

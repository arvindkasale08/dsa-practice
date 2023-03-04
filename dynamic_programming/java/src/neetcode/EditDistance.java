package neetcode;

import java.util.Arrays;

public class EditDistance {

    public int minDistanceDP(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }


        // base cases
        for (int i=0; i<=m; i++) {
            dp[i][0] = i;
        }
        for (int i=0; i<=n; i++) {
            dp[0][i] = i;
        }


        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                }
            }
        }

        return dp[m][n];

    }

    public int minDistanceMemo(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] memo = new int[m][n];
        for (int[] me : memo) {
            Arrays.fill(me, -1);
        }
        return minDistanceMemo(0, 0, m, n, word1, word2, memo);
    }

    private int minDistanceMemo(int i, int j, int m, int n, String word1, String word2, int[][] memo) {
        if (i >= m) {
            return n - j;
        }
        if (j >= n) {
            return m - i;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return memo[i][j] = 0 + minDistanceMemo(i+1, j+1, m, n, word1, word2, memo);
        } else {
            // 3 options insert, delete, replace
            int insert = minDistanceMemo(i, j+1, m, n, word1, word2, memo);
            int delete = minDistanceMemo(i+1, j, m, n, word1, word2, memo);
            int replace = minDistanceMemo(i+1, j+1, m, n, word1, word2, memo);
            return memo[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
        }
    }

    public static void main(String[] args) {
        EditDistance solution = new EditDistance();
        String word1 = "a";
        String word2 = "b";
        int res = solution.minDistanceMemo(word1, word2);
        int res2 = solution.minDistanceDP(word1, word2);
        System.out.println(res);
        System.out.println(res2);
    }
}

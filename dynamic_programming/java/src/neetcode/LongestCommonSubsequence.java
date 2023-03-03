package neetcode;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public int longestCommonSubsequenceDP(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = 0 + Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public int longestCommonSubsequenceMemo(String text1, String text2) {
        int[][] memo = new int[text1.length()][text2.length()];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return longestCommonSubsequenceMemo(0, 0, text1, text2, memo);
    }

    private int longestCommonSubsequenceMemo(int i, int j, String text1, String text2, int[][] memo) {
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return memo[i][j] = 1 + longestCommonSubsequenceMemo(i+1, j+1, text1, text2, memo);
        } else {
            return memo[i][j] = 0 + Math.max(longestCommonSubsequenceMemo(i+1, j, text1, text2, memo), longestCommonSubsequenceMemo(i, j+1, text1, text2, memo));
        }
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String text1 = "abcde";
        String text2 = "ace";
        int res = lcs.longestCommonSubsequenceMemo(text1, text2);
        int res2 = lcs.longestCommonSubsequenceDP(text1, text2);
        System.out.println(res);
        System.out.println(res2);
    }
}

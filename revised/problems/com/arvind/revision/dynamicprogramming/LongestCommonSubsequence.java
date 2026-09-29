package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return longestCommonSubsequenceMemo(0, 0, text1, text2, dp);
        // return longestCommonSubsequenceRecur(0, 0, text1, text2);
    }

    private int longestCommonSubsequenceMemo(int i, int j, String text1, String text2, int[][] dp) {
        if (i >= text1.length() || j >= text2.length()) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int c1 = text1.charAt(i);
        int c2 = text2.charAt(j);
        if (c1 == c2) {
            dp[i][j] = 1 + longestCommonSubsequenceMemo(i+1, j+1, text1, text2, dp);
            return dp[i][j];
        }
        dp[i][j] = Math.max(longestCommonSubsequenceMemo(i, j+1, text1, text2, dp), longestCommonSubsequenceMemo(i+1, j, text1, text2, dp));
        return dp[i][j];
    }

    private int longestCommonSubsequenceRecur(int i, int j, String text1, String text2) {
        if (i >= text1.length() || j >= text2.length()) return 0;
        int c1 = text1.charAt(i);
        int c2 = text2.charAt(j);
        if (c1 == c2) {
            return 1 + longestCommonSubsequenceRecur(i+1, j+1, text1, text2);
        }
        return Math.max(longestCommonSubsequenceRecur(i, j+1, text1, text2), longestCommonSubsequenceRecur(i+1, j, text1, text2));
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "xyz";
        LongestCommonSubsequence solution = new LongestCommonSubsequence();
        System.out.println(solution.longestCommonSubsequence(text1, text2));
    }
}

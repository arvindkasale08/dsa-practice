package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class DeleteOperationForTwoStrings {

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return minDistanceMemo(0, 0, word1, word2, dp);
    }

    private int minDistanceMemo(int i, int j, String s1, String s2, int[][] dp) {
        if (i > s1.length() && j > s2.length()) return 0;
        if (i >= s1.length()) return s2.length() - j;
        if (j >= s2.length()) return s1.length() - i;
        if (dp[i][j] != - 1) return dp[i][j];

        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);
        if (c1 == c2) {
            dp[i][j] = minDistanceMemo(i+1, j+1, s1, s2, dp);
            return dp[i][j];
        } else {
            dp[i][j] = 1 + Math.min(minDistanceMemo(i+1, j, s1, s2, dp), minDistanceMemo(i, j+1, s1, s2, dp));
            return dp[i][j];
        }
    }

    private int minDistanceRecur(int i, int j, String s1, String s2) {
        if (i > s1.length() && j > s2.length()) return 0;
        if (i >= s1.length()) return s2.length() - j;
        if (j >= s2.length()) return s1.length() - i;

        char c1 = s1.charAt(i);
        char c2 = s2.charAt(j);
        if (c1 == c2) {
            return minDistanceRecur(i+1, j+1, s1, s2);
        } else {
            return 1 + Math.min(minDistanceRecur(i+1, j, s1, s2), minDistanceRecur(i, j+1, s1, s2));
        }
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        String s2 = "etco";
        DeleteOperationForTwoStrings solution = new DeleteOperationForTwoStrings();
        System.out.println(solution.minDistance(s1, s2));
    }
}

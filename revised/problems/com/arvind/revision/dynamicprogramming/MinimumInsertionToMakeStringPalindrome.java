package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class MinimumInsertionToMakeStringPalindrome {

    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return minInsertionsMemo(0, n-1, s, dp);
    }

    private int minInsertionsMemo(int start, int end, String s, int[][] dp) {
        if (start >= end) return 0;
        if (start >= s.length() || end >= s.length()) return 0;
        if (dp[start][end] != -1) return dp[start][end];

        if (s.charAt(start) == s.charAt(end)) {
            dp[start][end] = minInsertionsMemo(start+1 , end-1, s, dp);
            return dp[start][end];
        } else {
            dp[start][end] = 1 + Math.min(minInsertionsMemo(start + 1, end, s, dp), minInsertionsMemo(start, end - 1, s, dp));
            return dp[start][end];
        }
    }

    private int minInsertionsRecur(int start, int end, String s) {
        if (start >= end) return 0;
        if (start >= s.length() || end >= s.length()) return 0;

        if (s.charAt(start) == s.charAt(end)) {
            return minInsertionsRecur(start+1 , end-1, s);
        } else {
            return 1 + Math.min(minInsertionsRecur(start + 1, end, s), minInsertionsRecur(start, end - 1, s));
        }
    }

    public static void main(String[] args) {
        String s = "mbadm";
        MinimumInsertionToMakeStringPalindrome solution = new MinimumInsertionToMakeStringPalindrome();
        System.out.println(solution.minInsertions(s));
    }
}

package com.arvind.revision.dynamicprogramming;

public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        Integer[][] dp = new Integer[s.length()+1][s.length()+1];
        return longestPalindromeSubseqMemo(0, 0, s, s2, dp);
        //return longestPalindromeSubseqRecur(0, 0, s, s2);
    }

    private int longestPalindromeSubseqMemo(int i, int j, String s1, String s2, Integer[][] dp) {
        if (i >= s1.length() || j >= s2.length()) return 0;
        if (dp[i][j] != null) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + longestPalindromeSubseqMemo(i+1, j+1, s1, s2, dp);
            return dp[i][j];
        } else {
            dp[i][j] = Math.max(longestPalindromeSubseqMemo(i+1, j, s1, s2, dp), longestPalindromeSubseqMemo(i, j+1, s1, s2, dp));
            return dp[i][j];
        }
    }

    private int longestPalindromeSubseqRecur(int i, int j, String s1, String s2) {
        if (i >= s1.length() || j >= s2.length()) return 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + longestPalindromeSubseqRecur(i+1, j+1, s1, s2);
        } else {
            return Math.max(longestPalindromeSubseqRecur(i+1, j, s1, s2), longestPalindromeSubseqRecur(i, j+1, s1, s2));
        }
    }

    public static void main(String[] args) {
        String s = "cbbbabc";
        LongestPalindromicSubsequence solution = new LongestPalindromicSubsequence();
        System.out.println(solution.longestPalindromeSubseq(s));
    }
}

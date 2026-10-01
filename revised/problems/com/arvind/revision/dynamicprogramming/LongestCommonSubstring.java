package com.arvind.revision.dynamicprogramming;

public class LongestCommonSubstring {

    public int longestCommonSubstr(String str1, String str2) {
        int max = 0;
        int m = str1.length();
        int n = str2.length();
        Integer[][] dp = new Integer[m+1][n+1];
        for (int i=0; i< m; i++) {
            for (int j=0; j < n; j++) {
                max = Math.max(max, longestCommonSubstrMemo(i, j, str1, str2, dp));
            }
        }
        return max;
    }

    private int longestCommonSubstrMemo(int i, int j, String s1, String s2, Integer[][] dp) {
        if (i >= s1.length() || j >= s2.length()) return 0;
        if (dp[i][j] != null) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = 1 + longestCommonSubstrMemo(i+1, j+1, s1, s2, dp);
            return dp[i][j];
        } else {
            dp[i][j] = 0;
            return 0;
        }
    }

    private int longestCommonSubstrRecur(int i, int j, String s1, String s2) {
        if (i >= s1.length() || j >= s2.length()) return 0;

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + longestCommonSubstrRecur(i+1, j+1, s1, s2);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abfce";
        LongestCommonSubstring solution = new LongestCommonSubstring();
        System.out.println(solution.longestCommonSubstr(s1, s2));
    }
}

package com.arvind.revision.dynamicprogramming;

public class CountPalindromicSubstring {


    public int countSubstrings(String s) {
        int m = s.length();
        Boolean[][] dp = new Boolean[m][m];

        // initialize the normal diagonal
        for (int i=0; i<m; i++) {
            dp[i][i] = true;
        }
        int count = 0;
        for (int start=m-1; start>=0; start--) {
            for (int end=m-1; end>=start; end--) {
                if (dp[start][end] == null) {
                    dp[start][end] = s.charAt(start) == s.charAt(end) && (start + 1 == end || dp[start + 1][end - 1]);
                }
                if (dp[start][end]) {
                    count++;
                }
            }
        }
        return count;
    }



    public static void main(String[] args) {
        String s = "abdbca";
        CountPalindromicSubstring solution = new CountPalindromicSubstring();
        System.out.println(solution.countSubstrings(s));
    }
}

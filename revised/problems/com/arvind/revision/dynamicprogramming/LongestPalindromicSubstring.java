package com.arvind.revision.dynamicprogramming;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int m = s.length();
        Boolean[][] dp = new Boolean[m][m];

        // initialize the normal diagonal
        for (int i=0; i<m; i++) {
            dp[i][i] = true;
        }
        String res = "";
        int size = 0;
        for (int start=m-1; start>=0; start--) {
            for (int end=m-1; end>=start; end--) {
                if (dp[start][end] == null) {
                    dp[start][end] = s.charAt(start) == s.charAt(end) && (start + 1 == end || dp[start + 1][end - 1]);
                }
                if (dp[start][end]) {
                    int length = end - start + 1;
                    if (length > size) {
                        size = length;
                        res = s.substring(start, end+1);
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "cd";
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
        System.out.println(solution.longestPalindrome(s));
    }
}

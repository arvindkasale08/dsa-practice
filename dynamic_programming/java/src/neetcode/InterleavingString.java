package neetcode;

import java.util.Arrays;

public class InterleavingString {

    public boolean isInterleave(String s1, String s2, String s3) {
        int a = s1.length();
        int b = s2.length();
        int c = s3.length();
        if (c != a + b) {
            return false; // string s3 should contain all chars from s1 and s2
        }

        Boolean[][] memo = new Boolean[a][b];

        if (isInterleave(0, 0, 0, a, b, c, s1, s2, s3, memo))
            return true;

        return false;
    }

    private boolean isInterleave(int i, int j, int k, int a, int b, int c, String s1, String s2, String s3, Boolean[][] memo) {
        if (i+j >= c) {
            return true;
        }
        if (i >= a) {
            return s2.substring(j, s2.length()).equals(s3.substring(k, s3.length()));
        }
        if (j >= b) {
            return s1.substring(i, s1.length()).equals(s3.substring(k, s3.length()));
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j) && s1.charAt(i) == s3.charAt(k)) {
            // both are valid options so move both
            boolean move1 = isInterleave(i+1, j, k+1, a, b, c, s1, s2, s3, memo);
            boolean move2 = isInterleave(i, j+1, k+1, a, b, c, s1, s2, s3, memo);
            return memo[i][j] = move1 || move2;
        } else if (s1.charAt(i) == s3.charAt(k)) {
            // s1 is valid so move s1
            if (isInterleave(i+1, j, k+1, a, b, c, s1, s2, s3, memo)) {
                if (i+1 < a) {
                    memo[i + 1][j] = true;
                }
                return true;
            }
        } else if (s2.charAt(j) == s3.charAt(k)){
            // s2 is valid so move s2
            if (isInterleave(i, j+1, k+1, a, b, c, s1, s2, s3, memo)) {
                if (j+1 < b) {
                    memo[i][j+1] = true;
                }
                return true;
            }
        } else {
            return memo[i][j]= false;
        }
        return memo[i][j] = false;
    }

    public static void main(String[] args) {
        InterleavingString solution = new InterleavingString();
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        boolean res = solution.isInterleave(s1, s2, s3);
        System.out.println(res);
    }
}

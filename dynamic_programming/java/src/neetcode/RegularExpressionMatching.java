package neetcode;

import java.util.Arrays;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        Boolean[][] memo = new Boolean[m][n];

        if (isMatch(0, 0, m, n, s, p, memo)) return true;
        return false;
    }

    private boolean isMatch(int i, int j, int m, int n, String s, String p, Boolean[][] memo) {
        if (i >= m && j >= n) {
            return true; // valid string matches the pattern
        }
        if (j >= n) {
            return false; // pattern exhausted;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean isMatching = i < m && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if (j+1 < n && p.charAt(j+1) == '*') {
            boolean ignoreStar = isMatch(i, j+2, m, n, s, p, memo);
            boolean useStar = isMatching && isMatch(i+1, j, m, n, s, p, memo);
            return memo[i][j] = useStar || ignoreStar;
        } else {
            return memo[i][j] = isMatching && isMatch(i+1, j+1, m, n, s, p, memo);
        }
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        RegularExpressionMatching solution = new RegularExpressionMatching();
        boolean res = solution.isMatch(s, p);
        System.out.println(res);
    }
}

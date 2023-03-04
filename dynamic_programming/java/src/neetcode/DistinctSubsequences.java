package neetcode;

import java.util.Arrays;

public class DistinctSubsequences {

    public int numDistinctMemo(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] memo = new int[m][n];
        for (int[] me : memo) {
            Arrays.fill(me, -1);
        }
        return numDistinctMemo(m-1, n-1, s, t, memo);
    }

    private int numDistinctMemo(int i, int j, String s, String t, int[][] memo) {
        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            int take = numDistinctMemo(i-1, j-1, s, t, memo);
            int dontTake = numDistinctMemo(i-1, j, s, t, memo);
            return memo[i][j] = take + dontTake;
        } else {
            return memo[i][j] = numDistinctMemo(i-1, j, s, t, memo);
        }
    }

    public static void main(String[] args) {
        DistinctSubsequences solution = new DistinctSubsequences();
        String s = "rabbbit";
        String t = "rabbit";
        int res = solution.numDistinctMemo(s, t);
        System.out.println(res);
    }
}

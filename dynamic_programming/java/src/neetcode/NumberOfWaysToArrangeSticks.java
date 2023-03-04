package neetcode;

import java.util.Arrays;

public class NumberOfWaysToArrangeSticks {

    public int rearrangeSticks(int n, int k) {
        int[][] memo = new int[n+1][k+1];
        for (int[] me : memo) {
            Arrays.fill(me, -1);
        }
        return rearrangeSticks(n, k, memo);
    }

    private int rearrangeSticks(int n, int k, int[][] memo) {
        if (n == k) {
            return 1;
        }
        if (n == 0 || k == 0) {
            return 0;
        }
        if (memo[n][k] != -1) {
            return memo[n][k];
        }

        return memo[n][k] = rearrangeSticks(n-1, k-1, memo) + (n-1) * (rearrangeSticks(n-1, k , memo));
    }

    public static void main(String[] args) {
        NumberOfWaysToArrangeSticks solution = new NumberOfWaysToArrangeSticks();
        int n = 3;
        int k = 2;
        int res = solution.rearrangeSticks(n, k);
        System.out.println(res);
    }
}

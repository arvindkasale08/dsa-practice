package neetcode;

import java.util.Arrays;

public class PerfectSquares {

    public int numSquaresDP(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;

        for (int t=1; t<=n; t++) {
            int cost = Integer.MAX_VALUE;
            for (int i=1; i<=t; i++) {
                int square = i*i;
                if (square > t) {
                    break;
                }
                cost = Math.min(cost, 1 + dp[t - square]);
            }
            dp[t] = cost;
        }
        return dp[n];
    }

    public int numSquaresMemo(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return numSquaresInner(n, memo);
    }

    private int numSquaresInner(int target, int[] memo) {

        if (target == 0) {
            return 0;
        }
        if (target < 0) {
            return 1000000;
        }
        if (memo[target] != -1) {
            return memo[target];
        }

        int cost = Integer.MAX_VALUE;
        for (int i=1; i<=target; i++) {
            int square = i*i;
            if (square > target) {
                break;
            }
            cost = Math.min(cost, 1 + numSquaresInner(target - square, memo));
        }
        return memo[target] = cost;
    }

    public static void main(String[] args) {
        int n = 5;
        PerfectSquares solution = new PerfectSquares();
        int res = solution.numSquaresMemo(n);
        int res2 = solution.numSquaresDP(n);
        System.out.println(res);
        System.out.println(res2);
    }
}

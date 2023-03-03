package neetcode;

import java.util.Arrays;

public class CoinChangeII {

    public int changeDP(int sum, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][sum + 1];

        // preinitiatize
        for (int i=0; i< dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i=0; i< dp.length; i++) {
            dp[i][0] = 1; // set first row as 0;
        }

        for (int i=1; i<dp.length; i++) {
            for (int j= 1; j<dp[0].length; j++) {
                int stayAtsame = 0;
                if (j >= coins[i-1]) {
                    stayAtsame = dp[i][j - coins[i-1]];
                }
                int moveAhead = dp[i-1][j];
                dp[i][j] = stayAtsame + moveAhead;
            }
        }

        return dp[dp.length -1][dp[0].length - 1];
    }

    public int changeMemo(int sum, int[] coins) {
        int n = coins.length;
        int[][] memo = new int[n+1][sum+1];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return changeMemo(0, n, sum, coins, memo);
    }

    private int changeMemo(int idx, int n, int target, int[] coins, int[][] memo) {
        if (target == 0) {
            return 1;
        }
        if (idx >= n) {
            return 0;
        }
        if (target < 0) {
            return 0;
        }
        if (memo[idx][target] != -1) {
            return memo[idx][target];
        }

        int stayAtsame = 0;
        if (target >= coins[idx]) {
            stayAtsame = changeMemo(idx, n, target - coins[idx], coins, memo);
        }
        int moveAhead = changeMemo(idx+1, n, target, coins, memo);

        return memo[idx][target] = stayAtsame + moveAhead;
    }

    public static void main(String[] args) {
        int sum = 5;
        int[] coins = {1, 2, 5};
        CoinChangeII solution = new CoinChangeII();
        int res = solution.changeMemo(sum, coins);
        int res2 = solution.changeDP(sum, coins);
        System.out.println(res);
    }
}

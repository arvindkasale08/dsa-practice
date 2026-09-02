package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class NumberFactors {

    public int countWays(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        //return countWayMemo(n, dp);
        return countWayTab(n);
    }

    private int countWayTab(int n) {
        if (n <= 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;

        for (int i=5; i<= n; i++) {
            dp[i] = dp[i-1] + dp[i-3] + dp[i-4];
        }
        return dp[n];
    }

    private int countWayMemo(int rem, int[] dp) {
        if (rem < 0) return 0;
        if (rem == 0) return 1;
        if (dp[rem] != -1) return dp[rem];
        int noOfWays = countWayMemo(rem - 1, dp) + countWayMemo(rem - 3, dp) + countWayMemo( rem - 4, dp);
        dp[rem] = noOfWays;
        return dp[rem];
    }

    private int countWaysRecur(int rem) {
        if (rem < 0) return 0;
        if (rem == 0) return 1;

        return countWaysRecur(rem - 1) + countWaysRecur(rem - 3) + countWaysRecur( rem - 4);
    }

    public static void main(String[] args) {
        int n = 5;
        NumberFactors solution = new NumberFactors();
        System.out.println(solution.countWays(n));
    }
}

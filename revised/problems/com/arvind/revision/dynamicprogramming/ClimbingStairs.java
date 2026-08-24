package com.arvind.revision.dynamicprogramming;

import java.util.Arrays;

public class ClimbingStairs {

    public int climbStairs(int n) {
        //int[] dp = new int[n+1];
        //Arrays.fill(dp, -1);
        return climbStairsTab(n);
    }

    private int climbStairsTab(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i=4; i<n+1; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[dp.length-1];
    }

    private int climbStairsMemo(int i, int n, int[] dp) {
        if (i > n) return 0;
        if (i == n) return 1;
        if (dp[i] != -1) return dp[i];

        dp[i] = climbStairsMemo(i+1, n, dp) + climbStairsMemo(i+2, n, dp) + climbStairsMemo(i+3, n, dp);
        return dp[i];
    }

    private int climbStairsRecur(int i, int n) {
        if (i > n) return 0;
        if (i == n) return 1;

        return climbStairsRecur(i+1, n) + climbStairsRecur(i+2, n) + climbStairsRecur(i+3, n);
    }

    public static void main(String[] args) {
        int n = 49;
        ClimbingStairs solution = new ClimbingStairs();
        System.out.println(solution.climbStairs(n));
    }
}

package leetcode;

import java.util.Arrays;

public class ClimbingStairs {

    public int climbStairsMemo(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return climbStairsMemo(n, memo);
    }

    public int climbStairsDP(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        if (n < 2) {
            return dp[n];
        }
        dp[2] = 2;

        for (int i=3; i<= n; i++) {
            dp[i]= dp[i - 1] + dp[i -2];
        }
        return dp[n];
    }

    private int climbStairsMemo(int idx, int[] memo) {
        if (idx <= 0) {
            return 0;
        }
        if (idx == 1) {
            return 1;
        }
        if (idx == 2) {
            return 2;
        }
        if (memo[idx] != -1) {
            return memo[idx];
        }
        return memo[idx]= climbStairsMemo(idx - 1, memo) + climbStairsMemo(idx -2, memo);
    }



    public static void main(String[] args) {
        ClimbingStairs solution = new ClimbingStairs();
        int n = 3;
        //int res = solution.climbStairsMemo(n);
        int res = solution.climbStairsDP(n);
        System.out.println(res);
    }
}

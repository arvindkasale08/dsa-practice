package neetcode;

import java.util.Arrays;

public class MinCostClimbingStairs {

    public int minCostClimbingStairsDP(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i=2; i<n; i++) {
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }

    public int minCostClimbingStairsMemo(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return Math.min(minCostClimbingStairsMemo(0, n, cost, memo), minCostClimbingStairsMemo(1, n, cost, memo));
    }

    private int minCostClimbingStairsMemo(int idx, int n, int[] cost, int[] memo) {
        if (idx >= n) {
            return 0;
        }

        if (memo[idx] != -1) {
            return memo[idx];
        }

        return memo[idx] = cost[idx] + Math.min(minCostClimbingStairsMemo(idx+1, n, cost, memo), minCostClimbingStairsMemo(idx+2, n, cost, memo));
    }

    public static void main(String[] args) {
        int[] cost = new int[] {1,100,1,1,1,100,1,1,100,1};
        MinCostClimbingStairs solution = new MinCostClimbingStairs();
        int res = solution.minCostClimbingStairsDP(cost);
        System.out.println(res);
    }
}

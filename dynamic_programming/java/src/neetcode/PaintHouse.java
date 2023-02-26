package neetcode;

import java.util.Arrays;

public class PaintHouse {

    public int minCostDP(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];

        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for (int i=1; i<n; i++) {
            for (int j=0; j<3; j++) {
                int minCost = Integer.MAX_VALUE;
                for (int k=0; k<3; k++) {
                    if (k != j) {
                        minCost = Math.min(minCost, costs[i][j] + dp[i-1][k]);
                    }
                }
                dp[i][j] = minCost;
            }
        }
        return Arrays.stream(dp[n-1]).min().getAsInt();
    }

    public int minCostMemo(int[][] costs) {
        int n = costs.length;
        int[][] memo = new int[n][4];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        // idx, prevselected, costs
        return minCostMemo(0, -1, n, costs, memo);
    }

    private int minCostMemo(int idx, int prev, int n, int[][] costs, int[][] memo) {
        if (idx >= n) {
            return 0;
        }
        if (memo[idx][prev+1] != -1) {
            return memo[idx][prev+1];
        }

        int minCost = Integer.MAX_VALUE;
        for (int i=0; i<3; i++) {
            if (i != prev) {
                minCost = Math.min(minCost, costs[idx][i] + minCostMemo(idx+1, i, n, costs, memo));
            }
        }
        return memo[idx][prev+1] = minCost;
    }

    public static void main(String[] args) {
        int[][] costs = new int[][] {{17,2,17},{16,16,5},{14,3,19}};
        //int[][] costs = new int[][] {{7, 6, 2}};
        PaintHouse solution = new PaintHouse();
        int res = solution.minCostMemo(costs);
        int res2 = solution.minCostDP(costs);
        System.out.println(res);
        System.out.println(res2);
    }
}

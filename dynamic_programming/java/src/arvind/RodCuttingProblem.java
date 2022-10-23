package arvind;

import java.util.Arrays;

/**
 * Doesnt work too well
 * ???
 */
public class RodCuttingProblem {

	public int maximizeProfit(int[] profits, int n) {
		int[] w = new int[n];
		int[][] dp = new int[n][n+1];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}
		for (int i=1; i<=n; i++) {
			w[i-1] = i;
		}
		return maximizeProfit(profits, w, n-1, n, dp);
	}

	private int maximizeProfit(int[] val, int[] wt, int index, int cap, int[][] dp) {

		if (index == 0) {
			return cap * val[0];
		}
		//if (dp[index][cap] != -1) return dp[index][cap];

		int nottake = 0 + maximizeProfit(wt, val, index - 1, cap, dp);
		int take = Integer.MIN_VALUE;
		if (wt[index] <= cap) {
			take = val[index] + maximizeProfit(wt, val, index, cap - wt[index], dp);
		}
		return dp[index][cap] = Math.max(take, nottake);
	}

	public static void main(String[] args) {
		RodCuttingProblem solution = new RodCuttingProblem();
		int[] profits = {25, 79, 59, 63, 65, 6, 46, 82};
		int n = 8;
		int profit = solution.maximizeProfit(profits, n);
		System.out.println(profit);
	}
}

package arvind;

import java.util.Arrays;

/**
 * https://takeuforward.org/data-structure/unbounded-knapsack-dp-23/
 */
public class UnboundedKnapsackAll {

	public int optimise(int[] wt, int[] val, int cap) {
		int n = wt.length;
		int[][] dp = new int[n][cap+1];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}
		return optimise(wt, val, n-1, cap, dp);
	}

	private int optimise(int[] wt, int[] val, int index, int cap, int[][] dp) {

		if (index == 0) {
			return (cap / wt[0]) * val[0];
		}
		if (dp[index][cap] != -1) return dp[index][cap];

		int nottake = 0 + optimise(wt, val, index - 1, cap, dp);
		int take = Integer.MIN_VALUE;
		if (wt[index] <= cap) {
			take = val[index] + optimise(wt, val, index, cap - wt[index], dp);
		}
		return dp[index][cap] = Math.max(take, nottake);
	}

	public int optimiseTab(int[] wt, int[] val, int cap) {
		int n = wt.length;
		int[][] dp = new int[n][cap+1];
		// add basecases
		for (int j=0; j<dp[0].length; j++) {
			dp[0][j] = (j / wt[0]) * val[0];
		}

		for (int i=1; i< dp.length; i++) {
			for (int j=0; j<dp[0].length; j++) {
				int nottake = 0 + dp[i-1][j];
				int take = Integer.MIN_VALUE;
				if (wt[i] <= j) {
					take = val[i] + dp[i][j - wt[i]];
				}
				dp[i][j] = Math.max(take, nottake);
			}
		}

		return dp[dp.length - 1][dp[0].length - 1];
	}

	public static void main(String[] args) {
		UnboundedKnapsackAll solution = new UnboundedKnapsackAll();
		int[] wt = {2, 4, 6};
		int[] val = {5, 11, 13};
		int cap = 10;
		int value = solution.optimise(wt, val, cap);
		int value2 = solution.optimiseTab(wt, val, cap);
		System.out.println(value);
		System.out.println(value2);
	}
}

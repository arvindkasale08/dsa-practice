package leetcode;

import java.util.Arrays;

public class CoinChange {

	public int coinChange(int[] arr, int target) {
		int n = arr.length;
		int[][] dp = new int[n][target+1];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}
		int ans = findChange(n-1, arr, target, dp);
		return ans == 1000000 ? -1 : ans;
	}

	private int findChange(int idx, int[] arr, int target, int[][] dp) {
		if (idx == 0) {
			if (target % arr[idx] == 0) {
				return target / arr[idx];
			} else {
				return 1000000;
			}
		}

		if (dp[idx][target] != -1) {
			return dp[idx][target];
		}

		int dontpick = 0 + findChange(idx-1, arr, target, dp);
		int pick = 1000000;
		if (target >= arr[idx]) {
			pick = 1 + findChange(idx, arr, target - arr[idx], dp);
		}
		return dp[idx][target] = Math.min(pick, dontpick);
	}

	public static void main(String[] args) {
		int[] coins = new int[]{1, 2, 5};
		int amount = 11;
		CoinChange solution = new CoinChange();
		int result = solution.coinChange(coins, amount);
		System.out.println(result);
	}
}

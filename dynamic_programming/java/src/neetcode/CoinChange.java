package neetcode;

import java.util.Arrays;

public class CoinChange {

	public int coinChangeDP(int[] arr, int target) {
		int n = arr.length;
		int[] dp = new int[target+1];
		Arrays.fill(dp, 10000000);
		dp[0] = 0;
		for (int i=1; i<= target; i++) {
			for (int coin : arr) {
				if (i - coin >= 0) {
					dp[i] = Math.min(dp[i], 1+ dp[i - coin]);
				}
			}
		}

		return dp[n] == 10000000 ? -1 : dp[n];
	}

	public int coinChangeMemo(int[] arr, int target) {
		int n = arr.length;
		int[][] memo = new int[n][target+1];
		for (int[] x : memo) {
			Arrays.fill(x, -1);
		}
		int ans = findChangeMemo(n-1, arr, target, memo);
		return ans == 1000000 ? -1 : ans;
	}

	private int findChangeMemo(int idx, int[] arr, int target, int[][] dp) {
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

		int dontpick = 0 + findChangeMemo(idx-1, arr, target, dp);
		int pick = 1000000;
		if (target >= arr[idx]) {
			pick = 1 + findChangeMemo(idx, arr, target - arr[idx], dp);
		}
		return dp[idx][target] = Math.min(pick, dontpick);
	}

	public static void main(String[] args) {
		int[] coins = new int[]{1, 2, 5};
		int amount = 11;
		CoinChange solution = new CoinChange();
		//int result = solution.coinChangeMemo(coins, amount);
		int result = solution.coinChangeDP(coins, amount);
		System.out.println(result);
	}
}

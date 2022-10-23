package arvind;

import java.util.Arrays;

public class MinimumCoins {

	public int findMinimumCoins(int[] arr, int target) {
		int n = arr.length;
		int[][] dp = new int[n][target+1];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}
		int ans = findMinimumCoins(arr, n-1, target, dp);
		return ans == 1000000 ? -1 : ans;
	}

	private int findMinimumCoins(int[] arr, int index, int target, int[][] dp) {

		if (index == 0) {
			if (target % arr[index] == 0) {
				return target / arr[index];
			} else {
				return 1000000;
			}
		}

		if (dp[index][target] != -1) return dp[index][target];


		int dontpick = 0 + findMinimumCoins(arr, index - 1, target, dp);
		int take = Integer.MAX_VALUE;
		if (target >= arr[index]) {
			take = 1 + findMinimumCoins(arr, index, target - arr[index], dp);
		}
		return dp[index][target] = Math.min(dontpick, take);
	}

	public int findMinimumCoinsTab(int[] arr, int t) {
		int n = arr.length;
		int[][] dp = new int[n][t+1];
		int max = 1000000;

		for (int j=0; j<dp[0].length; j++) {
			if (j % arr[0] == 0) {
				dp[0][j] = j / arr[0];
			} else {
				dp[0][j] = 1000000;
			}
		}

		for (int i=1; i<dp.length; i++) {
			for (int j=0; j<dp[0].length; j++) {
				int notTake = 0 + dp[i-1][j];
				int take = Integer.MAX_VALUE;
				if(arr[i]<=j)
					take = 1 + dp[i][j - arr[i]];

				dp[i][j] = Math.min(notTake, take);
			}
		}

		int ans = dp[n-1][t];
		if(ans >=1000000) return -1;
		return ans;
	}

	public static void main(String[] args) {
		MinimumCoins solution = new MinimumCoins();
		int[] arr = {1, 2, 3};
		int target = 7;
		int result = solution.findMinimumCoins(arr, target);
		int result2 = solution.findMinimumCoinsTab(arr, target);
		System.out.println(result);
		System.out.println(result2);
	}
}

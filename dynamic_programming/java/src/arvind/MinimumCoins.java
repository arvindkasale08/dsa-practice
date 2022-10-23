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

	public static void main(String[] args) {
		MinimumCoins solution = new MinimumCoins();
		int[] arr = {1, 2, 3};
		int target = 7;
		int result = solution.findMinimumCoins(arr, target);
		System.out.println(result);
	}
}

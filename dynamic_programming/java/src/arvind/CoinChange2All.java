package arvind;

import java.util.Arrays;

public class CoinChange2All {

	public int countWays(int[] arr, int target) {
		int n = arr.length;
		int[][] dp = new int[n][target+1];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}
		int ans = countWays(arr, n-1, target, dp);
		return ans;
	}

	private int countWays(int[] arr, int index, int target, int[][] dp) {

		if (index == 0) {
			if (target % arr[index] == 0)
				return 1;
			else
				return 0;
		}

		if (target == 0)
			return 1;

		if (dp[index][target] != -1) return dp[index][target];

		int dontTake = countWays(arr, index - 1, target, dp);
		int take = 0;
		if (target >= arr[index]) {
			take = countWays(arr, index, target - arr[index], dp);
		}

		return dp[index][target] = dontTake + take;
	}

	public int countWaysTab(int[] arr, int target) {
		int n = arr.length;
		int[][] dp = new int[n][target+1];
		// if target = 0 populate 1
		for (int j=0; j<dp[0].length; j++) {
			if (j % arr[0] == 0)
				dp[0][j] = 1;
		}

		for (int i=0; i<dp.length; i++) {
			dp[i][0] = 1;
		}

		for (int i=1; i<dp.length; i++) {
			for (int j=1; j<dp[0].length; j++) {
				int dontTake = dp[i - 1][j];
				int take = 0;
				if (j >= arr[i]) {
					take = dp[i][j - arr[i]];
				}

				dp[i][j] = dontTake + take;
			}
		}

		return dp[dp.length - 1][dp[0].length - 1];
	}

	public static void main(String[] args) {
		CoinChange2All solution = new CoinChange2All();
		int[] arr = {1, 2, 5};
		int target = 5;
		int result = solution.countWays(arr, target);
		int result2 = solution.countWaysTab(arr, target);
		System.out.println(result);
		System.out.println(result2);
	}
}

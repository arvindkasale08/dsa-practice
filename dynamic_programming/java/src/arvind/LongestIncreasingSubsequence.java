package arvind;

import java.util.Arrays;

/**
 * https://takeuforward.org/data-structure/longest-increasing-subsequence-dp-41/
 */
public class LongestIncreasingSubsequence {

	public int findLIS(int[] arr) {
		int n = arr.length;
		int[][] dp = new int[n][n+1];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}
		return findLIS(arr, 0, -1, dp);
	}

	private int findLIS(int[] arr, int i, int prev, int[][] dp) {
		if (i >= arr.length)
			return 0;
		if (dp[i][prev+1] != -1) return dp[i][prev+1];
		int pick = 0;
		if (prev == -1 || arr[i] > arr[prev]) {
			pick = 1 + findLIS(arr, i+1, i, dp);
		}
		int notpick = 0 + findLIS(arr, i+1, prev, dp);
		return dp[i][prev+1] = Math.max(pick, notpick);
	}

	public int findLISTab(int[] arr) {
		int n = arr.length;
		int[][] dp = new int[n+1][n+1];

		for (int i=n-1; i >= 0; i--) {
			for (int prev=i - 1; prev >= -1; prev--) {
				int pick = 0;
				if (prev == -1 || arr[i] > arr[prev]) {
					pick = 1 + dp[i+1][i+1];
				}
				int notpick = 0 + dp[i+1][prev+1];
				dp[i][prev+1] = Math.max(pick, notpick);
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		int[] arr = {3,5,6,2,5,4,19,5,6,7,12};
		//int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
		LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
		int result = solution.findLIS(arr);
		int result2 = solution.findLISTab(arr);
		System.out.println(result);
		System.out.println(result2);
	}
}

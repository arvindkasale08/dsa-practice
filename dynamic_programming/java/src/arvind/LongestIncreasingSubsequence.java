package arvind;

import java.util.Arrays;

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

	public static void main(String[] args) {
		int[] arr = {3,5,6,2,5,4,19,5,6,7,12};
		//int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
		LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
		int result = solution.findLIS(arr);
		System.out.println(result);
	}
}

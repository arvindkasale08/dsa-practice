package arvind;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {

	public int findNumberOfLIS(int[] arr) {
		int n = arr.length;
		int[] dp = new int[n];
		int[] ct = new int[n];
		int maxi = 1;

		Arrays.fill(dp, 1);
		Arrays.fill(ct, 1);

		for (int i = 0; i < n; i++) {
			for (int prev_index = 0; prev_index < i; prev_index++) {
				if (arr[prev_index] < arr[i] && dp[prev_index] + 1 > dp[i]) {
					dp[i] = dp[prev_index] + 1;
					//inherit
					ct[i] = ct[prev_index];
				} else if (arr[prev_index] < arr[i] && dp[prev_index] + 1 == dp[i]) {
					//increase the count
					ct[i] = ct[i] + ct[prev_index];
				}
			}
			maxi = Math.max(maxi, dp[i]);
		}

		int nos = 0;

		for (int i = 0; i <= n - 1; i++) {
			if (dp[i] == maxi) {
				nos += ct[i];
			}
		}

		return nos;
	}

	public static void main(String[] args) {
		NumberOfLongestIncreasingSubsequence solution = new NumberOfLongestIncreasingSubsequence();
		//int[] arr = {1, 3, 5, 4, 7};
		int[] arr = {1, 2};
		int result = solution.findNumberOfLIS(arr);
		System.out.println(result);
	}
}

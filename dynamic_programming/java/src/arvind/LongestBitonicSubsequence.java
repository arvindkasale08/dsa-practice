package arvind;

import java.util.Arrays;

/**
 * https://takeuforward.org/data-structure/longest-bitonic-subsequence-dp-46/
 */
public class LongestBitonicSubsequence {

	public int findLongestBitonicSubsequence(int[] arr) {
		int n = arr.length;
		int[] dp = new int[n];
		int[] revdp = new int[n];
		Arrays.fill(dp, 1);
		Arrays.fill(revdp, 1);

		for (int i=0; i<n; i++) {
			for (int j=0; j<i; j++) {
				if (arr[i] > arr[j]) {
					if (dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
					}
				}
			}
		}

		for (int i=n-1; i>=0; i--) {
			for (int j=n-1; j>i; j--) {
				if (arr[i] > arr[j]) {
					if (revdp[j] + 1 > revdp[i]) {
						revdp[i] = revdp[j] + 1;
					}
				}
			}
		}

		int maxi = 1;
		for (int i=0; i<n; i++) {
			maxi = Math.max(maxi, dp[i] + revdp[i] -1);
		}

		return maxi;
	}

	public static void main(String[] args) {
		LongestBitonicSubsequence solution = new LongestBitonicSubsequence();
		int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
		int result = solution.findLongestBitonicSubsequence(arr);
		System.out.println(result);
	}
}

package arvind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://takeuforward.org/data-structure/printing-longest-increasing-subsequence-dp-42/
 */
public class PrintingLongestIncreasingSubsequence {

	public int[] printLis(int[] arr) {
		int n = arr.length;
		int[] dp = new int[n];
		int[] hash = new int[n];
		for (int i=0; i<n; i++) {
			hash[i] = i;
		}
		Arrays.fill(dp, 1);
		int max = Integer.MIN_VALUE;
		int maxIdx = -1;
		for (int i=0; i<n; i++) {
			for (int j=0; j<i; j++) {
				if (arr[j] < arr[i]) {
					if (1 + dp[j] > dp[i]) {
						dp[i] = 1 + dp[j];
						hash[i] = j;
					}
				}
			}
			if (max < dp[i]) {
				max = dp[i];
				maxIdx = i;
			}
		}
		List<Integer> result = new ArrayList<>();
		int idx = maxIdx;
		while (true) {
			result.add(arr[idx]);
			if (hash[idx] == idx) {
				break;
			}
			idx = hash[idx];


		}

		return result.stream().mapToInt(Integer::intValue).toArray();
	}

	public int findLIS(int[] arr) {
		int n = arr.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int max = Integer.MIN_VALUE;
		for (int i=0; i<n; i++) {
			for (int j=0; j<i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(1 + dp[j], dp[i]);
				}
			}
			max = Math.max(max, dp[i]);
		}

		return max;
	}

	public static void main(String[] args) {
		int[] arr = {5, 4, 11, 1, 16, 8};
		PrintingLongestIncreasingSubsequence solution = new PrintingLongestIncreasingSubsequence();
		int result = solution.findLIS(arr);
		int[] result2 = solution.printLis(arr);
		System.out.println(result);
		System.out.println(Arrays.toString(result2));
	}

}

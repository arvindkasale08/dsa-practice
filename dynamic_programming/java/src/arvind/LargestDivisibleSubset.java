package arvind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://takeuforward.org/data-structure/longest-divisible-subset-dp-44/
 */
public class LargestDivisibleSubset {

	public List<Integer> findLDSubset(int[] arr) {
		int n = arr.length;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int[] hash = new int[n];
		for (int i=0; i<n; i++) {
			hash[i] = i;
		}
		Arrays.sort(arr);
		int max = Integer.MIN_VALUE;
		int maxIdx = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<i; j++) {
				if (arr[i] % arr[j] == 0) {
					if (dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
						hash[i] = j;
						if (max < dp[i]) {
							max = dp[i];
							maxIdx = i;
						}
					}
				}
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
		Collections.reverse(result);
		return result;
	}

	public static void main(String[] args) {
		LargestDivisibleSubset solution = new LargestDivisibleSubset();
		//int[] arr = {1, 16, 7, 8, 4};
		int[] arr = {2, 3, 4, 9, 8};
		List<Integer> result = solution.findLDSubset(arr);
		System.out.println(result);
	}
}

package arvind;

import java.util.Arrays;

public class PartitionArrayForMaxSum {

	public int findMaxSum(int[] arr, int k) {
		int n = arr.length;
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		return findMaxSum(arr, k, 0, n, dp);
	}

	private int findMaxSum(int[] arr, int k, int index, int n, int[] dp) {
		if (index == n) return 0;
		if (dp[index] != -1) return dp[index];
		int length = 0;
		int maxElement = Integer.MIN_VALUE;
		int ans = Integer.MIN_VALUE;
		for (int i = index; i< Math.min(index + k, n); i++) {
			length+= 1;
			maxElement = Math.max(maxElement, arr[i]);
			int sum = (length * maxElement) + findMaxSum(arr, k, i+1, n, dp);
			ans = Math.max(sum, ans);
		}
		return dp[index] = ans;
	}

	public static void main(String[] args) {
		PartitionArrayForMaxSum solution = new PartitionArrayForMaxSum();
		int[] arr = {1, 15, 7, 9, 2, 5, 10};
		int k = 3;
		int sum = solution.findMaxSum(arr, k);
		System.out.println(sum);
	}
}

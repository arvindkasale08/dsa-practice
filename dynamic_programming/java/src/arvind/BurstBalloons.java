package arvind;

import java.util.Arrays;

public class BurstBalloons {

	public int maxCoins(int[] arr) {
		int[] arr2 = new int[arr.length+2];
		for (int i=0; i<arr.length; i++) {
			arr2[i+1] = arr[i];
		}
		arr2[0] = 1; arr2[arr2.length-1] = 1;

		int[][] dp = new int[arr2.length][arr2.length];
		for (int[] a : dp)
			Arrays.fill(a, -1);
		return maxCoins(arr2, 1, arr2.length-2, dp);
	}

	private int maxCoins(int[] arr, int i, int j, int[][] dp) {

		if (i > j) return 0;
		if (dp[i][j] != -1) return dp[i][j];
		int max = Integer.MIN_VALUE;
		for (int k=i; k<=j; k++) {
			int left = maxCoins(arr, i, k-1, dp);
			int right = maxCoins(arr, k+1, j, dp);
			int cost = arr[k] * arr[i-1] * arr[j+1];
			max = Math.max(max, left + right + cost);
		}
		return dp[i][j] = max;
	}

	public static void main(String[] args) {
		BurstBalloons balloons = new BurstBalloons();
		int[] arr = new int[] {3, 1, 5, 8};
		int result = balloons.maxCoins(arr);
		System.out.println(result);
	}
}

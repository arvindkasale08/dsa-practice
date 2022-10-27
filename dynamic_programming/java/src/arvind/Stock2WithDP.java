package arvind;

import java.util.Arrays;

public class Stock2WithDP {

	public int findMaxProfit(int[] arr) {
		int n = arr.length;
		int[][] dp = new int[n][2];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}
		// arr, start, canbuy, dp
		return findMaxProfit(arr, 0, 1,  dp);
	}

	private int findMaxProfit(int[] arr, int index, int canBuy, int[][] dp) {

		if (index == arr.length)
			return 0;

		if (dp[index][canBuy] != -1) return dp[index][canBuy];

		if (canBuy == 1) {
			int buy = - arr[index] + findMaxProfit(arr, index+1, 0, dp);
			int ignore = 0 + findMaxProfit(arr, index+1, 1, dp);
			return dp[index][canBuy] = Math.max(buy, ignore);
		} else {
			int sell = arr[index] + findMaxProfit(arr, index + 1, 1, dp);
			int ignore = 0 + findMaxProfit(arr, index + 1, 0, dp);
			return dp[index][canBuy] = Math.max(sell, ignore);
		}
	}

	private int findMaxProfitTab(int[] arr) {
		int n = arr.length;
		int[][] dp = new int[n+1][2];

		dp[n][0] = 0;
		dp[n][1] = 0;

		for (int index=n-1; index>=0; index--) {
			for (int canBuy=0; canBuy<=1; canBuy++) {
				if (canBuy == 1) {
					int buy = - arr[index] + dp[index+1][0];
					int ignore = 0 + dp[index+1][1];
					dp[index][canBuy] = Math.max(buy, ignore);
				} else {
					int sell = arr[index] + dp[index + 1][1];
					int ignore = 0 + dp[index + 1][0];
					dp[index][canBuy] = Math.max(sell, ignore);
				}
			}
		}

		return dp[0][1];
	}

	public static void main(String[] args) {
		int[] arr = {7, 1, 5, 3, 6, 4};
		Stock2WithDP solution = new Stock2WithDP();
		int profit = solution.findMaxProfit(arr);
		int profit2 = solution.findMaxProfitTab(arr);
		System.out.println(profit);
		System.out.println(profit2);
	}
}

package arvind;

import java.util.Arrays;

public class Stock4 {

	public int findMaxProfit(int[] arr, int k) {
		int n = arr.length;
		int[][][] dp = new int[n][2][k+1];
		for (int[][] x : dp) {
			for (int[] y : x) {
				Arrays.fill(y, -1);
			}
		}
		return findMaxProfit(arr, 0, 1, k, dp);
	}

	private int findMaxProfit(int[] arr, int index, int canBuy, int cap, int[][][] dp) {

		if (index == arr.length || cap == 0)
			return 0;

		if (dp[index][canBuy][cap] != -1) return dp[index][canBuy][cap];

		if (canBuy == 0) {
			int doNothing = 0 + findMaxProfit(arr, index+1, 0, cap, dp);
			int sell = arr[index] + findMaxProfit(arr, index + 1, 1, cap - 1, dp);
			return dp[index][canBuy][cap] = Math.max(doNothing, sell);
		} else {
			int doNothing = 0 + findMaxProfit(arr, index + 1, 1, cap, dp);
			int buy = - arr[index] + findMaxProfit(arr, index + 1, 0, cap, dp);
			return dp[index][canBuy][cap] = Math.max(doNothing, buy);
		}
	}

	public int findMaxProfitTab(int[] arr, int k) {
		int n = arr.length;
		int[][][] dp = new int[n+1][k+1][2];

		for (int index=n-1; index>=0; index--) {
			for (int cap=1; cap<=k; cap++) {
				for (int canBuy = 0; canBuy <= 1; canBuy++) {
					if (canBuy == 1) {
						int doNothing = 0 + dp[index + 1][cap][1];
						int buy = - arr[index] + dp[index + 1][cap][0];
						dp[index][cap][canBuy] = Math.max(doNothing, buy);
					} else {
						int doNothing = 0 + dp[index + 1][cap][0];
						int sell = arr[index] + dp[index + 1][cap - 1][1];
						dp[index][cap][canBuy] = Math.max(doNothing, sell);
					}
				}
			}
		}

		return dp[0][k][1];
	}

	public static void main(String[] args) {
		Stock4 solution = new Stock4();
		int[] arr = {3, 2, 6, 5, 0, 3};
		int k = 2;
		int maxProfit = solution.findMaxProfit(arr, k);
		int maxProfit2 = solution.findMaxProfitTab(arr, k);
		System.out.println(maxProfit);
		System.out.println(maxProfit2);
	}
}

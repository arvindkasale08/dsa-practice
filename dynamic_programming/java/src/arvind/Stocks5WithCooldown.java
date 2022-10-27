package arvind;

import java.util.Arrays;

public class Stocks5WithCooldown {

	public int maxProfit(int[] arr) {
		int n = arr.length;
		int[][] dp = new int[n][2];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		return maxProfit(arr, 0, 1, dp);
	}

	private int maxProfit(int[] arr, int ind, int canBuy, int[][] dp) {
		if (ind >= arr.length) return 0;
		if (dp[ind][canBuy] != -1) return dp[ind][canBuy];
		if (canBuy == 1) {
			int doNothing = 0 + maxProfit(arr, ind + 1, 1, dp);
			int buy = -arr[ind] + maxProfit(arr, ind + 1, 0, dp);
			return dp[ind][canBuy] = Math.max(doNothing, buy);
		} else {
			int doNothing = 0 + maxProfit(arr, ind + 1, 0, dp);
			int sell = arr[ind] + maxProfit(arr, ind + 2, 1, dp);
			return dp[ind][canBuy] = Math.max(doNothing, sell);
		}
	}

	// For tabulation solution check Stock2

	private int findMaxProfitTab(int[] arr) {
		int n = arr.length;
		int[][] dp = new int[n+2][2];

		for (int index=n-1; index>=0; index--) {
			for (int canBuy=0; canBuy<=1; canBuy++) {
				if (canBuy == 1) {
					int buy = - arr[index] + dp[index+1][0];
					int ignore = 0 + dp[index+1][1];
					dp[index][canBuy] = Math.max(buy, ignore);
				} else {
					int sell = arr[index] + dp[index + 2][1];
					int ignore = 0 + dp[index + 1][0];
					dp[index][canBuy] = Math.max(sell, ignore);
				}
			}
		}

		return dp[0][1];
	}

	public static void main(String[] args) {
		Stocks5WithCooldown solution = new Stocks5WithCooldown();
		int[] arr = {1, 2, 3, 0, 2};
		int profit = solution.maxProfit(arr);
		int profit2 = solution.findMaxProfitTab(arr);
		System.out.println(profit);
		System.out.println(profit2);
	}
}

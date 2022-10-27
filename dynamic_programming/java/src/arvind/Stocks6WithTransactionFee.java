package arvind;

import java.util.Arrays;

/**
 * https://takeuforward.org/data-structure/buy-and-sell-stocks-with-transaction-fees-dp-40/
 */
public class Stocks6WithTransactionFee {

	public int maxProfit(int[] arr, int fee) {
		int n = arr.length;
		int[][] dp = new int[n][2];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		return maxProfit(arr, 0, 1, fee, dp);
	}

	private int maxProfit(int[] arr, int ind, int canBuy, int fee, int[][] dp) {
		if (ind >= arr.length) return 0;
		if (dp[ind][canBuy] != -1) return dp[ind][canBuy];
		if (canBuy == 1) {
			int doNothing = 0 + maxProfit(arr, ind + 1, 1, fee, dp);
			int buy = -arr[ind] + maxProfit(arr, ind + 1, 0, fee, dp);
			return dp[ind][canBuy] = Math.max(doNothing, buy);
		} else {
			int doNothing = 0 + maxProfit(arr, ind + 1, 0, fee, dp);
			int sell = arr[ind] - fee + maxProfit(arr, ind + 1, 1, fee, dp);
			return dp[ind][canBuy] = Math.max(doNothing, sell);
		}
	}

	private int findMaxProfitTab(int[] arr, int fee) {
		int n = arr.length;
		int[][] dp = new int[n+1][2];

		for (int index=n-1; index>=0; index--) {
			for (int canBuy=0; canBuy<=1; canBuy++) {
				if (canBuy == 1) {
					int buy = - arr[index] + dp[index+1][0];
					int ignore = 0 + dp[index+1][1];
					dp[index][canBuy] = Math.max(buy, ignore);
				} else {
					int sell = arr[index] - fee + dp[index + 1][1];
					int ignore = 0 + dp[index + 1][0];
					dp[index][canBuy] = Math.max(sell, ignore);
				}
			}
		}

		return dp[0][1];
	}

	public static void main(String[] args) {
		Stocks6WithTransactionFee solution = new Stocks6WithTransactionFee();
		int[] arr = {1, 3, 2, 8, 4, 9};
		int fee = 2;
		int profit = solution.maxProfit(arr, fee);
		int profit2 = solution.findMaxProfitTab(arr, fee);
		System.out.println(profit);
		System.out.println(profit2);
	}
}

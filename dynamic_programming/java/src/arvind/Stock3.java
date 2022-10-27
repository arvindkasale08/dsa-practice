package arvind;

import java.util.Arrays;

public class Stock3 {

	public int findMaxProfit(int[] arr) {
		int n = arr.length;
		int cap = 2;
		int[][][] dp = new int[n+1][cap+1][2];
		for (int[][] a : dp) {
			for (int[] b : a) {
				Arrays.fill(b, -1);
			}
		}
		return findMaxProfit(arr, 0, 1, cap, dp);
	}

	private int findMaxProfit(int[] arr, int index, int canBuy, int cap, int[][][] dp) {

		if (index == arr.length || cap == 0)
			return 0;
		if (dp[index][cap][canBuy] != -1) return dp[index][cap][canBuy];

		if (canBuy == 1) {
			int doNothing = 0 + findMaxProfit(arr, index + 1, 1, cap, dp);
			int buy = - arr[index] + findMaxProfit(arr, index + 1, 0, cap, dp);
			return dp[index][cap][canBuy] = Math.max(doNothing, buy);
		} else {
			int doNothing = 0 + findMaxProfit(arr, index + 1, 0, cap, dp);
			int sell = arr[index] + findMaxProfit(arr, index + 1, 1, cap - 1, dp);
			return dp[index][cap][canBuy] = Math.max(doNothing, sell);
		}
	}

	public int findMaxProfitTab(int[] arr) {
		int n = arr.length;
		int[][][] dp = new int[n+1][3][2];

		// base case/.... no need to actually do this as the default value is 0
		for (int cap=0; cap<=2; cap++) {
			for (int canBuy=0; canBuy<=1; canBuy++) {
				dp[dp.length - 1][cap][canBuy] = 0;
			}
		}

		for (int index=0; index<=n; index++) {
			for (int canBuy=0; canBuy<=1; canBuy++) {
				dp[index][0][canBuy] = 0;
			}
		}

		for (int index=n-1; index>=0; index--) {
			for (int cap=1; cap<=2; cap++) {
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

		return dp[0][2][1];
	}

	public static void main(String[] args) {
		Stock3 solution = new Stock3();
		int[] arr = {7, 1, 5, 3, 6, 4};
		int profit = solution.findMaxProfit(arr);
		int profit2 = solution.findMaxProfitTab(arr);
		System.out.println(profit);
		System.out.println(profit2);
	}
}

package arvind;

import java.util.Arrays;

public class MinimumCostToCutStick {

	public int findMinimumCost(int[] cuts, int n) {
		int[] cuts2 = new int[cuts.length + 2];
		for (int i=0; i<cuts.length; i++) {
			cuts2[i] = cuts[i];
		}
		cuts2[cuts2.length-1] = 0;
		cuts2[cuts2.length-2] = n;
		Arrays.sort(cuts2);

		int[][] dp = new int[cuts2.length][cuts2.length];
		for (int[] a : dp)
			Arrays.fill(a, -1);
		return findMinimumCost(cuts2, 1, cuts2.length-2, dp);
	}

	private int findMinimumCost(int[] cuts, int i, int j, int[][] dp) {
		if (i > j) return 0;
		if (dp[i][j] != -1) return dp[i][j];
		int min = Integer.MAX_VALUE;
		for (int k=i; k <=j ; k++) {
			int left = findMinimumCost(cuts, i, k-1, dp);
			int right = findMinimumCost(cuts, k+1, j, dp);
			int cost = cuts[j+1] - cuts[i-1];
			min = Math.min(min, left + right + cost);
		}
		return dp[i][j] = min;
	}

	private int findMinimumCostTab(int[] cuts, int n) {
		int[] cuts2 = new int[cuts.length + 2];
		for (int i=0; i<cuts.length; i++) {
			cuts2[i] = cuts[i];
		}
		cuts2[cuts2.length-1] = 0;
		cuts2[cuts2.length-2] = n;
		Arrays.sort(cuts2);

		int[][] dp = new int[cuts2.length][cuts2.length];

		return 1;
	}

	public static void main(String[] args) {
		MinimumCostToCutStick solution = new MinimumCostToCutStick();
		int[] cuts = {1, 3, 4, 5};
		int n = 7;
		int result = solution.findMinimumCost(cuts, n);
		System.out.println(result);
	}
}

package arvind;

import java.util.Arrays;

public class O1KnapsackStriver {

	public int maxValue(int[] w, int[] v, int c) {
		int n = w.length;
		int[][] dp = new int[n][c+1];
		for (int[] arr : dp) {
			Arrays.fill(arr, -1);
		}
		return maxValue(w, v, c, n-1, dp);
	}

	private int maxValue(int[] w, int[] v, int c, int index, int[][] dp) {

		// ad base cases here
		if (index == 0) {
			if (w[index] <= c) {
				return v[index];
			} else {
				return 0;
			}
		}

		if (dp[index][c] != -1) return dp[index][c];


		int donttake = 0 + maxValue(w, v, c, index -1, dp);

		int take = Integer.MIN_VALUE;

		if (w[index] <= c) {
			take = v[index] + maxValue(w, v, c-w[index], index-1, dp);
		}

		return dp[index][c] = Math.max(take, donttake);
	}

	private int maxValueTab(int[] w, int[] v, int c) {
		int n = w.length;
		int[][] dp = new int[n][c+1];

		// Add base cases;
		for (int j=0; j<dp[0].length; j++) {
			if (j <= c) {
				dp[0][j] = v[0];
			} else {
				dp[0][j] = v[0];
			}
		}

		/*for (int i=0; i<dp.length; i++) {
			dp[i][0] = 0;
		}*/

		for (int i=1; i<dp.length; i++) {
			for (int j=0; j<=dp[0].length; j++) {
				int donttake = 0 + dp[i -1][j];

				int take = Integer.MIN_VALUE;

				if (w[i] <= c) {
					take = v[i] + dp[i-1][j - w[i]];
				}

				dp[i][j] = Math.max(take, donttake);
			}
		}


		return dp[dp.length -1][dp[0].length - 1];
	}

	public static void main(String[] args) {
		O1KnapsackStriver solution = new O1KnapsackStriver();
		int[] w = new int[] {1, 2, 4, 5};
		int[] v = new int[] {5, 4, 8, 6};
		int c = 5;
		int stolenValue = solution.maxValue(w, v, c);
		int stolenValue2 = solution.maxValueTab(w, v, c);
		System.out.println(stolenValue);
		System.out.println(stolenValue2);
	}
}

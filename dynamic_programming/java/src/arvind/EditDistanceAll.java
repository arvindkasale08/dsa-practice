package arvind;

import java.util.Arrays;

public class EditDistanceAll {

	public int findOperations(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m+1][n+1];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}
		return findOperations(s1, s2, m-1, n-1, dp);
	}

	private int findOperations(String s1, String s2, int i, int j, int[][] dp) {

		if (i < 0) {
			return j + 1;
		}
		if (j < 0) {
			return i + 1;
		}
		if (dp[i][j] != -1)
			return dp[i][j];

		if (s1.charAt(i) == s2.charAt(j)) {
			return dp[i][j] = findOperations(s1, s2, i-1, j-1, dp);
		} else {
			return dp[i][j] = 1 + Math.min(Math.min(findOperations(s1, s2, i, j-1, dp), findOperations(s1, s2, i-1, j-1, dp)), findOperations(s1, s2, i-1, j, dp));
		}
	}

	public int findOperationsTab(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m+1][n+1];

		// base cases;
		for (int i=0; i<=m; i++) {
			dp[i][0] = i;
		}
		for (int j=0; j<=n; j++) {
			dp[0][j] = j;
		}

		for (int i=1; i<=m; i++) {
			for (int j=1; j<=n; j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1], dp[i-1][j-1]), dp[i-1][j]);
				}
			}
		}

		return dp[dp.length - 1][dp[0].length-1];
	}

	public static void main(String[] args) {
		EditDistanceAll solution = new EditDistanceAll();
		String s1 = "horse";
		String s2 = "ros";
		int noofoperations = solution.findOperations(s1, s2);
		int noofoperations2 = solution.findOperationsTab(s1, s2);
		System.out.println(noofoperations);
		System.out.println(noofoperations2);
	}
}

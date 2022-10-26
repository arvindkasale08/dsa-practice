package arvind;

import java.util.Arrays;

public class WildcardMatching {

	public boolean isMatching(String pattern, String str) {
		int m = pattern.length();
		int n = str.length();
		Boolean[][] dp = new Boolean[m][n];
		return isMatching(pattern, str, m-1, n-1, dp);
	}

	private boolean isMatching(String pattern, String str, int i, int j, Boolean[][] dp) {
		if (i < 0 && j < 0)
			return true;
		if (i < 0 && j >= 0)
			return false;
		if (j < 0 && i >= 0)
			return isAllStars(pattern, i);
		if (dp[i][j] != null) return dp[i][j];

		if (pattern.charAt(i) == str.charAt(j) || pattern.charAt(i) == '?') {
			return dp[i][j] = isMatching(pattern, str, i-1, j-1, dp);
		} else {
			if (pattern.charAt(i) == '*') {
				return dp[i][j] = isMatching(pattern, str, i-1, j, dp) || isMatching(pattern, str, i, j-1, dp);
			} else {
				return dp[i][j] = false;
			}
		}
	}

	private boolean isAllStars(String pattern, int i) {
		while (i >= 0) {
			if (pattern.charAt(i) != '*')
				return false;
			i--;
		}
		return true;
	}

	public boolean isMatchingTab(String pattern, String str) {
		int m = pattern.length();
		int n = str.length();
		boolean[][] dp = new boolean[m+1][n+1];

		// base cases;
		dp[0][0] = true;

		for (int j=1; j<dp[0].length; j++) {
			dp[0][j] = false;
 		}
		for (int i=1; i<dp.length; i++) {
			dp[i][0] = isAllStars(pattern, i-1);
		}

		for (int i=1; i<dp.length; i++) {
			for (int j=1; j<dp[0].length; j++) {
				if (pattern.charAt(i-1) == str.charAt(j-1) || pattern.charAt(i-1) == '?') {
					dp[i][j] = dp[i-1][j-1];
				} else {
					if (pattern.charAt(i-1) == '*') {
						dp[i][j] = dp[i-1][j] || dp[i][j-1];
					} else {
						dp[i][j] = false;
					}
				}
			}
		}
		return dp[dp.length - 1][dp[0].length-1];
	}

	public static void main(String[] args) {
		WildcardMatching solution = new WildcardMatching();
		String s1 = "?ay";
		String s2 = "ray";
		boolean result = solution.isMatching(s1, s2);
		boolean result2 = solution.isMatchingTab(s1, s2);
		System.out.println(result);
		System.out.println(result2);
	}
}

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

	public static void main(String[] args) {
		WildcardMatching solution = new WildcardMatching();
		String s1 = "*?ay";
		String s2 = "ray";
		boolean result = solution.isMatching(s1, s2);
		System.out.println(result);
	}
}

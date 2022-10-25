package arvind;

import java.util.Arrays;

public class MinimumInsertionsToMakeStringPalindrome {

	public int calcNumberOfInsertions(String s1) {
		int n = s1.length();
		String s2 = new StringBuffer(s1).reverse().toString();
		int[][] dp = new int[n+1][n+1];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}
		int lps = calcLCSTab(s1, s2);
		return n - lps;
	}

	private int calcLCSTab(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m + 1][n + 1];

		// add the base cases - as base case was init to zero nothing was done

		for (int i1=1; i1<dp.length; i1++) {
			for (int i2=1; i2<dp[0].length; i2++) {
				if (s1.charAt(i1-1) == s2.charAt(i2-1))
					dp[i1][i2] = 1 + dp[i1 -1][i2 -1];
				else
					// if not match
					dp[i1][i2] = Math.max(dp[i1 - 1][i2], dp[i1][i2-1]);
			}

		}
		return dp[dp.length -1] [dp[0].length - 1];
	}

	private int calcLPS(String s1, String s2, int i1, int i2, int[][] dp) {
		if (i1 < 0 || i2 < 0)
			return 0;

		if (dp[i1][i2] != -1) return dp[i1][i2];

		if (s1.charAt(i1) == s2.charAt(i2))
			return 1 + calcLPS(s1, s2, i1 -1, i2 -1, dp);

		// if not match
		return dp[i1][i2] = Math.max(calcLPS(s1, s2, i1 - 1, i2, dp), calcLPS(s1, s2, i1, i2-1, dp));
	}

	public static void main(String[] args) {
		MinimumInsertionsToMakeStringPalindrome solution = new MinimumInsertionsToMakeStringPalindrome();
		String s = "abcaa";
		int res = solution.calcNumberOfInsertions(s);
		System.out.println(res);
	}
}

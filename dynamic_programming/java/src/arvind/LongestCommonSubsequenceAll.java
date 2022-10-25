package arvind;

import java.util.Arrays;

/**
 * https://takeuforward.org/data-structure/longest-common-subsequence-dp-25/
 */
public class LongestCommonSubsequenceAll {

	private int findLCSLength(String s1, String s2) {
		int[][] dp = new int[s1.length()][s2.length()];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}
		return findLCSLength(s1, s2, s1.length() - 1, s2.length() - 1, dp);
	}

	private int findLCSLength(String s1, String s2, int i1, int i2, int[][] dp) {

		if (i1 < 0 || i2 < 0)
			return 0;

		if (dp[i1][i2] != -1) return dp[i1][i2];

		if (s1.charAt(i1) == s2.charAt(i2))
			return 1 + findLCSLength(s1, s2, i1 -1, i2 -1, dp);

		// if not match
		return Math.max(findLCSLength(s1, s2, i1 - 1, i2, dp), findLCSLength(s1, s2, i1, i2-1, dp));
	}

	public int findLCSLengthTab(String s1, String s2) {
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

	public static void main(String[] args) {
		String s1 = "adebc";
		String s2 = "dcadb";
		LongestCommonSubsequenceAll solution = new LongestCommonSubsequenceAll();
		int result = solution.findLCSLength(s1, s2);
		int result2 = solution.findLCSLengthTab(s1, s2);
		System.out.println(result);
		System.out.println(result2);
	}
}

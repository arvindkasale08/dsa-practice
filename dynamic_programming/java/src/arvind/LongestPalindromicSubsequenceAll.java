package arvind;

import java.util.Arrays;

public class LongestPalindromicSubsequenceAll {

	public int findLPS(String s1) {
		String s2 = new StringBuffer(s1).reverse().toString();
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m][n];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}
		return findLCS(s1, s2, m-1, n-1, dp);
	}

	private int findLCS(String s1, String s2, int ind1, int ind2, int[][] dp) {

		if (ind1 < 0 || ind2 < 0)
			return 0;

		if (dp[ind1][ind2] != -1) return dp[ind1][ind2];

		if (s1.charAt(ind1) == s2.charAt(ind2)) {
			return 1 + findLCS(s1, s2, ind1-1, ind2-1, dp);
		}
		return dp[ind1][ind2] = Math.max(findLCS(s1, s2, ind1-1, ind2, dp), findLCS(s1, s2, ind1, ind2-1, dp));
	}

	public static void main(String[] args) {
		String s1 = "bbbab";
		LongestPalindromicSubsequenceAll solution = new LongestPalindromicSubsequenceAll();
		int result = solution.findLPS(s1);
		System.out.println(result);
	}
}

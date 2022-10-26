package arvind;

import java.util.Arrays;

public class DistinctSubsequences {

	public int findCountofSubSequences(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m+1][n+1];
		for (int[] x : dp) {
			Arrays.fill(x, -1);
		}
		return findCountofSubSequences(s1, s2, m-1, n-1, dp);
	}

	private int findCountofSubSequences(String s1, String s2, int i1, int i2, int[][] dp) {
		if (i2 < 0)
			return 1;
		if (i1 < 0)
			return 0;
		if (dp[i1][i2] != -1) return dp[i1][i2];

		if (s1.charAt(i1) == s2.charAt(i2)) {
			int take = findCountofSubSequences(s1, s2, i1-1, i2-1, dp);
			int dont = findCountofSubSequences(s1, s2, i1 - 1, i2, dp);
			return dp[i1][i2] = take + dont;
		} else {
			return dp[i1][i2] = findCountofSubSequences(s1, s2, i1-1, i2, dp);
		}
	}

	public static void main(String[] args) {
		DistinctSubsequences solution = new DistinctSubsequences();
		String s1 = "babgbag";
		String s2 = "bag";
		int result = solution.findCountofSubSequences(s1, s2);
		System.out.println(result);
	}
}

package arvind;

public class LongestCommonSubsequence {

	// Tabulation solution using a dp 2d array (matrix)
	private int findLcs(String s1, String s2) {
		char[] w1 = s1.toCharArray();
		char[] w2 = s2.toCharArray();
		int m = w2.length;
		int n = w1.length;
		int[][] dp = new int[m+1][n+1];

		if (w1.length == 0 || w2.length == 0)
			return 0;
		// start from the 1st row and 1st column
		for (int i=1; i<dp.length; i++) {
			for (int j=1; j<dp[0].length; j++) {
				if (w1[j-1] == w2[i-1]) {
					dp[i][j] = 1 + dp[i-1][j-1];
				} else {
					dp[i][j] = 0 + Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}

		return dp[m][n];
	}

	public static void main(String[] args) {
		LongestCommonSubsequence solution = new LongestCommonSubsequence();
		String s1 = "abcde";
		String s2 = "ace";

		int result = solution.findLcs(s1, s2);
		System.out.println(result);
	}
}

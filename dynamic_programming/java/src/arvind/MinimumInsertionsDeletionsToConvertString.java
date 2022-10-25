package arvind;

public class MinimumInsertionsDeletionsToConvertString {

	public int findNumberOperations(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();

		int lcs = findLcs(s1, s2, m, n);

		int deletions = m - lcs;
		int insertions = n - lcs;
		return deletions + insertions;
	}

	private int findLcs(String s1, String s2, int m, int n) {
		int[][] dp = new int[m+1][n+1];
		for (int i=1; i<dp.length; i++) {
			for (int j=1; j<dp[0].length; j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				} else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}

	public static void main(String[] args) {
		MinimumInsertionsDeletionsToConvertString solution = new MinimumInsertionsDeletionsToConvertString();
		String s1 = "abcd";
		String s2 = "anc";
		int operations = solution.findNumberOperations(s1, s2);
		System.out.println(operations);
	}
}

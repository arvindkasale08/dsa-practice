package arvind;

public class LongestCommonSubsequencePrint {

	public String findLCSLengthTab(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m + 1][n + 1];

		// add the base cases
		for (int i1=1; i1<dp.length; i1++) {
			for (int i2=1; i2<dp[0].length; i2++) {
				if (s1.charAt(i1-1) == s2.charAt(i2-1))
					dp[i1][i2] = 1 + dp[i1 -1][i2 -1];
				else
					// if not match
					dp[i1][i2] = Math.max(dp[i1 - 1][i2], dp[i1][i2-1]);
			}

		}

		StringBuilder str = new StringBuilder();
		int i = dp.length - 1;
		int j = dp[0].length - 1;

		while (i > 0 && j > 0) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					// append the character and move diagonally
					str.append(s1.charAt(i-1));
					i--;
					j--;
				} else {
					if (dp[i-1][j] > dp[i][j-1]) {
						// move to the top row
						i--;
					} else {
						// move to the left
						j--;
					}
				}
		}

		return str.reverse().toString();

	}
		public static void main(String[] args) {
			String s1 = "abcde";
			String s2 = "bdgek";
			LongestCommonSubsequencePrint solution = new LongestCommonSubsequencePrint();
			String result2 = solution.findLCSLengthTab(s1, s2);
			System.out.println(result2);
		}
}

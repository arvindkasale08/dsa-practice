package arvind;

public class LongestCommonSubstring {

	public int findLCS(String s1, String s2) {
		char[] ch1 = s1.toCharArray();
		char[] ch2 = s2.toCharArray();
		int m = ch1.length;
		int n = ch2.length;
		int[][] dp = new int[n + 1][m + 1];
		int count = 0;

		for (int i=1; i<dp.length; i++) {
			for (int j=1; j<dp[0].length; j++) {
				if (ch1[j-1] == ch2[i-1]) {
					dp[i][j] = 1 + dp[i-1][j-1];
					count = Math.max(count, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		LongestCommonSubstring solution = new LongestCommonSubstring();
		String s1 = "ABCDGH";
		String s2 = "ACDGHR";
		int result = solution.findLCS(s1, s2);
		System.out.println(result);
	}
}

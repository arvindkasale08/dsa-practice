package arvind;

public class LongestCommonSubstringAll {

	public int findLCSLength(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int[][] dp = new int[m+1][n+1];

		int max = 0;
		for (int i=1; i<dp.length; i++) {
			for (int j=1; j<dp[0].length; j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
					max = Math.max(dp[i][j], max);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		LongestCommonSubstringAll solution = new LongestCommonSubstringAll();
		String s1 = "abcjklp";
		String s2 = "acjkp";
		int result = solution.findLCSLength(s1, s2);
		System.out.println(result);
	}
}

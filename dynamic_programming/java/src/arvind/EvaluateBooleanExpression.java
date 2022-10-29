package arvind;

import java.util.Arrays;

public class EvaluateBooleanExpression {

	public long countWaysToTrue(String str) {
		char[] ch = str.toCharArray();
		int n = ch.length;
		long[][][] dp = new long[n][n][2];
		for (long[][] arr : dp) {
			for (long[] x : arr) {
				Arrays.fill(x, -1);
			}
		}
		return countWaysToTrue(ch, 0, n-1, 1, dp);
	}

	private long countWaysToTrue(char[] ch, int i, int j, int isTrue, long[][][] dp) {
		if (i > j) return 0;
		if (i == j) {
			if (isTrue == 1) return ch[i] == 'T' ? 1 : 0;
			if (isTrue == 0) return ch[i] == 'F' ? 1 : 0;
		}
		if (dp[i][j][isTrue] != -1) return dp[i][j][isTrue];

		long ways = 0;
		for (int index=i+1; index <= j-1; index= index+2) {
			long lt = countWaysToTrue(ch, i, index-1, 1, dp);
			long lf = countWaysToTrue(ch, i, index-1, 0, dp);
			long rt = countWaysToTrue(ch, index + 1, j, 1, dp);
			long rf = countWaysToTrue(ch, index + 1, j, 0, dp);

			if (ch[index] == '&') {
				if (isTrue == 1) {
					ways += lt * rt;
				} else {
					ways += lt * rf + lf * rt + lf * rf;
				}
			} else if (ch[index] == '|') {
				if (isTrue == 1) {
					ways += lt * rt + lt * rf + rt * lf;
				} else {
					ways += lf * rf;
				}
			} else {
				if (isTrue == 1) {
					ways += lt * rf + rt * lf;
				} else {
					ways += lt * rt + lf * rf;
				}
			}
		}

		return dp[i][j][isTrue] = ways;
	}

	public static void main(String[] args) {
		String str = "F|T^F";
		EvaluateBooleanExpression solution = new EvaluateBooleanExpression();
		long ways = solution.countWaysToTrue(str);
		System.out.println(ways);
	}
}

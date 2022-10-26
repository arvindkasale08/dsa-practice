package arvind;

public class ShortestCommonSuperSequence {

	public String findSCSS(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		int dp[][] = new int[m+1][n+1];
		for (int i=1; i<dp.length; i++) {
			for (int j=1; j<dp[0].length; j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				} else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		int i=m, j=n;
		while (i >= 0 && j >= 0) {
			if (i ==0 && j ==0) {
				break;
			}
			if (i == 0) {
				sb.append(s2.charAt(j-1));
				j--;
				continue;
			}
			if (j == 0) {
				sb.append(s1.charAt(i-1));
				i--;
				continue;
			}

			if (s1.charAt(i-1) == s2.charAt(j-1)) {
				sb.append(s1.charAt(i-1));
				i--;
				j--;
			} else {
				if (dp[i-1][j] > dp[i][j-1]) {
					sb.append(s1.charAt(i-1));
					i--;
				} else {
					sb.append(s2.charAt(j-1));
					j--;
				}
			}
		}

		return sb.reverse().toString();
	}

	public static void main(String[] args) {
		ShortestCommonSuperSequence solution = new ShortestCommonSuperSequence();
		String s1 = "brute";
		String s2 = "groot";
		String result = solution.findSCSS(s1, s2);
		System.out.println(result);
	}
}

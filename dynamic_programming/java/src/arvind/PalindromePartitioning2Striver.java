package arvind;

import java.util.Arrays;

public class PalindromePartitioning2Striver {

	public int findMinPartitions(String str) {
		char[] ch = str.toCharArray();
		int n = ch.length;
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		if (isPal(ch, 0, n-1)) return 0;

		return findMinPartitions(ch, 0, dp) - 1;
	}

	private boolean isPal(char[] ch, int i, int j) {
		while (i < j) {
			if (ch[i] != ch[j]) return false;
			i++;
			j--;
		}
		return true;
	}

	private int findMinPartitions(char[] ch, int i, int[] dp) {
		if (i==ch.length) return 0;

		if (dp[i] != -1) return dp[i];

		int min = Integer.MAX_VALUE;
		for (int j=i; j<ch.length; j++) {
			if (isPal(ch, i, j)) {
				min = Math.min(min, 1 + findMinPartitions(ch, j+1, dp));
			}
		}
		return dp[i] = min;
	}


	public static void main(String[] args) {
		PalindromePartitioning2Striver solution = new PalindromePartitioning2Striver();
		//String str = "bababcbadcede";
		String str = "cdd";
		int partitions = solution.findMinPartitions(str);
		System.out.println(partitions);
	}
}

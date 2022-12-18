package arvind.neetcode;

import java.util.Arrays;

public class UniqueBST {

	public int uniqueTrees(int n) {
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		if (n > 2) {
			int j = 3;
			while (j <= n) {
				int sum = 0;
				for (int i = 1; i <= j; i++) {
					int left = i - 1;
					int right = j - i;
					int leftChances = dp[left];
					int rightChances = dp[right];
					sum += leftChances * rightChances;
				}
				dp[j] = sum;
				j++;
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		UniqueBST solution = new UniqueBST();
		int n = 5;
		int count = solution.uniqueTrees(n);
		System.out.println(count);
	}
}

package arvind;

public class MCMTab {

	public int findMinCost(int[] arr) {
		int n = arr.length;
		int dp[][] = new int[n][n];
		// base case
		for (int i=0; i<dp.length; i++) {
			dp[i][i] = 0; // not actually needed.
		}

		for (int i=n-1; i>=1; i--) {
			for (int j=i+1; j<=n-1; j++) {
				int min = Integer.MAX_VALUE;
				for (int k=i; k<j; k++) {
					int left = dp[i][k];
					int right = dp[k+1][j];
					int cost = arr[i-1] * arr[k] * arr[j];
					min = Math.min(min, left + right + cost);
				}
				dp[i][j] = min;
			}
		}
		return dp[1][n-1];
	}

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		MCMTab solution = new MCMTab();
		int result = solution.findMinCost(arr);
		System.out.println(result);
	}
}

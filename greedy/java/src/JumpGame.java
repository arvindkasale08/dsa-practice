public class JumpGame {

	public boolean canJump(int[] arr) {
		int n = arr.length;
		int[] dp = new int[n];
		return canJump(0, arr, dp);
	}

	private boolean canJump(int i, int[] arr, int[] dp) {
		if (i >= arr.length)
			return true;
		if (dp[i] != 0)
			return dp[i] == 1;

		int maxSteps = arr[i];
		while (maxSteps > 0) {
			if (canJump(i + maxSteps, arr, dp)) return true;
			maxSteps--;
		}
		return false;
	}

	public static void main(String[] args) {
		JumpGame solution = new JumpGame();
		int[] arr = new int[] {2, 3, 1, 1, 4};
		boolean result = solution.canJump(arr);
		System.out.println(result);
	}
}

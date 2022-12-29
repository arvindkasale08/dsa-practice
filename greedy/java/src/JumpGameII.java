import java.util.Arrays;

public class JumpGameII {

	public int jump(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		Arrays.fill(dp, -1);
		return jump(0, n, nums, dp);
	}

	private int jump(int i, int n, int[] nums, int[] dp) {
		if (i >= n-1)
			return 0;
		if (dp[i] != -1)
			return dp[i];
		int maxSteps = nums[i];
		int minSteps = 100000000;
		while (maxSteps > 0) {
			minSteps = Math.min(minSteps, 1 + jump(i+ maxSteps, n, nums, dp));
			maxSteps--;
		}
		return dp[i] = minSteps;
	}

	public static void main(String[] args) {
		JumpGameII solution = new JumpGameII();
		int[] nums = new int[] {2, 3, 1, 1, 4};
		int jumps = solution.jump(nums);
		System.out.println(jumps);
	}
}

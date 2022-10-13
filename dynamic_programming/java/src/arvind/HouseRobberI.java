package arvind;

import java.util.Arrays;

public class HouseRobberI {

    public int findMaximumSum(int[] nums, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return findMaximumSum(nums, n-1, dp);
    }

    private int findMaximumSum(int[] nums, int index, int[] dp) {
        if (index == 0)
            return nums[index];
        if (index < 0)
            return 0;
        if (dp[index] != -1) return dp[index];

        int pick = nums[index] + findMaximumSum(nums, index - 2, dp);
        int notPick = 0 + findMaximumSum(nums, index - 1, dp);

        return dp[index] = Math.max(pick, notPick);
    }

    public static void main(String[] args) {
        HouseRobberI solution = new HouseRobberI();
        int[] nums = {2, 7, 9, 3, 1};
        int n = nums.length;
        int result = solution.findMaximumSum(nums, n);
        System.out.println(result);
    }
}

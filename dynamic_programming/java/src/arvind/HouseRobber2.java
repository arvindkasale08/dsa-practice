package arvind;

import java.util.Arrays;

public class HouseRobber2 {

    public int rob(int[] nums, int n) {
        // divide nums into 2 nums 1 and nums 2;

        int[] nums1 = Arrays.copyOfRange(nums, 0 , n-1);
        int[] nums2 = Arrays.copyOfRange(nums, 1 , n);

        int sum1 = robSubset(nums1, nums1.length);
        int sum2 = robSubset(nums2, nums2.length);

        return Math.max(sum1, sum2);
    }

    private int robSubset(int[] nums, int n) {
        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i=1; i<n; i++) {
            int pick = nums[i];
            if (i > 1) {
                pick += dp[i-2];
            }
            int dontPick = 0 + dp[i-1];
            dp[i] = Math.max(pick, dontPick);
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        HouseRobber2 solution = new HouseRobber2();
        int[] nums = {1, 5, 2, 1, 6};
        int n = nums.length;
        int result = solution.rob(nums, n);
        System.out.println(result);
    }
}

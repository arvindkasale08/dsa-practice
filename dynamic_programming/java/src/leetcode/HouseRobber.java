package leetcode;

import java.util.Arrays;

public class HouseRobber {

    public int robDp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);

        for (int i=2; i<n; i++) {
            int pick = nums[i] + dp[i-2];
            // dont pick the value and move to the i+1 value
            int dontpick = 0 + dp[i-1];
            dp[i] = Math.max(pick, dontpick);
        }
        return Math.max(dp[n-1], dp[n-2]);
    }

    public int robMemo(int[] nums) {
        int n= nums.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return robMemo(0, n, nums, memo);
    }

    private int robMemo(int idx, int n, int[] nums, int[] memo) {
        if (idx >= n) {
            return 0;
        }
        if (memo[idx] != -1) {
            return memo[idx];
        }
        // pick the value and move to the i+2 value
        int pick = nums[idx] + robMemo(idx+2, n, nums, memo);
        // dont pick the value and move to the i+1 value
        int dontpick = 0 + robMemo(idx+1, n, nums, memo);
        return memo[idx] = Math.max(pick, dontpick);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 7, 9, 3, 1};
        HouseRobber solution = new HouseRobber();
        //int res = solution.robMemo(nums);
        int res = solution.robDp(nums);
        System.out.println(res);
    }
}

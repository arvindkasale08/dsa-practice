package leetcode;

import java.util.Arrays;

public class CombinationSumIV {

    public int combinationSum4DP(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target+1];
        dp[0] = 1;

        for (int t=1; t<=target; t++) {
            int count = 0;
            for (int num : nums) {
                if (t-num >= 0) {
                    count += dp[t - num];
                }
            }
            dp[t] = count;
        }
        return dp[target];
    }

    public int combinationSum4Memo(int[] nums, int target) {
        int n = nums.length;
        int[] memo = new int[target+1];
        Arrays.fill(memo, -1);
        return combinationSum4Memo(0, n, nums, target, memo);
    }

    private int combinationSum4Memo(int idx, int n, int[] nums, int target, int[] memo) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        if (memo[target] != -1) {
            return memo[target];
        }
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            count += combinationSum4Memo(idx+1, n, nums, target-nums[i], memo);
        }
        return memo[target] = count;
    }

    public static void main(String[] args) {
        CombinationSumIV solution = new CombinationSumIV();
        int[] nums = {1, 2};
        int target = 10;
        int res = solution.combinationSum4Memo(nums, target);
        int res2 = solution.combinationSum4DP(nums, target);
        System.out.println(res);
        System.out.println(res2);
    }
}

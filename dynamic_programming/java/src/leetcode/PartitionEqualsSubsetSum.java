package leetcode;

import java.util.Arrays;

public class PartitionEqualsSubsetSum {

    public boolean canPartitionDP(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[n][target+1];

        // when index = 0 only true when target == nums[idx] is only true rest all is false
        for (int i=0; i<target+1; i++) {
            if (nums[0] == i) {
                dp[0][i] = true;
            }
        }

        // when target == 0 then all is true
        for (int i=0; i<n; i++) {
            dp[i][0] = true;
        }

        for (int i=1; i<n; i++) {
            for (int j=1; j<=target; j++) {
                boolean dontPick = dp[i-1][j];
                boolean pick = false;
                if (j >= nums[i]) {
                    pick = dp[i-1][j - nums[i]];
                }

                dp[i][j] = pick || dontPick;
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public boolean canPartitionMemo(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int n = nums.length;
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        Boolean[][] memo = new Boolean[n][target+1];
        return canPartitionMemo(n-1, target, nums, memo);
    }

    private boolean canPartitionMemo(int idx, int target, int[] nums, Boolean[][] memo) {
        if (target == 0) {
            return true;
        }

        if (idx == 0) {
            return target == nums[idx];
        }

        if (memo[idx][target] != null) {
            return memo[idx][target];
        }

        boolean dontPick = canPartitionMemo(idx-1, target, nums, memo);
        boolean pick = false;
        if (target >= nums[idx]) {
            pick = canPartitionMemo(idx-1, target - nums[idx], nums, memo);
        }

        return memo[idx][target] = pick || dontPick;
    }

    public static void main(String[] args) {
        PartitionEqualsSubsetSum solution = new PartitionEqualsSubsetSum();
        int[] nums = {1, 5, 11, 5};
        boolean result = solution.canPartitionMemo(nums);
        boolean result2 = solution.canPartitionDP(nums);
        System.out.println(result);
        System.out.println(result2);
    }
}

package arvind;

import java.util.Arrays;

public class SubsetSumEqualsK {

    public boolean solve(int[] nums, int target) {
        int n = nums.length;
        Boolean[][] dp = new Boolean[n][target+1]; // 0 till nums-1 index, 0 till target
        Boolean flag = solve(nums, n-1, target, dp);
        return flag;
    }

    private boolean solve(int[] nums, int index, int target, Boolean[][] dp) {
        if (target == 0)
            return true;
        if (index == 0)
            return nums[index] == target;
        if (dp[index][target] != null) return dp[index][target];

        boolean pick = false;
        if (nums[index] <= target) {
            pick = solve(nums, index-1, target - nums[index], dp);
        }
        boolean notpick = solve(nums, index-1, target, dp);
        return dp[index][target] = pick || notpick;
    }

    public boolean solveTab(int[] nums,int target) {
        boolean[][] dp = new boolean[nums.length][target+1];
        //base case when target=0 is true

        for (int i=0; i<dp.length; i++) {
            dp[i][0] = true;
        }
        if (nums[0] < target) {
            dp[0][nums[0]] = true; // when index=0 and target = arr[0]
        }

        for (int i=1; i<dp.length; i++) {
            for (int j=1; j<dp[0].length; j++) {
                boolean pick = false;
                if (nums[i] <= j) {
                    pick = dp[i-1][j - nums[i]];
                }
                boolean notpick = dp[i-1][j];
                dp[i][j] = pick || notpick;
            }
        }

        return dp[dp.length-1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        SubsetSumEqualsK solution = new SubsetSumEqualsK();
        int[] nums = {6, 1, 2, 1};
        int target = 4;
        boolean result = solution.solve(nums, target);
        boolean result2 = solution.solveTab(nums, target);
        System.out.println(result);
        System.out.println(result2);
    }
}

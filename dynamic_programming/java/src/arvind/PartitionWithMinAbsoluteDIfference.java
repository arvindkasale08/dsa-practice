package arvind;

import java.util.Arrays;

public class PartitionWithMinAbsoluteDIfference {

    public int solve(int[] nums) {
        int target = Arrays.stream(nums).sum();
        int m = nums.length;
        int n = target + 1;
        boolean[][] dp = new boolean[m][n];

        // base cases
        for (int i =0; i<m; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;

        for (int i=1; i< m; i++) {
            for (int j=1; j<n; j++) {
                boolean notpick = dp[i-1][j];
                boolean pick = false;
                if (j >= nums[i]) {
                    pick = dp[i-1][j - nums[i]];
                }
                dp[i][j] = pick || notpick;
            }
        }

        int minDiff = Integer.MAX_VALUE;
        for (int j=0; j< dp[0].length; j++) {
            if (dp[m-1][j]) {
                minDiff = Math.min(minDiff, Math.abs(j - (target - j)));
            }
        }

        return minDiff == Integer.MAX_VALUE ? 0 : minDiff;
    }

    public static void main(String[] args) {
        int[] nums = {10};
        int result = new PartitionWithMinAbsoluteDIfference().solve(nums);
        System.out.println(result);
    }
}

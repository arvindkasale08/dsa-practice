package arvind;

public class PartitionWithEqualSubsetSum {

    public boolean exists(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        int n = nums.length;
        Boolean[][] dp = new Boolean[n][target+1];
        return exists(nums, n-1, target, dp);
    }

    private boolean exists(int[] nums, int index, int target, Boolean[][] dp) {
        if (target == 0) {
            return true;
        }
        if (index == 0) {
            return nums[index] == target;
        }
        if (dp[index][target] != null) return dp[index][target];
        boolean dontPick = exists(nums, index -1, target, dp);
        boolean pick = false;
        if (target >= nums[index]) {
            pick = exists(nums, index - 1, target - nums[index], dp);
        }
        return dp[index][target] = pick || dontPick;
    }

    public boolean existTab(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int target = sum / 2;
        int n = nums.length;
        boolean[][] dp = new boolean[n][target+1];

        //base cases
        for (int i=0; i<n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
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

        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 3, 4, 5};
        PartitionWithEqualSubsetSum solution = new PartitionWithEqualSubsetSum();
        boolean result = solution.exists(nums);
        System.out.println(result);
    }
}

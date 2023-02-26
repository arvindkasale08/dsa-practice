package neetcode;

import java.util.Arrays;

public class HouseRobberII {

    public int robMemo(int[] nums) {
        int n = nums.length;
        int[] memo1 = new int[n];
        int[] memo2 = new int[n];
        Arrays.fill(memo1, -1);
        Arrays.fill(memo2, -1);
        return Math.max(robMemo(0, n-2, nums, memo1), robMemo(1, n-1, nums, memo2));
    }

    private int robMemo(int idx, int n, int[] nums, int[] memo) {
        if (idx > n) {
            return 0;
        }
        if (memo[idx] != -1) {
            return memo[idx];
        }

        int rob = nums[idx] + robMemo(idx+2, n, nums, memo);
        int dontrob = 0 + robMemo(idx+1, n, nums, memo);
        return memo[idx] = Math.max(rob, dontrob);
    }


    public static void main(String[] args) {
        HouseRobberII solution = new HouseRobberII();
        int[] nums = new int[] {1, 2, 3, 1};
        int res = solution.robMemo(nums);
        System.out.println(res);
    }
}

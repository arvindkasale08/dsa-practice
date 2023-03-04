package neetcode;

import java.util.Arrays;

public class MaximumAlternatingSubsequenceSum {

    public long maxAlternatingSumDP(int[] nums) {
        int n = nums.length;
        long plusSum = 0;
        long minusSum = 0;

        for (int i=n-1; i>=0; i--) {
            long tempPlusSum = Math.max(plusSum, minusSum + nums[i]);
            long tempMinusSum = Math.max(minusSum, plusSum - nums[i]);
            plusSum = tempPlusSum;
            minusSum = tempMinusSum;
        }
        return plusSum;
    }

    public long maxAlternatingSumMemo(int[] nums) {
        int n = nums.length;
        long[][] memo = new long[n][2];
        for (long[] m : memo) {
            Arrays.fill(m, -1);
        }
        return maxAlternatingSumMemo(0, n, 1, nums, memo); // idx, n, isPlus, nums
    }

    private long maxAlternatingSumMemo(int idx, int n, int isPlus, int[] nums, long[][] memo) {
        if (idx >= n) {
            return 0;
        }
        if (memo[idx][isPlus] != -1) {
            return memo[idx][isPlus];
        }

        if (isPlus == 1) {
            long doNothing = 0 + maxAlternatingSumMemo(idx+1, n, 1, nums, memo);
            long takePlus = nums[idx] + maxAlternatingSumMemo(idx+1, n, 0, nums, memo);
            return memo[idx][isPlus] = Math.max(doNothing, takePlus);
        } else {
            long doNothing = 0 + maxAlternatingSumMemo(idx+1, n, 0, nums, memo);
            long takeMinus = -nums[idx] + maxAlternatingSumMemo(idx+1, n, 1, nums, memo);
            return memo[idx][isPlus] = Math.max(doNothing, takeMinus);
        }
    }

    public static void main(String[] args) {
        MaximumAlternatingSubsequenceSum solution = new MaximumAlternatingSubsequenceSum();
        int[] nums = {6,2,1,2,4,5};
        long res = solution.maxAlternatingSumMemo(nums);
        long res2 = solution.maxAlternatingSumDP(nums);
        System.out.println(res);
        System.out.println(res2);
    }
}

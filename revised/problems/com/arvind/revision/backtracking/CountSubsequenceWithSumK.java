package com.arvind.revision.backtracking;

public class CountSubsequenceWithSumK {

    public int countSubsequenceWithTargetSum(int[] nums, int target) {
       return countSubsequenceWithTargetSumInner(0, nums.length, 0, nums, target);
    }

    private int countSubsequenceWithTargetSumInner(int idx, int n, int currSum, int[] nums, int target) {
        if (idx == n) {
            if (currSum == target) return 1;
            return 0;
        }
        if (currSum == target) return 1;

        return countSubsequenceWithTargetSumInner(idx+1, n, currSum + nums[idx], nums, target) +
                countSubsequenceWithTargetSumInner(idx+1, n, currSum, nums, target);
    }

    public static void main(String[] args) {
        CountSubsequenceWithSumK solution = new CountSubsequenceWithSumK();

        runTest(solution, new int[] {4, 9, 2, 5, 1}, 10, 2,
                "[9, 1] and [4, 5, 1]");
        runTest(solution, new int[] {4, 2, 10, 5, 1, 3}, 5, 3,
                "[4, 1], [2, 3], and [5]");
        runTest(solution, new int[] {1, 2, 3}, 3, 2,
                "[1, 2] and [3]");
        runTest(solution, new int[] {1, 1, 1}, 2, 3,
                "three index-based ways to pick two 1s");
        runTest(solution, new int[] {2, 4, 6}, 5, 0,
                "no subsequence sums to 5");
        runTest(solution, new int[] {5}, 5, 1,
                "single element equals target");
    }

    private static void runTest(CountSubsequenceWithSumK solution, int[] nums, int target, int expected,
                                String explanation) {
        int actual = solution.countSubsequenceWithTargetSum(nums, target);
        String status = actual == expected ? "✅ PASS" : "❌ FAIL";
        System.out.printf("%s nums=%s target=%d expected=%d actual=%d (%s)%n",
                status, java.util.Arrays.toString(nums), target, expected, actual, explanation);
    }
}

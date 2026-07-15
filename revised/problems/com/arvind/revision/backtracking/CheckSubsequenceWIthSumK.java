package com.arvind.revision.backtracking;

public class CheckSubsequenceWIthSumK {

    public boolean checkSubsequenceSum(int[] nums, int target) {
        return checkSubsequenceSumInner(0, 0, nums, target);
    }

    private boolean checkSubsequenceSumInner(int idx, int sum, int[] nums, int target) {
        if (idx == nums.length) {
            return sum == target;
        }

        return checkSubsequenceSumInner(idx+1, sum + nums[idx], nums, target) ||
                checkSubsequenceSumInner(idx+1, sum, nums, target);
    }

    public static void main(String[] args) {
        CheckSubsequenceWIthSumK solution = new CheckSubsequenceWIthSumK();

        int[] nums1 = new int[] {1, 2, 3, 4, 5};
        boolean actual1 = solution.checkSubsequenceSum(nums1, 8);
        System.out.printf("%s nums=%s target=%d expected=%s actual=%s (%s)%n",
                actual1 == true ? "✅ PASS" : "❌ FAIL",
                java.util.Arrays.toString(nums1), 8, true, actual1, "[1, 2, 5], [1, 3, 4], or [3, 5]");

        int[] nums2 = new int[] {4, 3, 9, 2};
        boolean actual2 = solution.checkSubsequenceSum(nums2, 10);
        System.out.printf("%s nums=%s target=%d expected=%s actual=%s (%s)%n",
                actual2 == false ? "✅ PASS" : "❌ FAIL",
                java.util.Arrays.toString(nums2), 10, false, actual2, "no subsequence sums to 10");

        int[] nums3 = new int[] {4, 9, 2, 5, 1};
        boolean actual3 = solution.checkSubsequenceSum(nums3, 10);
        System.out.printf("%s nums=%s target=%d expected=%s actual=%s (%s)%n",
                actual3 == true ? "✅ PASS" : "❌ FAIL",
                java.util.Arrays.toString(nums3), 10, true, actual3, "[9, 1] or [4, 5, 1]");

        int[] nums4 = new int[] {2, 4, 6};
        boolean actual4 = solution.checkSubsequenceSum(nums4, 5);
        System.out.printf("%s nums=%s target=%d expected=%s actual=%s (%s)%n",
                actual4 == false ? "✅ PASS" : "❌ FAIL",
                java.util.Arrays.toString(nums4), 5, false, actual4, "no matching subsequence");

        int[] nums5 = new int[] {5};
        boolean actual5 = solution.checkSubsequenceSum(nums5, 5);
        System.out.printf("%s nums=%s target=%d expected=%s actual=%s (%s)%n",
                actual5 == true ? "✅ PASS" : "❌ FAIL",
                java.util.Arrays.toString(nums5), 5, true, actual5, "single element equals target");

        int[] nums6 = new int[] {};
        boolean actual6 = solution.checkSubsequenceSum(nums6, 0);
        System.out.printf("%s nums=%s target=%d expected=%s actual=%s (%s)%n",
                actual6 == true ? "✅ PASS" : "❌ FAIL",
                java.util.Arrays.toString(nums6), 0, true, actual6, "empty subsequence sums to 0");
    }
}

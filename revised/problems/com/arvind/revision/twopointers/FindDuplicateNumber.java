package com.arvind.revision.twopointers;

public class FindDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (slow == fast) break;
        }

        slow = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[fast];
            if (slow == fast) break;
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,3,4,2,2};
        FindDuplicateNumber solution = new FindDuplicateNumber();
        System.out.println(solution.findDuplicate(nums));
    }
}

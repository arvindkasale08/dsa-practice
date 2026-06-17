package com.arvind.revision.stacks;

import java.util.Stack;

public class OneThreeTwoPattern {

    public boolean find132pattern(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {nums[0], Integer.MAX_VALUE});

        for (int i=1; i< nums.length; i++) {
            int curr = nums[i];
            int poppedVal = stack.peek()[0];
            int poppedMin = stack.peek()[1];
            while (!stack.isEmpty() && stack.peek()[0] < curr) {
                stack.pop();
            }
            int j = stack.isEmpty() ? Integer.MIN_VALUE : stack.peek()[0];
            int min2 = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek()[1];

            if (curr > min2 && curr < j) {
                return true;
            }
            stack.push(new int[] {curr, Math.min(poppedMin, poppedVal)});
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 5, 0, 3, 4};
        int[] nums2 = new int[] {3, 1, 4, 2};
        int[] nums3 = new int[] {-1, 3, 2, 0};
        OneThreeTwoPattern solution = new OneThreeTwoPattern();
        System.out.println(solution.find132pattern(nums));
        System.out.println(solution.find132pattern(nums2));
        System.out.println(solution.find132pattern(nums3));
    }
}

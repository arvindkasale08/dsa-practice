package com.arvind.revision.stacks;

import java.util.Stack;

public class MaximumWidthRamp {

    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int maxWidth = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        // make a strictly decreasing monotonic stack
        for (int i=1; i<n; i++) {
            if (nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        // move from right to left and find the max width from monotonic stack
        for (int i=n-1; i>=0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                maxWidth = Math.max(maxWidth, (i-stack.pop()));
            }
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {6, 0, 8, 2, 1, 5};
        int[] arr2 = new int[] {9,8,1,0,1,9,4,0,4,1};
        MaximumWidthRamp solution = new MaximumWidthRamp();
        System.out.println(solution.maxWidthRamp(arr));
        System.out.println(solution.maxWidthRamp(arr2));
    }
}

package com.arvind.revision.stacks;

import java.util.Stack;

public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ip = new int[n*2];
        int[] tmp = new int[n*2];
        int[] op = new int[n];
        Stack<Integer> stack = new Stack<>();

        // populate ip array from nums
        for (int i=0; i< n; i++) {
            ip[i] = nums[i];
            ip[i+n] = nums[i];
        }
        // pre seed last
        stack.push(ip[n-1]);
        for (int i=ip.length - 2; i>=0; i--) {
            int curr = ip[i];
            while (!stack.isEmpty() && stack.peek() <= curr) {
                stack.pop();
            }
            tmp[i] = stack.isEmpty() ? -1: stack.peek();
            stack.push(curr);
        }

        for (int i=0; i < n; i++) {
            op[i] = tmp[i];
        }

        return op;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2, 1};
        int[] nums2 = new int[] {1, 2, 3, 4, 3};
        NextGreaterElementII solution = new NextGreaterElementII();
        int[] res1 = solution.nextGreaterElements(nums1);
        int[] res2 = solution.nextGreaterElements(nums2);

        for (int r : res1) {
            System.out.print(r + ", ");
        }
        System.out.println("\n#####################");
        for (int r : res2) {
            System.out.print(r + ", ");
        }
    }
}

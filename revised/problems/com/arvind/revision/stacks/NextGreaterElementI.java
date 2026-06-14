package com.arvind.revision.stacks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> bank = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        // initialize
        int rightMost = nums2[nums2.length - 1];
        stack.push(rightMost);
        bank.put(rightMost, -1);
        for (int i= nums2.length - 2; i >= 0; i--) {
            int curr = nums2[i];
            while (!stack.isEmpty() && stack.peek() < curr) {
                stack.pop();
            }
            bank.put(curr, stack.isEmpty() ? -1 : stack.peek());
            stack.push(curr);
        }
        for (int i=0; i< nums1.length; i++) {
            res[i] = bank.get(nums1[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {4, 1, 2};
        int[] nums2 = new int[] {1, 3, 4, 2};
        NextGreaterElementI solution = new NextGreaterElementI();
        int[] res = solution.nextGreaterElement(nums1, nums2);
        for (int r : res) {
            System.out.print(r + ", ");
        }
    }
}

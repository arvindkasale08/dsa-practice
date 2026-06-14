package com.arvind.revision.stacks;

import java.util.Stack;

public class SumOfSubarrayMinimums {

    private final int MOD = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        long score = 0l;
        int[] leftDist = new int[arr.length];
        int[] rightDist = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        // populate the left distance
        for (int i=0; i<arr.length; i++) {
            if (stack.isEmpty()) {
                leftDist[i] = -1;
                stack.push(i);
            } else {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    stack.pop();
                }
                leftDist[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }
        }
        stack = new Stack<>();

        // populate the right distance
        for (int i= arr.length - 1; i >=0; i--) {
            if (stack.isEmpty()) {
                rightDist[i] = arr.length;
                stack.push(i);
            } else {
                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    stack.pop();
                }
                rightDist[i] = stack.isEmpty() ? arr.length : stack.peek();
                stack.push(i);
            }
        }

        for (int i=0; i< arr.length; i++) {
            long contribution = (long) arr[i] * (i - leftDist[i]) * (rightDist[i] - i);
            score = (score + contribution) % MOD;
        }

        return (int) score;
    }

    public static void main(String[] args) {
        //int[] arr = new int[] {3, 1, 2, 4};
        //int[] arr2 = new int[] {11, 81, 94, 43, 3};
        int[] arr3 = new int[] {1, 1};
        SumOfSubarrayMinimums solution = new SumOfSubarrayMinimums();
        System.out.println(solution.sumSubarrayMins(arr3));
        //System.out.println(solution.sumSubarrayMins(arr));
        //System.out.println(solution.sumSubarrayMins(arr2));
    }
}

package neetcode;

import java.util.Stack;

public class OneThreeTwoPattern {

    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[] {nums[0], Integer.MAX_VALUE});

        for (int i=1; i<n; i++) {
            int min = stack.peek()[1];
            int var = stack.peek()[0];
            int k = nums[i];

            while (!stack.isEmpty() && stack.peek()[0] < k) {
                stack.pop();
            }
            int j = stack.isEmpty() ? Integer.MIN_VALUE : stack.peek()[0];
            int min2 = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek()[1];

            if (k > min2 && k < j) {
                return true;
            }
            stack.push(new int[] {k, Math.min(min, var)});
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 0, 3, 4};

        OneThreeTwoPattern solution = new OneThreeTwoPattern();
        boolean result = solution.find132pattern(nums);
        System.out.println(result);
    }
}

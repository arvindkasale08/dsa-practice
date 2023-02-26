package neetcode;

import java.util.Stack;

public class MaximumSubarrayMinProduct {

    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i=1; i<n; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        int max_result = Integer.MIN_VALUE;
        Stack<int[]> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            int newStart = i;
            while (!stack.isEmpty() && stack.peek()[0] > nums[i]) {
                int[] node = stack.pop();
                int val = node[0];
                int start = node[1];
                int product = val * (prefixSum[i-1] - (start == 0 ? 0 : prefixSum[start-1]));
                max_result = Math.max(product, max_result);
                newStart = start;
            }
            stack.push(new int[] {nums[i], newStart});
        }

        // remaining values
        while (!stack.isEmpty()) {
            int[] node = stack.pop();
            int val = node[0];
            int start = node[1];
            int product = val * (prefixSum[n-1] - (start == 0 ? 0 : prefixSum[start-1]));
            max_result = Math.max(product, max_result);
        }

        return max_result % 1_000_000_007;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2 };
        MaximumSubarrayMinProduct solution = new MaximumSubarrayMinProduct();
        int res = solution.maxSumMinProduct(nums);
        System.out.println(res);
    }
}

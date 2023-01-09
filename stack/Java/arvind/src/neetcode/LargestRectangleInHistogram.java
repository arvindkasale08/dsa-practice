package neetcode;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;
        for (int i=0; i<n; i++) {
            int height = heights[i];
            int index = i;
            while (!stack.isEmpty() && stack.peek()[0] > height) {
                int[] popped = stack.pop();
                index = popped[1];
                maxArea = Math.max( popped[0] * (i-index), maxArea);
            }
            stack.push(new int[] {height, index});
        }
        while (!stack.isEmpty()) {
            int[] popped = stack.pop();
            maxArea = Math.max( popped[0] * (n-popped[1]), maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = new int[] {2, 1, 5, 6, 2, 3};
        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();
        int result = solution.largestRectangleArea(heights);
        System.out.println(result);
    }
}
